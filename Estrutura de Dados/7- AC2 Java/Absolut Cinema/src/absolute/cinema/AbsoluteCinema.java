package absolute.cinema;

import absolute.cinema.objetos.Cinema;
import absolute.cinema.objetos.Filme;
import absolute.cinema.utils.IntNoSimples;
import absolute.cinema.utils.ListaEncadeada;
import absolute.cinema.utils.Pilha;
import absolute.cinema.services.CinemaServices;
import absolute.cinema.utils.Fila;
import javax.swing.JOptionPane;
import absolute.cinema.services.GeneroServices;
import absolute.cinema.services.FilmeServices;
import absolute.cinema.services.PoltronaReservarServices;
import absolute.cinema.utils.ArvoreNaria;

public class AbsoluteCinema {

    public static void main(String[] args) {

        ListaEncadeada listaGenero = new ListaEncadeada();
        ListaEncadeada listaFilmes = new ListaEncadeada();
        Fila filaDeTransferencia = new Fila(20);
        Fila filaFilmesEmBreve = new Fila(20);
        ListaEncadeada listaFilmeHoje = new ListaEncadeada();
        ListaEncadeada listaCinemas = new ListaEncadeada();
        Pilha pilhaHistoricoDeReserva = new Pilha(20);

        //ArvoreNaria arvoreCinemas = new ArvoreNaria(0);
        /*
            Material utilizado e estudado para a criacao da arvore n-aria.
            https://www.youtube.com/watch?v=cbOtqNKNZHw
            https://www.each.usp.br/digiampietri/ACH2023/va19.pdf
         */
        ArvoreNaria arvoreGeneroFilmeCinemaPoltrona = new ArvoreNaria("SelecionarOGenero");

        int opcao = 1;

        int quantidadeDePoltronas = 0;

        while (opcao != 99) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "-- BEM-VINDO AO SISTEMA DO ABSOLUTE CINEMA --\n"
                    + "\n"
                    + "Serviços de Gênero:\n"
                    + "1- Cadastrar novo Gênero.\n"
                    + "2- Mostrar Lista de Gêneros.\n"
                    + "\n"
                    + "Serviços de Filme:\n"
                    + "3- Cadastrar novo Filme.\n"
                    + "4- Mostrar Lista de Filmes Cadastrados.\n"
                    + "5- Mostrar Fila de transferencia.\n"
                    + "6- Mostrar Fila de Filmes Em Breve.\n"
                    + "7- Mostrar Lista de Filmes Em Cartaz Hoje.\n"
                    + "\n"
                    + "Serviços de Cinema:\n"
                    + "8- Cadastrar novo Cinema.\n"
                    + "9- Mostrar Lista de Cinemas Cadastrados.\n"
                    + "10- Adicionar Cinema ao Filme.\n"
                    + "\n"
                    + "Serviços de Reserva:\n"
                    + "11- Cadastrar nova Reserva de Poltrona.\n"
                    + "12- Gerar histórico das reservas.\n"
                    + "\n"
                    + "Outros Serviços:\n"
                    + "13- Transferir - 'Fila de Transferencia' >> 'Fila Filmes em Breve'.\n"
                    + "14- Transferir - 'Fila Filmes em Breve' >> 'Lista de Filmes em Cartaz Hoje'.\n"
                    + "\n"
                    + "Serviços de Busca:\n"
                    + "15- Imprimir Árvore.\n"
                    + "16- Imprimir os cinemas de um Filme.\n"
                    + "\n"
                    + "99- Sair.\n\n"));

            switch (opcao) {

                case 1:
                    GeneroServices.CadastrarGenero(listaGenero, arvoreGeneroFilmeCinemaPoltrona);
                    break;

                case 2:
                    GeneroServices.MostrarListaGenero(listaGenero);
                    break;

                case 3:
                    FilmeServices.CadastroFilme(listaFilmes, listaGenero, filaDeTransferencia, arvoreGeneroFilmeCinemaPoltrona);
                    break;

                case 4:
                    FilmeServices.MostrarListaFilmeCadastrados(listaFilmes);
                    break;

                case 5:
                    FilmeServices.MostrarFilaDeTransferencia(filaDeTransferencia);
                    break;

                case 6:
                    FilmeServices.MostrarFilaEmBreve(filaFilmesEmBreve);
                    break;

                case 7:
                    FilmeServices.MostrarListaEmCartazHoje(listaFilmeHoje);
                    break;

                case 8:
                    CinemaServices.CadastrarCinema(listaCinemas, quantidadeDePoltronas);
                    break;

                case 9:
                    CinemaServices.MostrarCinemasCadastrados(listaCinemas);
                    break;

                case 10:
                    // -------- Adicionar Cinema ao Filme ---------

                    FilmeServices.FilmeAddCinema(listaFilmeHoje, listaCinemas, arvoreGeneroFilmeCinemaPoltrona);

                    break;

                case 11:
                    PoltronaReservarServices.CadastrarReservaPoltrona(listaFilmes, listaCinemas, pilhaHistoricoDeReserva, arvoreGeneroFilmeCinemaPoltrona);
                    break;

                case 12:
                    PoltronaReservarServices.GerarHistoricoDasPoltronasReservadas(pilhaHistoricoDeReserva);
                    break;

                case 13:
                    filaFilmesEmBreve.enfileirar(filaDeTransferencia.desenfileirar());
                    filaDeTransferencia.exibeFilaDeTransferencia();
                    filaFilmesEmBreve.exibeFilaEmBreve();
                    break;

                case 14:
                    listaFilmeHoje.insereNo_fim(new IntNoSimples(filaFilmesEmBreve.desenfileirar()));
                    filaFilmesEmBreve.exibeFilaEmBreve();
                    listaFilmeHoje.exibeListaEmCartazHojeJOPT();
                    break;

                case 15:
                    arvoreGeneroFilmeCinemaPoltrona.exibirArvore();
                    break;

                case 16:

                    Filme filmeSelecionado2 = FilmeServices.SelecionarFilmeEmCartaz(listaFilmeHoje);

                    arvoreGeneroFilmeCinemaPoltrona
                            .exibirArvore(
                                    arvoreGeneroFilmeCinemaPoltrona.buscaNodo(
                                            filmeSelecionado2,
                                            arvoreGeneroFilmeCinemaPoltrona.getRaiz()),
                                    true);
                    break;

                case 99:
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Por favor, selecione uma opção válida.");
            }
        }

    }

}
