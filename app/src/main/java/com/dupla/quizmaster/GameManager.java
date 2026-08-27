package com.dupla.quizmaster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GameManager {

    public static final String MATERIA_PORTUGUES = "Portugues";
    public static final String MATERIA_MATEMATICA = "Matematica";

    private static GameManager instancia;

    private String nomeJogador = "";

    private boolean usarPortugues = true;
    private boolean usarMatematica = true;
    private int quantidadePortugues = 5;
    private int quantidadeMatematica = 5;
    private int tempoPorQuestaoSegundos = 30;

    private List<Questao> questoesDaPartida = new ArrayList<>();
    private int indiceQuestaoAtual = 0;

    private int acertosGeral = 0;
    private int errosGeral = 0;
    private int acertosPortugues = 0;
    private int acertosMatematica = 0;

    private GameManager() {
    }

    public static GameManager getInstancia() {
        if (instancia == null) {
            instancia = new GameManager();
        }
        return instancia;
    }

    // ---- Dados vindos da Tela 1 ----

    public void setNomeJogador(String nome) {
        this.nomeJogador = nome;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    // ---- Dados vindos da Tela 2 ----

    public void configurarPartida(boolean usarPortugues, int quantidadePortugues,
                                  boolean usarMatematica, int quantidadeMatematica,
                                  int tempoPorQuestaoSegundos) {
        this.usarPortugues = usarPortugues;
        this.quantidadePortugues = quantidadePortugues;
        this.usarMatematica = usarMatematica;
        this.quantidadeMatematica = quantidadeMatematica;
        this.tempoPorQuestaoSegundos = tempoPorQuestaoSegundos;
    }

    public boolean isUsarPortugues() {
        return usarPortugues;
    }

    public boolean isUsarMatematica() {
        return usarMatematica;
    }

    public int getQuantidadePortugues() {
        return quantidadePortugues;
    }

    public int getQuantidadeMatematica() {
        return quantidadeMatematica;
    }

    public int getTempoPorQuestaoSegundos() {
        return tempoPorQuestaoSegundos;
    }

    public static int getTotalDisponivel(String materia) {
        return BancoQuestoes.obterQuestoes(materia).size();
    }

    // ---- Execucao da partida (Tela 3) ----

    public void iniciarNovaPartida() {
        questoesDaPartida = new ArrayList<>();

        if (usarPortugues && quantidadePortugues > 0) {
            List<Questao> lista = new ArrayList<>(BancoQuestoes.obterQuestoes(MATERIA_PORTUGUES));
            Collections.shuffle(lista);
            questoesDaPartida.addAll(lista.subList(0, Math.min(quantidadePortugues, lista.size())));
        }

        if (usarMatematica && quantidadeMatematica > 0) {
            List<Questao> lista = new ArrayList<>(BancoQuestoes.obterQuestoes(MATERIA_MATEMATICA));
            Collections.shuffle(lista);
            questoesDaPartida.addAll(lista.subList(0, Math.min(quantidadeMatematica, lista.size())));
        }

        Collections.shuffle(questoesDaPartida);

        indiceQuestaoAtual = 0;
        acertosGeral = 0;
        errosGeral = 0;
        acertosPortugues = 0;
        acertosMatematica = 0;
    }

    public Questao getQuestaoAtual() {
        if (indiceQuestaoAtual < questoesDaPartida.size()) {
            return questoesDaPartida.get(indiceQuestaoAtual);
        }
        return null;
    }

    public int getNumeroQuestaoAtual() {
        return indiceQuestaoAtual + 1;
    }

    public int getTotalQuestoes() {
        return questoesDaPartida.size();
    }

    public boolean temProximaQuestao() {
        return indiceQuestaoAtual + 1 < questoesDaPartida.size();
    }

    /**
     * Registra a resposta da questao atual.
     * @param indiceAlternativaEscolhida indice da alternativa marcada,
     *                                    ou -1 se o tempo acabou sem resposta.
     * @return true se acertou, false se errou.
     */
    public boolean responderQuestaoAtual(int indiceAlternativaEscolhida) {
        Questao atual = getQuestaoAtual();
        boolean acertou = atual != null && atual.isRespostaCorreta(indiceAlternativaEscolhida);

        if (acertou) {
            acertosGeral++;
            if (MATERIA_PORTUGUES.equals(atual.getMateria())) {
                acertosPortugues++;
            } else if (MATERIA_MATEMATICA.equals(atual.getMateria())) {
                acertosMatematica++;
            }
        } else {
            errosGeral++;
        }

        return acertou;
    }

    public void avancarQuestao() {
        indiceQuestaoAtual++;
    }

    // ---- Resultado (Tela 4) ----

    public int getAcertosGeral() {
        return acertosGeral;
    }

    public int getErrosGeral() {
        return errosGeral;
    }

    public int getAcertosPortugues() {
        return acertosPortugues;
    }

    public int getAcertosMatematica() {
        return acertosMatematica;
    }

    public int getTotalPortuguesNaPartida() {
        return usarPortugues ? Math.min(quantidadePortugues, getTotalDisponivel(MATERIA_PORTUGUES)) : 0;
    }

    public int getTotalMatematicaNaPartida() {
        return usarMatematica ? Math.min(quantidadeMatematica, getTotalDisponivel(MATERIA_MATEMATICA)) : 0;
    }
}