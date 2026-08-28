package com.dupla.quizmaster;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConfiguracaoActivity extends AppCompatActivity {

    private static final int QUANTIDADE_MINIMA = 1;
    private static final int TEMPO_MINIMO = 10;
    private static final int TEMPO_MAXIMO = 60;
    private static final int PASSO_TEMPO = 5;

    private CheckBox checkPortugues;
    private CheckBox checkMatematica;
    private TextView textQuantidadePortugues;
    private TextView textQuantidadeMatematica;
    private TextView textTempo;

    private int quantidadePortugues = 5;
    private int quantidadeMatematica = 5;
    private int tempoPorQuestao = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao);

        checkPortugues = findViewById(R.id.check_portugues);
        checkMatematica = findViewById(R.id.check_matematica);
        textQuantidadePortugues = findViewById(R.id.text_quantidade_portugues);
        textQuantidadeMatematica = findViewById(R.id.text_quantidade_matematica);
        textTempo = findViewById(R.id.text_tempo);

        Button botaoMenosPortugues = findViewById(R.id.btn_menos_portugues);
        Button botaoMaisPortugues = findViewById(R.id.btn_mais_portugues);
        Button botaoMenosMatematica = findViewById(R.id.btn_menos_matematica);
        Button botaoMaisMatematica = findViewById(R.id.btn_mais_matematica);
        Button botaoMenosTempo = findViewById(R.id.btn_menos_tempo);
        Button botaoMaisTempo = findViewById(R.id.btn_mais_tempo);
        Button botaoJogar = findViewById(R.id.btn_jogar);

        atualizarTextos();

        botaoMenosPortugues.setOnClickListener(v -> {
            if (quantidadePortugues > QUANTIDADE_MINIMA) {
                quantidadePortugues--;
                atualizarTextos();
            }
        });

        botaoMaisPortugues.setOnClickListener(v -> {
            if (quantidadePortugues < GameManager.getTotalDisponivel(GameManager.MATERIA_PORTUGUES)) {
                quantidadePortugues++;
                atualizarTextos();
            }
        });

        botaoMenosMatematica.setOnClickListener(v -> {
            if (quantidadeMatematica > QUANTIDADE_MINIMA) {
                quantidadeMatematica--;
                atualizarTextos();
            }
        });

        botaoMaisMatematica.setOnClickListener(v -> {
            if (quantidadeMatematica < GameManager.getTotalDisponivel(GameManager.MATERIA_MATEMATICA)) {
                quantidadeMatematica++;
                atualizarTextos();
            }
        });

        botaoMenosTempo.setOnClickListener(v -> {
            if (tempoPorQuestao > TEMPO_MINIMO) {
                tempoPorQuestao -= PASSO_TEMPO;
                atualizarTextos();
            }
        });

        botaoMaisTempo.setOnClickListener(v -> {
            if (tempoPorQuestao < TEMPO_MAXIMO) {
                tempoPorQuestao += PASSO_TEMPO;
                atualizarTextos();
            }
        });

        botaoJogar.setOnClickListener(v -> tentarJogar());
    }

    private void atualizarTextos() {
        textQuantidadePortugues.setText(String.valueOf(quantidadePortugues));
        textQuantidadeMatematica.setText(String.valueOf(quantidadeMatematica));
        textTempo.setText(getString(R.string.formato_segundos, tempoPorQuestao));
    }

    private void tentarJogar() {
        boolean usarPortugues = checkPortugues.isChecked();
        boolean usarMatematica = checkMatematica.isChecked();

        if (!usarPortugues && !usarMatematica) {
            Toast.makeText(this, R.string.mensagem_selecionar_materia, Toast.LENGTH_SHORT).show();
            return;
        }

        if (usarPortugues && quantidadePortugues < QUANTIDADE_MINIMA) {
            Toast.makeText(this, R.string.mensagem_quantidade_invalida, Toast.LENGTH_SHORT).show();
            return;
        }

        if (usarMatematica && quantidadeMatematica < QUANTIDADE_MINIMA) {
            Toast.makeText(this, R.string.mensagem_quantidade_invalida, Toast.LENGTH_SHORT).show();
            return;
        }

        GameManager.getInstancia().configurarPartida(
                usarPortugues, quantidadePortugues,
                usarMatematica, quantidadeMatematica,
                tempoPorQuestao);

        GameManager.getInstancia().iniciarNovaPartida();

        startActivity(new Intent(this, QuizActivity.class));
    }
}