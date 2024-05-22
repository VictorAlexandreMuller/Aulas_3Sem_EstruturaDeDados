package absolute.cinema;

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
                    + "FALTA 65- Adicionar Cinema ao Filme.\n"
                    + "\n"
                    + "Serviços de Reserva:\n"
                    + "70- Cadastrar nova Reserva de Poltrona.\n"
                    + "75- Gerar histórico das reservas.\n"
                    + "\n"
                    + "Outros Serviços:\n"
                    + "80- Transferir - 'Fila de Transferencia' >> 'Fila Filmes em Breve'.\n"
                    + "85- Transferir - 'Fila Filmes em Breve' >> 'Lista de Filmes em Cartaz Hoje'.\n"
                    + "\n"
                    + "FALTA 90- Buscar na ARVORE os cinemas em que determinado filme esta passando.\n"
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
                    FilmeServices.CadastroFilme(listaFilmes, listaGenero, filaDeTransferencia,arvoreGeneroFilmeCinemaPoltrona);
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

                case 65:
                    // ------------------------------ FAZER -----------------------------------
                    
                    
                    
                    break;

                case 70:
                    PoltronaReservarServices.CadastrarReservaPoltrona(listaCinemas, pilhaHistoricoDeReserva);
                    break;

                case 75:
                    PoltronaReservarServices.GerarHistoricoDasPoltronasReservadas(pilhaHistoricoDeReserva);
                    break;

                case 80:
                    filaFilmesEmBreve.enfileirar(filaDeTransferencia.desenfileirar());
                    filaDeTransferencia.exibeFilaDeTransferencia();
                    filaFilmesEmBreve.exibeFilaEmBreve();
                    break;

                case 85:
                    listaFilmeHoje.insereNo_fim(new IntNoSimples(filaFilmesEmBreve.desenfileirar()));
                    filaFilmesEmBreve.exibeFilaEmBreve();
                    listaFilmeHoje.exibeListaEmCartazHojeJOPT();
                    break;

                case 90:
                    // 11- Buscar na ARVORE os cinemas em que determinado filme esta passando.
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    /*
                    String nomeFilmeBusca = JOptionPane.showInputDialog(null, "Insira o nome do filme que deseja buscar:");
                    Nodo cinemaNode = arvoreCinemas.buscaChave(buscarIdFilme(nomeFilmeBusca), arvoreCinemas.getRaiz());
                    if (cinemaNode != null) {
                        String cinemas = buscarCinemasPorFilme(cinemaNode);
                        JOptionPane.showMessageDialog(null, "O filme '" + nomeFilmeBusca + "' está passando nos seguintes cinemas:\n" + cinemas);
                    } else {
                        JOptionPane.showMessageDialog(null, "O filme '" + nomeFilmeBusca + "' não está sendo exibido em nenhum cinema.");
                    }
                     */
                    // -------------------------------------------------
                    /*
                    if (listaGenero.ContarNos() == 0) {
                        JOptionPane.showMessageDialog(null, "Por favor, cadastre um gênero para realizar as suas pesquisas.");
                    } else {
                        StringBuilder opcoesGenero = new StringBuilder("Escolha o Gênero desejado:\n");
                        IntNoSimples tempGenero = listaGenero.primeiro;
                        int posicaoGenero = 1;
                        while (tempGenero != null) {
                            Genero genero = (Genero) tempGenero.valorGenero;
                            opcoesGenero.append(posicaoGenero).append(": ").append(genero.getNome()).append("\n");
                            tempGenero = tempGenero.prox;
                            posicaoGenero++;
                        }
                        String escolhaGeneroStr = JOptionPane.showInputDialog(null, opcoesGenero.toString());
                        int escolhaGenero = Integer.parseInt(escolhaGeneroStr) - 1;

                        Nodo generoNode = arvoreGeneros.buscaChave(escolhaGenero, arvoreGeneros.getRaiz());
                        if (generoNode == null || generoNode.primFilho == null) {
                            JOptionPane.showMessageDialog(null, "Por favor, cadastre algum filme desse gênero para realizar as pesquisas.");
                        } else {
                            StringBuilder opcoesFilme = new StringBuilder("Escolha o Filme desejado:\n");
                            Nodo tempFilme = generoNode.primFilho;
                            int posicaoFilme = 1;
                            while (tempFilme != null) {
                                Filme filme = (Filme) tempFilme.chave;
                                opcoesFilme.append(posicaoFilme).append(": ").append(filme.getNome()).append("\n");
                                tempFilme = tempFilme.proxIrmao;
                                posicaoFilme++;
                            }
                            String escolhaFilmeStr = JOptionPane.showInputDialog(null, opcoesFilme.toString());
                            int escolhaFilme = Integer.parseInt(escolhaFilmeStr) - 1;

                            Nodo filmeNode = arvoreGeneros.buscaChave(escolhaFilme, generoNode);
                            if (filmeNode == null || filmeNode.primFilho == null) {
                                JOptionPane.showMessageDialog(null, "Este filme não está passando em nenhum cinema.");
                            } else {
                                StringBuilder opcoesCinema = new StringBuilder("O filme está passando nos seguintes cinemas:\n");
                                Nodo tempCinema = filmeNode.primFilho;
                                while (tempCinema != null) {
                                    Cinema cinema = (Cinema) tempCinema.chave;
                                    opcoesCinema.append(cinema.getNome()).append("\n");
                                    tempCinema = tempCinema.proxIrmao;
                                }
                                JOptionPane.showMessageDialog(null, opcoesCinema.toString());
                            }
                        }
                    }
                     */
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

    /*
    private static int buscarIdFilme(String nomeFilme) {
        // Implementar lógica para buscar o ID do filme pelo nome
        // Supondo que a listaFilmes contém todos os filmes cadastrados
        // Retorna -1 se não encontrado
        return -1; // Exemplo de retorno
    }

    private static String buscarCinemasPorFilme(Nodo filmeNode) {
        StringBuilder cinemas = new StringBuilder();
        Nodo p = filmeNode.primFilho;
        while (p != null) {
            cinemas.append(p.chave).append("\n");
            p = p.proxIrmao;
        }
        return cinemas.toString();
    }
     */
}
