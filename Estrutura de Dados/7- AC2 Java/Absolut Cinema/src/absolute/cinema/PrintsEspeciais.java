package absolute.cinema;

import javax.swing.JOptionPane;

public class PrintsEspeciais {

    private int tamanho;
    private int inicio;
    private int fim;
    private int total;
    private Filme vetor[];

    public void exibeFilaCadastroEFilaEmBreve() {

        StringBuilder opcoes = new StringBuilder();

        opcoes.append("FILA CADASTRO:\n");

        for (int i = inicio, count = 0; count < total; i = (i + 1) % tamanho, count++) {
            opcoes.append("Posição: ").append(i).append(" - Valor: ").append(vetor[i]).append("\n");
        }

        StringBuilder opcoes2 = new StringBuilder();

        opcoes2.append("FILA EM BREVE:\n");

        for (int i = inicio, count = 0; count < total; i = (i + 1) % tamanho, count++) {
            opcoes2.append("Posição: ").append(i).append(" - Valor: ").append(vetor[i]).append("\n");
        }

        JOptionPane.showMessageDialog(null, opcoes.toString() + "\n\n" + opcoes2.toString());
    }

}
