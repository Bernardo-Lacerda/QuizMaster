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

        lista.add(new Questao(1, "Portugues", "Leia o trecho: \"Quem tudo quer, tudo perde.\" Essa frase é um exemplo de qual tipo de texto?",
                new String[]{"Notícia", "Provérbio", "Receita", "Contrato", "Ata"}, 1));

        lista.add(new Questao(2, "Portugues", "No trecho \"E chorou, e sofreu, e venceu\", a repetição da conjunção \"e\" no início de cada oração é conhecida como:",
                new String[]{"Metáfora", "Hipérbole", "Polissíndeto", "Eufemismo", "Antítese"}, 2));

        lista.add(new Questao(3, "Portugues", "A frase \"Aquele jogador é um verdadeiro leão em campo\" emprega qual figura de linguagem?",
                new String[]{"Metáfora", "Metonímia", "Prosopopeia", "Ironia", "Onomatopeia"}, 0));

        lista.add(new Questao(4, "Portugues", "Assinale a alternativa em que todas as palavras estão flexionadas corretamente no plural:",
                new String[]{"cidadões, pães, mão", "cidadãos, pães, mãos", "cidadães, pãos, mãos", "cidadãos, pãis, mãos", "cidadões, pãos, mão"}, 1));

        lista.add(new Questao(5, "Portugues", "Um texto em que o eu lírico sente saudade da infância expressa um sentimento de melancolia por algo que passou, chamado de:",
                new String[]{"Ufanismo", "Nostalgia", "Ironia", "Sarcasmo", "Indiferença"}, 1));

        lista.add(new Questao(6, "Portugues", "Em \"Se eu pudesse, voltaria no tempo\", o verbo \"pudesse\" está conjugado no:",
                new String[]{"Pretérito perfeito do indicativo", "Futuro do subjuntivo", "Pretérito imperfeito do subjuntivo", "Presente do indicativo", "Imperativo afirmativo"}, 2));

        lista.add(new Questao(7, "Portugues", "A variação linguística usada entre amigos em uma conversa informal, com gírias, é chamada de:",
                new String[]{"Norma-padrão", "Registro formal", "Registro coloquial", "Linguagem técnica", "Linguagem jurídica"}, 2));

        lista.add(new Questao(8, "Portugues", "Machado de Assis é um autor associado a qual escola literária brasileira?",
                new String[]{"Romantismo", "Realismo", "Barroco", "Arcadismo", "Concretismo"}, 1));

        lista.add(new Questao(9, "Portugues", "Assinale a alternativa em que há concordância verbal correta:",
                new String[]{"Fazem dois anos que ele saiu", "Faz dois anos que ele saiu", "Fazem dois ano que ele saiu", "Faziam dois anos que ele saiu", "Fazem dois anos, que ele saíram"}, 1));

        lista.add(new Questao(10, "Portugues", "O gênero textual que tem como objetivo persuadir o leitor a adotar um ponto de vista é o:",
                new String[]{"Narrativo", "Descritivo", "Argumentativo", "Injuntivo", "Expositivo"}, 2));

        lista.add(new Questao(11, "Portugues", "Na frase \"O menino, cansado, dormiu\", o termo \"cansado\" exerce a função sintática de:",
                new String[]{"Sujeito", "Objeto direto", "Predicativo do sujeito", "Complemento nominal", "Adjunto adnominal"}, 2));

        lista.add(new Questao(12, "Portugues", "Assinale a alternativa que apresenta um exemplo de linguagem denotativa:",
                new String[]{"\"Meu coração é um poço de mágoas\"", "\"A água ferve a 100°C ao nível do mar\"", "\"Ela é um anjo\"", "\"O tempo voa\"", "\"Chorei rios de lágrimas\""}, 1));

        lista.add(new Questao(13, "Portugues", "O uso da crase em \"Vou à escola todos os dias\" se justifica porque:",
                new String[]{"\"Escola\" é palavra masculina", "Há fusão da preposição \"a\" com o artigo feminino \"a\"", "\"Vou\" exige a preposição \"com\"", "Não há crase nessa frase", "\"Escola\" é um verbo"}, 1));

        lista.add(new Questao(14, "Portugues", "Um texto que narra fatos reais, com data, local e fontes verificáveis, publicado em jornal, é classificado como:",
                new String[]{"Conto", "Crônica", "Notícia", "Fábula", "Poema"}, 2));

        lista.add(new Questao(15, "Portugues", "Na oração \"Espero que você chegue bem\", a oração destacada é classificada como:",
                new String[]{"Oração coordenada", "Oração subordinada substantiva objetiva direta", "Oração subordinada adverbial", "Oração subordinada adjetiva", "Oração absoluta"}, 1));

        return lista;
    }

    private static List<Questao> questoesMatematica() {
        List<Questao> lista = new ArrayList<>();

        lista.add(new Questao(101, "Matematica", "Uma loja vende uma camisa por R$ 80,00 com desconto de 25%. Qual o valor final da camisa?",
                new String[]{"R$ 55,00", "R$ 60,00", "R$ 65,00", "R$ 70,00", "R$ 75,00"}, 1));

        lista.add(new Questao(102, "Matematica", "Um carro percorre 300 km com 20 litros de combustível. Qual o consumo médio em km por litro?",
                new String[]{"10", "12", "15", "18", "20"}, 2));

        lista.add(new Questao(103, "Matematica", "Em uma turma de 40 alunos, 60% são meninas. Quantos meninos há na turma?",
                new String[]{"12", "14", "16", "18", "24"}, 2));

        lista.add(new Questao(104, "Matematica", "Se um produto que custava R$ 200,00 teve um aumento de 15%, qual o novo preço?",
                new String[]{"R$ 210,00", "R$ 215,00", "R$ 220,00", "R$ 225,00", "R$ 230,00"}, 4));

        lista.add(new Questao(105, "Matematica", "Uma torneira enche um tanque em 6 horas e outra, sozinha, em 3 horas. Trabalhando juntas, em quantas horas encherão o tanque?",
                new String[]{"1", "1,5", "2", "2,5", "3"}, 2));

        lista.add(new Questao(106, "Matematica", "Qual é a área de um retângulo com 8 m de comprimento e 5 m de largura?",
                new String[]{"13 m²", "26 m²", "35 m²", "40 m²", "45 m²"}, 3));

        lista.add(new Questao(107, "Matematica", "Um investimento de R$ 1.000,00 rende 10% ao ano em juros simples. Qual será o montante após 3 anos?",
                new String[]{"R$ 1.100,00", "R$ 1.200,00", "R$ 1.300,00", "R$ 1.331,00", "R$ 1.400,00"}, 2));

        lista.add(new Questao(108, "Matematica", "Se 5 operários constroem um muro em 12 dias, quantos dias levarão 10 operários para construir o mesmo muro, no mesmo ritmo?",
                new String[]{"4", "5", "6", "8", "10"}, 2));

        lista.add(new Questao(109, "Matematica", "Qual é a média aritmética das notas 6, 7, 8 e 9?",
                new String[]{"6,5", "7", "7,5", "8", "8,5"}, 2));

        lista.add(new Questao(110, "Matematica", "Um terreno retangular tem 10 m de largura e perímetro de 36 m. Qual é o comprimento do terreno?",
                new String[]{"6 m", "8 m", "10 m", "12 m", "16 m"}, 1));

        lista.add(new Questao(111, "Matematica", "Em uma promoção \"compre 3 pague 2\", quanto você paga por 3 produtos de R$ 30,00 cada?",
                new String[]{"R$ 30,00", "R$ 45,00", "R$ 60,00", "R$ 75,00", "R$ 90,00"}, 2));

        lista.add(new Questao(112, "Matematica", "Qual é o valor de x na equação 3x - 7 = 14?",
                new String[]{"5", "6", "7", "8", "9"}, 2));

        lista.add(new Questao(113, "Matematica", "Uma caixa d'água tem capacidade de 1000 litros e está com 40% de sua capacidade. Quantos litros faltam para enchê-la completamente?",
                new String[]{"400", "500", "600", "700", "800"}, 2));

        lista.add(new Questao(114, "Matematica", "Se a probabilidade de chover amanhã é de 30%, qual a probabilidade de não chover?",
                new String[]{"30%", "50%", "60%", "70%", "100%"}, 3));

        lista.add(new Questao(115, "Matematica", "Um livro custa R$ 50,00 e, em uma promoção, o preço foi reduzido para R$ 35,00. Qual foi o percentual de desconto aplicado?",
                new String[]{"15%", "20%", "25%", "30%", "35%"}, 3));

        return lista;
    }
}