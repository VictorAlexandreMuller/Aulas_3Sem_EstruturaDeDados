package absolute.cinema.services;

import absolute.cinema.objetos.Cinema;
import absolute.cinema.utils.IntNoSimples;
import absolute.cinema.utils.ListaEncadeada;
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
                "Escolha o cinema que deseja realizar a reserva:\n" + opcoesCinema.toString());

        if (escolhaCinema == null || escolhaCinema.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Opção inválida.");
            return null;
        }

        int escolha = Integer.parseInt(escolhaCinema) - 1;

        if (escolha < 0 || escolha >= listaCinemas.ContarNos()) {
            JOptionPane.showMessageDialog(null,
                    "Opção inválida. Por favor, insira um número válido.");
            return null;
        }

        IntNoSimples noEscolhido = listaCinemas.primeiro;
        for (int j = 0; j < escolha; j++) {
            noEscolhido = noEscolhido.prox;
        }

        return noEscolhido.valorCinema;

    }

}
