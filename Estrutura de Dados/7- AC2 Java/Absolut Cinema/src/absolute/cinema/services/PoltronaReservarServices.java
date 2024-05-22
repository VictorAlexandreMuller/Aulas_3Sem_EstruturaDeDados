package absolute.cinema.services;

import absolute.cinema.objetos.Cinema;
import absolute.cinema.objetos.PoltronaReservar;
import absolute.cinema.utils.ListaEncadeada;
import absolute.cinema.utils.Pilha;
import javax.swing.JOptionPane;

public class PoltronaReservarServices {

    /*
    
    "Serviços de Reserva:\n"
                    + "70- Cadastrar nova Reserva de Poltrona.\n"
                    + "75- Gerar histórico das reservas.\n"
    
     */
    public static void CadastrarReservaPoltrona(ListaEncadeada listaCinemas, Pilha pilhaHistoricoDeReserva) {

        if (listaCinemas.ContarNos() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, crie um cinema para fazer uma reserva.");
        } else {

            Cinema cinemaEscolhido = CinemaServices.SelecionarCinema(listaCinemas);

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
                        pilhaHistoricoDeReserva.empilhar(new PoltronaReservar(numeroPoltrona, cinemaEscolhido));
                        JOptionPane.showMessageDialog(null, "Poltrona " + numeroPoltrona + " reservada com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Poltrona " + numeroPoltrona + " já está reservada, por favor, selecione outra poltrona.");
                    }
                }
            }
        }
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
