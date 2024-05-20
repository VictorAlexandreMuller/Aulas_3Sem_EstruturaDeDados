package absolute.cinema;

import absolute.cinema.objetos.Cinema;
import absolute.cinema.utils.IntNoSimples;
import absolute.cinema.utils.ListaEncadeada;
import absolute.cinema.objetos.Genero;
import absolute.cinema.utils.Pilha;
import absolute.cinema.objetos.Filme;
import absolute.cinema.objetos.PoltronaReservar;
import absolute.cinema.utils.Fila;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AbsoluteCinema {

    public static void main(String[] args) {

        Pilha pilhaHistoricoDeReserva = new Pilha(20);

        Fila filaCadastroDeFilmes = new Fila(20);
        Fila filaFilmesEmBreve = new Fila(20);
        Fila filaListaDeFilmesAPassar = new Fila(20);

        ListaEncadeada listaFilmeHoje = new ListaEncadeada();
        ListaEncadeada listaCinemas = new ListaEncadeada();
        ListaEncadeada listaGenero = new ListaEncadeada();

        //ArrayList<Genero> generos = new ArrayList<>();
        //ArrayList<Cinema> cinemas = new ArrayList<>();
        //ArrayList<Filme> arrayFilmes = new ArrayList<>();
        int opcao = 1;
        int i;

        String nome = "";
        int quantidadeDePoltronas = 0;

        while (opcao != 9) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "-- BEM-VINDO AO ABSOLUTE CINEMA --\n\n"
                    + "1- Buscar na ARVORE os cinemas em que determinado filme esta passando.\n"
                    + "OK 2- Criar novo Gênero. (LISTA)\n"
                    + "OK 3- Cadastrar Filme. (FILA)\n"
                    + "OK 4- Transferir Filmes Cadastrados para 'Filmes em Breve'. (FILA)\n"
                    + "OK 5- Transferir 'Filmes em Breve' para 'Filmes em Cartaz Hoje'. (LISTA)\n"
                    + "OK 6- Criar novo Cinema. (LISTA)\n"
                    + "OK 7- Criar uma reserva de lugar em LISTA.\n"
                    + "OK 8- Gerar histórico das reservas. (PILHA)\n"
                    + "OK 9- Sair.\n\n"));

            switch (opcao) {
                // 1- Buscar na ARVORE os cinemas em que determinado filme esta passando.
                case 1:

                    break;

                // 2 - Criar Genero.
                case 2:

                    Genero genero = new Genero(JOptionPane.showInputDialog(null, "Insira o nome do novo Gênero:"));
                    listaGenero.insereNo_fim(new IntNoSimples(genero));

                    listaGenero.exibeListaGenero();

                    JOptionPane.showMessageDialog(null, "Gênero criado com sucesso.");

                    break;

                    
                // 3- Cadastrar Filme em uma Fila de Transferencia.
                case 3:
                    
                    // ARRUMAR AQUI
                    
                    if (listaGenero == null) {
                        JOptionPane.showMessageDialog(null, "Por favor, crie um gênero para cadastrar algum filme.");
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

                        String escolhaStr = JOptionPane.showInputDialog(null,
                                "Escolha o cinema que deseja realizar a reserva:\n" + opcoesCinema.toString());

                        if (escolhaStr != null && !escolhaStr.trim().isEmpty()) {
                            try {
                                int escolha = Integer.parseInt(escolhaStr) - 1;

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
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    

                    Genero genero2 = new Genero(nome);

                    Filme filme = new Filme(nome, genero2);

                    nome = JOptionPane.showInputDialog(null, "Insira o nome do novo filme:");

                    filme.setNome(nome);

                    if (listaGenero == null) {
                        JOptionPane.showMessageDialog(null, "Por favor, crie um gênero para cadastrar algum filme.");
                    } else {
                        StringBuilder opcoes = new StringBuilder();
                        for (i = 0; i < generos.size(); i++) {
                            opcoes.append(i + 1).append(": ").append(generos.get(i).getNome());
                            if (i < generos.size() - 1) {
                                opcoes.append("\n");
                            }
                        }
                        int escolha = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha um gênero:\n" + opcoes.toString())) - 1;
                        Genero generoEscolhido = generos.get(escolha);

                        filme.setGenero(generoEscolhido);

                        filaCadastroDeFilmes.enfileirar(filme);
                        JOptionPane.showMessageDialog(null, filme + " - Criado e adicionado à fila com sucesso.");
                        filaCadastroDeFilmes.exibeFilaCadastro();
                    }

                    break;

                // 4- Transferir um Filme à fila de Filmes em Breve.
                case 4:
                    filaFilmesEmBreve.enfileirar(filaCadastroDeFilmes.desenfileirar());
                    filaCadastroDeFilmes.exibeFilaCadastro();
                    filaFilmesEmBreve.exibeFilaEmBreve();

                    break;

                // 5- Transferir um Filme à lista de Filmes Hoje.
                case 5:
                    listaFilmeHoje.insereNo_fim(new IntNoSimples(filaFilmesEmBreve.desenfileirar()));
                    listaFilmeHoje.exibeListaFilme();

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

                        String escolhaStr = JOptionPane.showInputDialog(null,
                                "Escolha o cinema que deseja realizar a reserva:\n" + opcoesCinema.toString());

                        if (escolhaStr != null && !escolhaStr.trim().isEmpty()) {
                            try {
                                int escolha = Integer.parseInt(escolhaStr) - 1;

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

                case 9:
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Por favor, selecione uma opção válida.");
            }
        }

    }

}
