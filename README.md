# QuizMaster

Dupla: Bernardo Lacerda e Ana Gabriela

## Descrição

Aplicativo de quiz educacional para Android, desenvolvido em Java. O jogador configura uma partida escolhendo matérias (Português e/ou Matemática), quantidade de perguntas por matéria e tempo por questão, responde a um quiz com alternativas estilo ENEM (5 opções, A a E) dentro do tempo definido, e recebe o resultado detalhado ao final, com notificação do sistema Android.

## Telas

1. **Início**: campo para nome do jogador, botão para iniciar e botão para sair do app.
2. **Configuração**: seleção de matérias, quantidade de questões por matéria e tempo por questão.
3. **Quiz**: exibe a questão atual, cronômetro regressivo, 5 alternativas (A a E) e botão de confirmar resposta. Avança automaticamente para a próxima questão após a resposta ou o fim do tempo.
4. **Resultado**: mostra total de acertos e erros, desempenho por matéria, e opções de jogar novamente, voltar à configuração ou voltar ao início.

## Funcionalidades implementadas

- Navegação entre 4 telas distintas
- Configuração de partida (matérias, quantidade de questões, tempo)
- Cronômetro por questão com avanço automático ao esgotar o tempo
- Pontuação geral e por matéria, atualizada em tempo real
- Banco de questões próprio, no formato ENEM, com 5 alternativas
- Notificação do sistema Android ao final da partida, que abre o app ao ser tocada
- Opção de jogar novamente sem fechar o aplicativo

## Tecnologias

- Java
- Android SDK (minSdk 24)
- Activities e Layouts XML (LinearLayout)
- CountDownTimer
- NotificationManager / NotificationCompat

## Como executar

1. Abrir o projeto no Android Studio
2. Aguardar o Gradle sincronizar
3. Rodar em um emulador ou dispositivo físico (Run > Run 'app')

Ou instalar diretamente o APK gerado em `app/build/outputs/apk/debug/app-debug.apk`.