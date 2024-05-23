package absolute.cinema.services;

import absolute.cinema.objetos.Cinema;
import absolute.cinema.objetos.Filme;
import absolute.cinema.objetos.PoltronaReservar;
import absolute.cinema.utils.ArvoreNaria;
import absolute.cinema.utils.ListaEncadeada;
import absolute.cinema.utils.Nodo;
import absolute.cinema.utils.Pilha;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PoltronaReservarServices {

    /*
    
    "Serviços de Reserva:\n"
                    + "70- Cadastrar nova Reserva de Poltrona.\n"
                    + "75- Gerar histórico das reservas.\n"
    
     */
    public static void CadastrarReservaPoltrona(ListaEncadeada listaFilmes, ListaEncadeada listaCinemas, Pilha pilhaHistoricoDeReserva, ArvoreNaria arvore) {

    if (listaFilmes.ContarNos() == 0 || listaCinemas.ContarNos() == 0) {
        JOptionPane.showMessageDialog(null, "Por favor, crie ao menos um Filme e um Cinema para conseguir vincular reservas.");
        return;
    }

    Filme filmeEscolhido = FilmeServices.SelecionarFilmeEmCartaz(listaFilmes);
    if (filmeEscolhido == null) {
        return;
    }

    // verifica se o filme está na árvore
    Nodo nodoFilme = arvore.buscaNodo(filmeEscolhido, arvore.getRaiz());
    if (nodoFilme == null) {
        JOptionPane.showMessageDialog(null, "O filme selecionado não está cadastrado na árvore.");
        return;
    }

    // filtra a lista de cinemas vinculados ao filme escolhido
    List<Cinema> cinemasVinculados = new ArrayList<>();
    for (Nodo nodoCinema : nodoFilme.getFilhos()) {
        cinemasVinculados.add((Cinema) nodoCinema.getValor());
    }

    if (cinemasVinculados.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Nenhum cinema está vinculado a este filme.");
        return;
    }

    Cinema cinemaEscolhido = CinemaServices.SelecionarCinemaArrayList(cinemasVinculados);
    if (cinemaEscolhido == null) {
        return;
    }

    // verifica se o cinema está vinculado ao filme na árvore
    boolean cinemaEncontrado = false;
    Nodo nodoCinemaEncontrado = null;
    for (Nodo nodoCinema : nodoFilme.getFilhos()) {
        if (cinemaEscolhido.equals(nodoCinema.getValor())) {
            cinemaEncontrado = true;
            nodoCinemaEncontrado = nodoCinema;
            break;
        }
    }

    if (!cinemaEncontrado) {
        JOptionPane.showMessageDialog(null, "O cinema escolhido não está vinculado ao filme selecionado.");
        return;
    }

    String numeroPoltronaStr = JOptionPane.showInputDialog(null,
            "Digite o número da poltrona que deseja reservar (1 - " + cinemaEscolhido.getQuantidadePoltronas() + "):");

    if (numeroPoltronaStr == null || numeroPoltronaStr.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Número da poltrona inválido.");
        return;
    }

    int numeroPoltrona;
    try {
        numeroPoltrona = Integer.parseInt(numeroPoltronaStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Número da poltrona inválido. Por favor, insira um número válido.");
        return;
    }

    if (numeroPoltrona < 1 || numeroPoltrona > cinemaEscolhido.getQuantidadePoltronas()) {
        JOptionPane.showMessageDialog(null, "Número da poltrona inválido. Por favor, insira um número entre 1 e " + cinemaEscolhido.getQuantidadePoltronas() + ".");
        return;
    }

    if (cinemaEscolhido.reservarPoltrona(numeroPoltrona, filmeEscolhido)) {
        PoltronaReservar poltronaReservar = new PoltronaReservar(numeroPoltrona, filmeEscolhido, cinemaEscolhido);
        pilhaHistoricoDeReserva.empilhar(poltronaReservar);
        JOptionPane.showMessageDialog(null, "Poltrona " + numeroPoltrona + " reservada com sucesso.");
        arvore.inserePoltrona(poltronaReservar, nodoCinemaEncontrado);
    } else {
        JOptionPane.showMessageDialog(null, "Poltrona " + numeroPoltrona + " já está reservada, por favor, selecione outra poltrona.");
    }
}

    public static void GerarHistoricoDasPoltronasReservadas(Pilha pilhaHistoricoDeReserva) {
        if (pilhaHistoricoDeReserva.vazia()) {
            JOptionPane.showMessageDialog(null, "Nenhuma reserva foi feita.");
            return;
        }

        StringBuilder historico = new StringBuilder("Histórico de reservas:\n");

        Pilha tempPilha = new Pilha(20);

        while (!pilhaHistoricoDeReserva.vazia()) {
            PoltronaReservar poltrona = (PoltronaReservar) pilhaHistoricoDeReserva.desempilhar();
            historico
                    .append(poltrona.imprimirCadastroPoltrona())
                    .append("\n");
            tempPilha.empilhar(poltrona);
        }
        while (!tempPilha.vazia()) {
            pilhaHistoricoDeReserva.empilhar(tempPilha.desempilhar());
        }
        JOptionPane.showMessageDialog(null, historico.toString());

    }

}
