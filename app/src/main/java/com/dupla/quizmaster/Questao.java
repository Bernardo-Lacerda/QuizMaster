package com.dupla.quizmaster;

public class Questao {

    private final int id;
    private final String materia;
    private final String pergunta;
    private final String[] alternativas;
    private final int respostaCorreta; // indice da alternativa correta, comecando em 0

    public Questao(int id, String materia, String pergunta, String[] alternativas, int respostaCorreta) {
        this.id = id;
        this.materia = materia;
        this.pergunta = pergunta;
        this.alternativas = alternativas;
        this.respostaCorreta = respostaCorreta;
    }

    public int getId() {
        return id;
    }

    public String getMateria() {
        return materia;
    }

    public String getPergunta() {
        return pergunta;
    }

    public String[] getAlternativas() {
        return alternativas;
    }

    public int getRespostaCorreta() {
        return respostaCorreta;
    }

    public boolean isRespostaCorreta(int alternativaEscolhida) {
        return alternativaEscolhida == respostaCorreta;
    }
}