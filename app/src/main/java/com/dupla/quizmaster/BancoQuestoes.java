package com.dupla.quizmaster;

import java.util.ArrayList;
import java.util.List;

public class BancoQuestoes {

    public static List<Questao> obterQuestoes(String materia) {
        if (GameManager.MATERIA_PORTUGUES.equals(materia)) {
            return questoesPortugues();
        } else {
            return questoesMatematica();
        }
    }

    private static List<Questao> questoesPortugues() {
        List<Questao> lista = new ArrayList<>();
        lista.add(new Questao(1, "Portugues", "Qual destas palavras é um substantivo?",
                new String[]{"rapidamente", "bonito", "escola", "correr"}, 2));
        lista.add(new Questao(2, "Portugues", "Assinale o antônimo de \"alegre\":",
                new String[]{"feliz", "triste", "contente", "animado"}, 1));
        lista.add(new Questao(3, "Portugues", "Qual é o plural correto de \"papel\"?",
                new String[]{"papels", "papeles", "papéis", "papeus"}, 2));
        lista.add(new Questao(4, "Portugues", "Em \"Maria comprou um livro\", qual é o sujeito da oração?",
                new String[]{"comprou", "um livro", "Maria", "livro"}, 2));
        lista.add(new Questao(5, "Portugues", "Assinale a alternativa com erro de ortografia:",
                new String[]{"exceção", "nescessário", "cadeira", "professor"}, 1));
        lista.add(new Questao(6, "Portugues", "Qual destas é uma conjunção?",
                new String[]{"rápido", "mas", "casa", "cantar"}, 1));
        lista.add(new Questao(7, "Portugues", "O plural de \"animal\" é:",
                new String[]{"animais", "animals", "animales", "animalles"}, 0));
        lista.add(new Questao(8, "Portugues", "Assinale o sinônimo de \"veloz\":",
                new String[]{"lento", "rápido", "triste", "fraco"}, 1));
        lista.add(new Questao(9, "Portugues", "Qual é o feminino de \"professor\"?",
                new String[]{"professor", "professora", "professoro", "professoria"}, 1));
        lista.add(new Questao(10, "Portugues", "Em \"Os alunos estudaram muito\", a palavra \"muito\" é um(a):",
                new String[]{"substantivo", "advérbio", "verbo", "artigo"}, 1));
        lista.add(new Questao(11, "Portugues", "Assinale a alternativa correta quanto à acentuação:",
                new String[]{"árvore", "arvore", "arvóre", "árvóre"}, 0));
        lista.add(new Questao(12, "Portugues", "Qual destas palavras é um verbo?",
                new String[]{"bonito", "cadeira", "correr", "rápido"}, 2));
        lista.add(new Questao(13, "Portugues", "O aumentativo de \"casa\" é:",
                new String[]{"casinha", "casarão", "casinho", "casita"}, 1));
        lista.add(new Questao(14, "Portugues", "Assinale o artigo definido:",
                new String[]{"um", "uma", "o", "algum"}, 2));
        lista.add(new Questao(15, "Portugues", "Qual é o diminutivo de \"livro\"?",
                new String[]{"livrinho", "livrão", "livreco", "livrete"}, 0));
        return lista;
    }

    private static List<Questao> questoesMatematica() {
        List<Questao> lista = new ArrayList<>();
        lista.add(new Questao(101, "Matematica", "Quanto é 8 x 7?",
                new String[]{"48", "54", "56", "64"}, 2));
        lista.add(new Questao(102, "Matematica", "Quanto é 15 + 27?",
                new String[]{"32", "42", "41", "52"}, 1));
        lista.add(new Questao(103, "Matematica", "Quanto é 100 - 37?",
                new String[]{"63", "67", "73", "53"}, 0));
        lista.add(new Questao(104, "Matematica", "Quanto é 9 x 9?",
                new String[]{"72", "81", "91", "99"}, 1));
        lista.add(new Questao(105, "Matematica", "Quanto é 144 / 12?",
                new String[]{"10", "11", "12", "14"}, 2));
        lista.add(new Questao(106, "Matematica", "Qual é o resultado de 2 elevado a 3?",
                new String[]{"6", "8", "9", "4"}, 1));
        lista.add(new Questao(107, "Matematica", "Quanto é 50% de 200?",
                new String[]{"50", "100", "150", "25"}, 1));
        lista.add(new Questao(108, "Matematica", "Quanto é 7 x 6?",
                new String[]{"36", "40", "42", "48"}, 2));
        lista.add(new Questao(109, "Matematica", "Quanto é a raiz quadrada de 81?",
                new String[]{"7", "8", "9", "10"}, 2));
        lista.add(new Questao(110, "Matematica", "Quanto é 250 + 150?",
                new String[]{"300", "350", "400", "450"}, 2));
        lista.add(new Questao(111, "Matematica", "Quanto é 12 x 12?",
                new String[]{"124", "134", "144", "154"}, 2));
        lista.add(new Questao(112, "Matematica", "Quanto é 1000 / 4?",
                new String[]{"200", "250", "300", "400"}, 1));
        lista.add(new Questao(113, "Matematica", "Quanto é 6 + 6 x 6?",
                new String[]{"42", "48", "72", "36"}, 0));
        lista.add(new Questao(114, "Matematica", "Quanto é 3/4 em forma decimal?",
                new String[]{"0,25", "0,50", "0,75", "1,25"}, 2));
        lista.add(new Questao(115, "Matematica", "Quanto é 9 - 15?",
                new String[]{"6", "-6", "-24", "24"}, 1));
        return lista;
    }
}