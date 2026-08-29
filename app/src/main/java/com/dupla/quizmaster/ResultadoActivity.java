package com.dupla.quizmaster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        TextView textAcertos = findViewById(R.id.text_acertos);
        TextView textErros = findViewById(R.id.text_erros);
        TextView textResultadoPortugues = findViewById(R.id.text_resultado_portugues);
        TextView textResultadoMatematica = findViewById(R.id.text_resultado_matematica);
        Button botaoJogarNovamente = findViewById(R.id.btn_jogar_novamente);
        Button botaoConfig = findViewById(R.id.btn_config);
        Button botaoInicio = findViewById(R.id.btn_inicio);

        GameManager gameManager = GameManager.getInstancia();

        textAcertos.setText(getString(R.string.formato_acertos, gameManager.getAcertosGeral()));
        textErros.setText(getString(R.string.formato_erros, gameManager.getErrosGeral()));

        if (gameManager.isUsarPortugues()) {
            int total = gameManager.getTotalPortuguesNaPartida();
            int acertos = gameManager.getAcertosPortugues();
            int percentual = total > 0 ? (acertos * 100) / total : 0;
            textResultadoPortugues.setText(getString(R.string.formato_desempenho_materia,
                    getString(R.string.materia_portugues), acertos, total, percentual));
        } else {
            textResultadoPortugues.setVisibility(View.GONE);
        }

        if (gameManager.isUsarMatematica()) {
            int total = gameManager.getTotalMatematicaNaPartida();
            int acertos = gameManager.getAcertosMatematica();
            int percentual = total > 0 ? (acertos * 100) / total : 0;
            textResultadoMatematica.setText(getString(R.string.formato_desempenho_materia,
                    getString(R.string.materia_matematica), acertos, total, percentual));
        } else {
            textResultadoMatematica.setVisibility(View.GONE);
        }

        botaoJogarNovamente.setOnClickListener(v -> {
            gameManager.iniciarNovaPartida();
            startActivity(new Intent(this, QuizActivity.class));
            finish();
        });

        botaoConfig.setOnClickListener(v -> {
            startActivity(new Intent(this, ConfiguracaoActivity.class));
            finish();
        });

        botaoInicio.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });
    }
}