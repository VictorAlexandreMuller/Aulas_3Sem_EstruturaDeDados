package absolute.cinema.utils;

import absolute.cinema.objetos.Filme;
import javax.swing.JOptionPane;

public class Fila {

    private int tamanho;
    private int inicio;
    private int fim;
    private int total;
    private Filme vetor[];

    public Fila(int tam) {
        inicio = 0;
        fim = 0;
        total = 0;
        tamanho = tam;
        vetor = new Filme[tam];
    }

    public boolean vazia() {
        if (total == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean cheia() {
        if (total == tamanho) {
            return true;
        } else {
            return false;
        }
    }

    public void enfileirar(Filme elem) {
        if (!cheia()) {
            vetor[fim] = elem;
            fim++;
            total++;
        } else {
            System.out.println("Fila Cheia");
        }
    }

    public Filme desenfileirar() {

        if (!vazia()) {
            Filme elem = vetor[inicio];
            inicio = (inicio + 1) % tamanho;
            total--;
            return elem;
        } else {
            System.out.println("Fila vazia");
            return null;
        }
    }

    public void exibeFilaDeTransferencia() {

        StringBuilder opcoes = new StringBuilder();

        opcoes.append("Fila de Transferencia:\n\n");

        for (int i = inicio, count = 0; count < total; i = (i + 1) % tamanho, count++) {
            opcoes.append("Posição: ").append(i).append(" >> ").append(vetor[i].imprimirCadastroFilme()).append("\n");
        }

        JOptionPane.showMessageDialog(null, opcoes.toString());
    }

    public void exibeFilaEmBreve() {
        StringBuilder opcoes = new StringBuilder();

        opcoes.append("Fila de Filmes Em Breve:\n\n");

        for (int i = inicio, count = 0; count < total; i = (i + 1) % tamanho, count++) {
            opcoes.append("Posição: ").append(i).append(" >> ").append(vetor[i].imprimirCadastroFilme()).append("\n");
        }

        JOptionPane.showMessageDialog(null, opcoes.toString());
    }

    public void exibeFila() {
        for (int i = inicio; i < fim; i++) {
            System.out.println("FILA MODELO DO PROFESSOR: \n"
                    + "Posicao: " + i + " - Valor: " + vetor[i] + "\n");
        }
    }
    
    public void exibeFilaFilmeEmBreveJOPT() {
        StringBuilder filaFilmeEmBreve = new StringBuilder();

        for (int i = inicio; i < fim; i++) {
            filaFilmeEmBreve.append("Posição: ")
                    .append(i)
                    .append(" - Valor: ")
                      .append(vetor[i].imprimirCadastroFilme())
                      .append("\n");
        }
        JOptionPane.showMessageDialog(null,
                "Fila de Filmes Em Breve:\n" + filaFilmeEmBreve.toString());
    }
    
}
