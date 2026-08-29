package com.dupla.quizmaster;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editNomeJogador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationHelper.criarCanal(this);
        solicitarPermissaoNotificacaoSeNecessario();

        editNomeJogador = findViewById(R.id.edit_nome_jogador);
        Button botaoEntrar = findViewById(R.id.btn_entrar);
        Button botaoSair = findViewById(R.id.btn_sair);

        botaoEntrar.setOnClickListener(v -> tentarEntrar());
        botaoSair.setOnClickListener(v -> finishAffinity());
    }

    private void solicitarPermissaoNotificacaoSeNecessario() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU
                && ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 1);
        }
    }

    private void tentarEntrar() {
        String nome = editNomeJogador.getText().toString().trim();

        if (nome.isEmpty()) {
            Toast.makeText(this, R.string.mensagem_nome_vazio, Toast.LENGTH_SHORT).show();
            return;
        }

        GameManager.getInstancia().setNomeJogador(nome);
        startActivity(new Intent(this, ConfiguracaoActivity.class));
    }
}