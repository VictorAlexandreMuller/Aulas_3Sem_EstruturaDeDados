package absolute.cinema.services;

import absolute.cinema.objetos.Cinema;
import absolute.cinema.utils.IntNoSimples;
import absolute.cinema.utils.ListaEncadeada;
import java.util.List;
import javax.swing.JOptionPane;

public class CinemaServices {

    /*
    "Serviços de Cinema:\n"
                    + "OK 55- Criar novo Cinema.\n"
                    + "60- Mostrar Lista de Cinemas Cadastrados.\n"
                    + "65- Adicionar Filme ao Cinema.\n"
     */
    public static void CadastrarCinema(ListaEncadeada listaCinemas, int quantidadeDePoltronas) {

        String nomeCinema = JOptionPane.showInputDialog(null, "Insira o nome do novo Cinema a ser cadastrado:");
        quantidadeDePoltronas = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a quantidade de poltronas existentes neste cinema:"));

        Cinema cinema = new Cinema(nomeCinema, quantidadeDePoltronas);

        listaCinemas.insereNo_fim(new IntNoSimples(cinema));

        listaCinemas.exibeListaCinema();

        JOptionPane.showMessageDialog(null, "Cinema ''" + cinema + "'' criado com sucesso.");

    }

    public static Cinema MostrarCinemasCadastrados(ListaEncadeada listaCinema) {

        listaCinema.exibeListaCinemaJOPT();
        return null;
    }

    public static Cinema SelecionarCinema(ListaEncadeada listaCinemas) {

        StringBuilder opcoesCinema = new StringBuilder();
        IntNoSimples temp_no = listaCinemas.primeiro;
        int posicao = 0;

        while (temp_no != null) {
            opcoesCinema.append(posicao + 1)
                    .append(": ")
                    .append(temp_no.valorCinema.getNome())
                    .append(" - Quantidade máxima de poltronas: ")
                    .append(temp_no.valorCinema.getQuantidadePoltronas())
                    .append("\n");

            temp_no = temp_no.prox;
            posicao++;
        }

        String escolhaCinema = JOptionPane.showInputDialog(null,
                "Escolha o Cinema:\n" + opcoesCinema.toString());

        if (escolhaCinema == null || escolhaCinema.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Opção inválida.");
            return null;
        }

        int escolha;

        try {
            escolha = Integer.parseInt(escolhaCinema) - 1;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Opção inválida.");
            return null;
        }

        if (escolha < 0 || escolha >= listaCinemas.ContarNos()) {
            JOptionPane.showMessageDialog(null,
                    "Opção inválida.");
            return null;
        }

        IntNoSimples noEscolhido = listaCinemas.primeiro;
        for (int j = 0; j < escolha; j++) {
            noEscolhido = noEscolhido.prox;
        }

        return noEscolhido.valorCinema;

    }
    
    public static Cinema SelecionarCinemaArrayList(List<Cinema> cinemas) {
        StringBuilder opcoesCinema = new StringBuilder();
        int posicao = 0;

        for (Cinema cinema : cinemas) {
            opcoesCinema.append(posicao + 1)
                    .append(": ")
                    .append(cinema.getNome())
                    .append(" - Quantidade máxima de poltronas: ")
                    .append(cinema.getQuantidadePoltronas())
                    .append("\n");
            posicao++;
        }

        String escolhaCinema = JOptionPane.showInputDialog(null,
                "Escolha o Cinema:\n" + opcoesCinema.toString());

        if (escolhaCinema == null || escolhaCinema.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Opção inválida.");
            return null;
        }

        int escolha;

        try {
            escolha = Integer.parseInt(escolhaCinema) - 1;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Opção inválida.");
            return null;
        }

        if (escolha < 0 || escolha >= cinemas.size()) {
            JOptionPane.showMessageDialog(null, "Opção inválida.");
            return null;
        }

        return cinemas.get(escolha);
    }

}
