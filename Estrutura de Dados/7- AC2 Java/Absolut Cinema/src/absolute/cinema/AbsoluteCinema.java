package absolute.cinema;

import absolute.cinema.objetos.Cinema;
import absolute.cinema.utils.IntNoSimples;
import absolute.cinema.utils.ListaEncadeada;
import absolute.cinema.objetos.Genero;
import absolute.cinema.utils.Pilha;
import absolute.cinema.objetos.Filme;
import absolute.cinema.objetos.PoltronaReservar;
import absolute.cinema.utils.Fila;
import javax.swing.JOptionPane;
import absolute.cinema.services.GeneroServices;
import absolute.cinema.services.FilmeServices;
import absolute.cinema.utils.ArvoreNaria;
import absolute.cinema.utils.Nodo;

public class AbsoluteCinema {

    public static void main(String[] args) {

        ListaEncadeada listaGenero = new ListaEncadeada(); // Utilizado para instanciar a lista no case 2
        ListaEncadeada listaFilmes = new ListaEncadeada(); // Case 3

        Fila filaFilmesCadastrados = new Fila(20); // Case 3 e 4

        Pilha pilhaHistoricoDeReserva = new Pilha(20);

        Fila filaFilmesEmBreve = new Fila(20);
        Fila filaListaDeFilmesAPassar = new Fila(20);

        ListaEncadeada listaCinemas = new ListaEncadeada();

        ListaEncadeada listaFilmeHoje = new ListaEncadeada();

        ArvoreNaria arvoreCinemas = new ArvoreNaria(0);

        int opcao = 1;

        String nome = "";
        int quantidadeDePoltronas = 0;

        while (opcao != 12) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "-- BEM-VINDO AO SISTEMA DO ABSOLUTE CINEMA --\n"
                    + "\n"
                    + "Serviços de Gênero:\n"
                    + "OK 1- Criar novo Gênero. (LISTA)\n"
                    + "2- Mostrar Lista de Gêneros\n"
                    + "\n"
                    + "Serviços de Filme:\n"
                    + "OK 3- Cadastrar Filme. (FILA)\n"
                    + "4- Mostrar Lista de Filmes Cadastrados\n"
                    + "5- Mostrar Fila de Filmes Cadastrados a serem transferidos\n"
                    + "\n"
                    + "Serviços de Cinema:\n"
                    + "OK 6- Criar novo Cinema. (LISTA)\n"
                    + "OK 7- Criar uma reserva de lugar em LISTA.\n"
                    + "OK 8- Gerar histórico das reservas. (PILHA)\n"
                    + "\n"
                    + "Outros Serviços:\n"
                    + "OK 9- Transferir 'Fila Filme Cadastrado' >> 'Fila Filmes em Breve'. (FILA)\n"
                    + "OK 10- Transferir 'Fila Filmes em Breve' >> 'Lista de Filmes em Cartaz Hoje'. (LISTA)\n"
                    + "\n"
                    + "11- Buscar na ARVORE os cinemas em que determinado filme esta passando.\n"
                    + "\n"
                    + "12- Sair.\n\n"));

            switch (opcao) {

                // 2 - Criar Genero.
                case 1:
                    GeneroServices.CadastrarGenero(listaGenero);
                    break;

                case 2:

                    break;

                // 3- Cadastrar Filme em uma Fila de Transferencia.
                case 3:
                    FilmeServices.CadastroFilme(listaFilmes, listaGenero, filaFilmesCadastrados);
                    break;

                case 4:

                    break;

                case 5:

                    break;

                // 6- Insira um novo Cinema.
                case 6:
                    String nomeCinema = JOptionPane.showInputDialog(null, "Insira o nome do novo Cinema a ser cadastrado:");
                    quantidadeDePoltronas = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a quantidade de poltronas existentes neste cinema:"));

                    Cinema cinema = new Cinema(nomeCinema, quantidadeDePoltronas);

                    listaCinemas.insereNo_fim(new IntNoSimples(cinema));

                    listaCinemas.exibeListaCinema();

                    JOptionPane.showMessageDialog(null, "Cinema criado com sucesso.");

                    break;

                // 7- Criar uma reserva de lugar em LISTA.
                case 7:
                    if (listaCinemas.ContarNos() == 0) {
                        JOptionPane.showMessageDialog(null, "Por favor, crie um cinema para fazer uma reserva.");
                    } else {
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

                        if (escolhaCinema != null && !escolhaCinema.trim().isEmpty()) {
                            try {
                                int escolha = Integer.parseInt(escolhaCinema) - 1;

                                if (escolha < 0 || escolha >= listaCinemas.ContarNos()) {
                                    JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, insira um número válido.");
                                    break;
                                }

                                IntNoSimples noEscolhido = listaCinemas.primeiro;
                                for (int j = 0; j < escolha; j++) {
                                    noEscolhido = noEscolhido.prox;
                                }

                                Cinema cinemaEscolhido = noEscolhido.valorCinema;

                                String numeroPoltronaStr = JOptionPane.showInputDialog(null,
                                        "Digite o número da poltrona que deseja reservar (" + cinemaEscolhido.getQuantidadePoltronas() + "):");

                                if (numeroPoltronaStr != null && !numeroPoltronaStr.trim().isEmpty()) {
                                    try {
                                        int numeroPoltrona = Integer.parseInt(numeroPoltronaStr);
                                        if (numeroPoltrona < 1 || numeroPoltrona > cinemaEscolhido.getQuantidadePoltronas()) {
                                            JOptionPane.showMessageDialog(null, "Número da poltrona inválido. Por favor, insira um número entre 1 e " + cinemaEscolhido.getQuantidadePoltronas() + ".");
                                        } else {
                                            if (cinemaEscolhido.reservarPoltrona(numeroPoltrona)) {
                                                pilhaHistoricoDeReserva.empilhar(new PoltronaReservar(numeroPoltrona, cinemaEscolhido)); // já empilha para o case 8
                                                JOptionPane.showMessageDialog(null, "Poltrona " + numeroPoltrona + " reservada com sucesso.");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Poltrona " + numeroPoltrona + " já está reservada, por favor, selecione outra poltrona.");
                                            }
                                        }
                                    } catch (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Número da poltrona inválido. Por favor, insira um número válido.");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Número da poltrona inválido.");
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, insira um número válido.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Opção inválida.");
                        }
                    }
                    break;

                // 8- Buscar historico de lugares na PILHA.
                case 8:
                    if (pilhaHistoricoDeReserva.vazia()) {
                        JOptionPane.showMessageDialog(null, "Nenhuma reserva foi feita.");
                    } else {
                        StringBuilder historico = new StringBuilder("Histórico de reservas:\n");

                        Pilha tempPilha = new Pilha(20);

                        while (!pilhaHistoricoDeReserva.vazia()) {
                            PoltronaReservar poltrona = (PoltronaReservar) pilhaHistoricoDeReserva.desempilhar();
                            historico.append(poltrona.toString()).append("\n");
                            tempPilha.empilhar(poltrona);
                        }
                        while (!tempPilha.vazia()) {
                            pilhaHistoricoDeReserva.empilhar(tempPilha.desempilhar());
                        }
                        JOptionPane.showMessageDialog(null, historico.toString());
                    }
                    break;

                // 9- Transferir um Filme à fila de Filmes em Breve.
                case 9:
                    filaFilmesEmBreve.enfileirar(filaFilmesCadastrados.desenfileirar());
                    filaFilmesCadastrados.exibeFilaCadastroFilme();
                    filaFilmesEmBreve.exibeFilaEmBreve();

                    break;

                // 10- Transferir um Filme à lista de Filmes Hoje.
                case 10:
                    listaFilmeHoje.insereNo_fim(new IntNoSimples(filaFilmesEmBreve.desenfileirar()));
                    listaFilmeHoje.exibeListaFilme();
                    break;

                // 11- Buscar na ARVORE os cinemas em que determinado filme esta passando.
                case 11:
                /*
                    String nomeFilmeBusca = JOptionPane.showInputDialog(null, "Insira o nome do filme que deseja buscar:");
                    Nodo cinemaNode = arvoreCinemas.buscaChave(buscarIdFilme(nomeFilmeBusca), arvoreCinemas.getRaiz());
                    if (cinemaNode != null) {
                        String cinemas = buscarCinemasPorFilme(cinemaNode);
                        JOptionPane.showMessageDialog(null, "O filme '" + nomeFilmeBusca + "' está passando nos seguintes cinemas:\n" + cinemas);
                    } else {
                        JOptionPane.showMessageDialog(null, "O filme '" + nomeFilmeBusca + "' não está sendo exibido em nenhum cinema.");
                    }
                    break;
                 */
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

                case 12:
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Por favor, selecione uma opção válida.");
            }
        }

    }

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

}
