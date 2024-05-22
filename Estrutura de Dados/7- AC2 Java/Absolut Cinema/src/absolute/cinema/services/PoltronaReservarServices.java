package absolute.cinema.services;

import absolute.cinema.objetos.Cinema;
import absolute.cinema.objetos.Filme;
import absolute.cinema.objetos.PoltronaReservar;
import absolute.cinema.utils.ArvoreNaria;
import absolute.cinema.utils.ListaEncadeada;
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
        } else {
            
            Filme filmeEscolhido = FilmeServices.SelecionarFilmeEmCartaz(listaFilmes);

            Cinema cinemaEscolhido = CinemaServices.SelecionarCinema(listaCinemas);

            // BUSCAR NODO DO CINEMA-ESCOLHIDO NA ARVORE, SE SIM: CONTINUAR, SE NAO: BARRAR
            
            if (arvore.buscaNodo(cinemaEscolhido, arvore.getRaiz()) == null) {
                JOptionPane.showMessageDialog(null, "O cinema escolhido não pode fazer reservas enquanto não estiver vinculado a algum filme. XD");
            } else {
            
            String numeroPoltronaStr = JOptionPane.showInputDialog(null,
                    "Digite o número da poltrona que deseja reservar (" + cinemaEscolhido.getQuantidadePoltronas() + "):");

            if (numeroPoltronaStr == null || numeroPoltronaStr.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Número da poltrona inválido.");
            } else {

                int numeroPoltrona = Integer.parseInt(numeroPoltronaStr);

                if (numeroPoltrona < 1 || numeroPoltrona > cinemaEscolhido.getQuantidadePoltronas()) {
                    JOptionPane.showMessageDialog(null, "Número da poltrona inválido. Por favor, insira um número entre 1 e " + cinemaEscolhido.getQuantidadePoltronas() + ".");
                } else {
                    if (cinemaEscolhido.reservarPoltrona(numeroPoltrona)) {
                        pilhaHistoricoDeReserva.empilhar(new PoltronaReservar(numeroPoltrona, filmeEscolhido, cinemaEscolhido));
                        JOptionPane.showMessageDialog(null, "Poltrona " + numeroPoltrona + " reservada com sucesso.");
                        arvore.insere(numeroPoltrona, cinemaEscolhido);
                    } else {
                        JOptionPane.showMessageDialog(null, "Poltrona " + numeroPoltrona + " já está reservada, por favor, selecione outra poltrona.");
                    }
                }
            }
        }}
    }
    
    public static PoltronaReservar GerarHistoricoDasPoltronasReservadas (Pilha pilhaHistoricoDeReserva) {
        
        if (pilhaHistoricoDeReserva.vazia()) {
                        JOptionPane.showMessageDialog(null, "Nenhuma reserva foi feita.");
                    } else {
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
        
        return null;
    }

}
