package com.dupla.quizmaster;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private TextView textTempo;
    private TextView textNumeroQuestao;
    private TextView textPergunta;
    private RadioGroup radioGroupAlternativas;
    private RadioButton radioAltA;
    private RadioButton radioAltB;
    private RadioButton radioAltC;
    private RadioButton radioAltD;
    private Button botaoConfirmar;
    private TextView textFeedback;

    private CountDownTimer cronometro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textTempo = findViewById(R.id.text_tempo);
        textNumeroQuestao = findViewById(R.id.text_numero_questao);
        textPergunta = findViewById(R.id.text_pergunta);
        radioGroupAlternativas = findViewById(R.id.radio_group_alternativas);
        radioAltA = findViewById(R.id.radio_alt_a);
        radioAltB = findViewById(R.id.radio_alt_b);
        radioAltC = findViewById(R.id.radio_alt_c);
        radioAltD = findViewById(R.id.radio_alt_d);
        botaoConfirmar = findViewById(R.id.btn_confirmar);
        textFeedback = findViewById(R.id.text_feedback);

        botaoConfirmar.setOnClickListener(v -> confirmarResposta());

        exibirQuestaoAtual();
    }

    private void exibirQuestaoAtual() {
        Questao questao = GameManager.getInstancia().getQuestaoAtual();

        if (questao == null) {
            irParaResultado();
            return;
        }

        textNumeroQuestao.setText(getString(R.string.formato_numero_questao,
                GameManager.getInstancia().getNumeroQuestaoAtual(),
                GameManager.getInstancia().getTotalQuestoes()));
        textPergunta.setText(questao.getPergunta());

        String[] alternativas = questao.getAlternativas();
        radioAltA.setText(alternativas[0]);
        radioAltB.setText(alternativas[1]);
        radioAltC.setText(alternativas[2]);
        radioAltD.setText(alternativas[3]);

        radioGroupAlternativas.clearCheck();
        textFeedback.setVisibility(View.GONE);
        habilitarRespostas(true);

        iniciarCronometro();
    }

    private void iniciarCronometro() {
        if (cronometro != null) {
            cronometro.cancel();
        }

        long tempoTotalMillis = GameManager.getInstancia().getTempoPorQuestaoSegundos() * 1000L;

        cronometro = new CountDownTimer(tempoTotalMillis, 1000) {
            @Override
            public void onTick(long millisRestantes) {
                atualizarTextoTempo(millisRestantes);
            }

            @Override
            public void onFinish() {
                atualizarTextoTempo(0);
                processarResposta(-1);
            }
        };
        cronometro.start();
    }

    private void atualizarTextoTempo(long millisRestantes) {
        int segundosTotais = (int) (millisRestantes / 1000);
        int minutos = segundosTotais / 60;
        int segundos = segundosTotais % 60;
        textTempo.setText(getString(R.string.formato_tempo, minutos, segundos));
    }

    private void confirmarResposta() {
        int idSelecionado = radioGroupAlternativas.getCheckedRadioButtonId();

        if (idSelecionado == -1) {
            Toast.makeText(this, R.string.mensagem_selecionar_alternativa, Toast.LENGTH_SHORT).show();
            return;
        }

        int indiceEscolhido;
        if (idSelecionado == R.id.radio_alt_a) {
            indiceEscolhido = 0;
        } else if (idSelecionado == R.id.radio_alt_b) {
            indiceEscolhido = 1;
        } else if (idSelecionado == R.id.radio_alt_c) {
            indiceEscolhido = 2;
        } else {
            indiceEscolhido = 3;
        }

        processarResposta(indiceEscolhido);
    }

    private void processarResposta(int indiceEscolhido) {
        if (cronometro != null) {
            cronometro.cancel();
        }

        habilitarRespostas(false);

        Questao questao = GameManager.getInstancia().getQuestaoAtual();
        boolean acertou = GameManager.getInstancia().responderQuestaoAtual(indiceEscolhido);
        String respostaCorreta = questao.getAlternativas()[questao.getRespostaCorreta()];

        if (acertou) {
            textFeedback.setText(getString(R.string.feedback_acertou, respostaCorreta));
        } else {
            textFeedback.setText(getString(R.string.feedback_errou, respostaCorreta));
        }
        textFeedback.setVisibility(View.VISIBLE);

        new Handler(Looper.getMainLooper()).postDelayed(this::avancarQuestao, 1500);
    }

    private void avancarQuestao() {
        GameManager.getInstancia().avancarQuestao();
        exibirQuestaoAtual();
    }

    private void irParaResultado() {
        startActivity(new Intent(this, ResultadoActivity.class));
        finish();
    }

    private void habilitarRespostas(boolean habilitado) {
        radioAltA.setEnabled(habilitado);
        radioAltB.setEnabled(habilitado);
        radioAltC.setEnabled(habilitado);
        radioAltD.setEnabled(habilitado);
        botaoConfirmar.setEnabled(habilitado);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (cronometro != null) {
            cronometro.cancel();
        }
    }
}