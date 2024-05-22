package absolute.cinema.services;

import absolute.cinema.objetos.Cinema;
import absolute.cinema.objetos.Filme;
import absolute.cinema.objetos.PoltronaReservar;
import absolute.cinema.utils.ArvoreNaria;
import absolute.cinema.utils.ListaEncadeada;
import absolute.cinema.utils.Nodo;
import absolute.cinema.utils.Pilha;
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

        Cinema cinemaEscolhido = CinemaServices.SelecionarCinema(listaCinemas);
        if (cinemaEscolhido == null) {
            return;
        }

        // BUSCAR NODO DO CINEMA-ESCOLHIDO NA ARVORE, SE SIM: CONTINUAR, SE NAO: BARRAR
        Nodo nodoFilme = arvore.buscaNodo(filmeEscolhido, arvore.getRaiz());
        if (nodoFilme == null) {
            JOptionPane.showMessageDialog(null, "O filme selecionado não está cadastrado na árvore.");
            return;
        }

        boolean cinemaEncontrado = false;
        for (Nodo nodoCinema : nodoFilme.getFilhos()) {
            if (cinemaEscolhido.equals(nodoCinema.getValor())) { // cinema escolhido?
                cinemaEncontrado = true;
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

        if (cinemaEscolhido.reservarPoltrona(numeroPoltrona)) {
            pilhaHistoricoDeReserva.empilhar(new PoltronaReservar(numeroPoltrona, filmeEscolhido, cinemaEscolhido));
            JOptionPane.showMessageDialog(null, "Poltrona " + numeroPoltrona + " reservada com sucesso.");
            arvore.insere(new PoltronaReservar(numeroPoltrona, filmeEscolhido, cinemaEscolhido), cinemaEscolhido);
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
