package absolute.cinema;

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
import absolute.cinema.utils.Nodo;

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
            try {
                String input = JOptionPane.showInputDialog(null,
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
                        + "15- Imprimir Árvore inline inteira.\n"
                        + "16- Imprimir Árvore inline a partir de um nó.\n"
                        + "\n"
                        + "17- Imprimir Árvore growth inteira.\n"
                        + "18- Imprimir Árvore growth a partir de um nó.\n"
                        + "\n"
                        + "99- Sair.\n\n");

                if (input == null || input.trim().isEmpty()) {
                    throw new NumberFormatException();
                }

                opcao = Integer.parseInt(input);

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
                        FilmeServices.FilmeAddCinema(listaFilmeHoje, listaCinemas, arvoreGeneroFilmeCinemaPoltrona);
                        break;

                    case 11:
                        PoltronaReservarServices.CadastrarReservaPoltrona(listaFilmes, listaCinemas, pilhaHistoricoDeReserva, arvoreGeneroFilmeCinemaPoltrona);
                        break;

                    case 12:
                        PoltronaReservarServices.GerarHistoricoDasPoltronasReservadas(pilhaHistoricoDeReserva);
                        break;

                    case 13:
                        if (filaDeTransferencia.vazia()) {
                            JOptionPane.showMessageDialog(null, "A Fila de Transferencia encontra-se vazia.");
                        } else {
                            filaFilmesEmBreve.enfileirar(filaDeTransferencia.desenfileirar());
                            filaDeTransferencia.exibeFilaDeTransferencia();
                            filaFilmesEmBreve.exibeFilaEmBreve();
                        }
                        break;

                    case 14:
                        if (filaFilmesEmBreve.vazia()) {
                            JOptionPane.showMessageDialog(null, "A Fila de Filmes Em Breve encontra-se vazia.");
                        } else {
                            listaFilmeHoje.insereNo_fim(new IntNoSimples(filaFilmesEmBreve.desenfileirar()));
                            filaFilmesEmBreve.exibeFilaEmBreve();
                            listaFilmeHoje.exibeListaEmCartazHojeJOPT();
                        }
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

                    case 17:

                        arvoreGeneroFilmeCinemaPoltrona.exibirArvoreInteiraAPartirDaRaiz();

                        break;

                    case 18:

                        Filme filmeSelecionado3 = FilmeServices.SelecionarFilmeEmCartaz(listaFilmeHoje);
                        Nodo nodoFilmeSelecionado = arvoreGeneroFilmeCinemaPoltrona.buscaNodo(filmeSelecionado3, arvoreGeneroFilmeCinemaPoltrona.getRaiz());

                        if (nodoFilmeSelecionado != null) {
                            arvoreGeneroFilmeCinemaPoltrona.exibirArvoreAPartirDeUmNodo(nodoFilmeSelecionado);
                        } else {
                            JOptionPane.showMessageDialog(null, "O filme selecionado não está cadastrado na árvore.");
                        }

                        break;

                    case 99:
                        System.exit(0);
                        break;

                    default:
                        JOptionPane.showMessageDialog(null,
                                "Por favor, selecione uma opção válida.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, selecione uma opção do painel.");
            }
        }

    }

}
