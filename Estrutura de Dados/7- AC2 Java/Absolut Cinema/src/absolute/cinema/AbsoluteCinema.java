package absolute.cinema;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AbsoluteCinema {

    public static void main(String[] args) {

        Pilha pilhaHistoricoDeReserva = new Pilha(20);

        Fila filaCadastroDeFilmes = new Fila(20);
        Fila filaFilmesEmBreve = new Fila(20);
        Fila filaListaDeFilmesAPassar = new Fila(20);

        ListaEncadeada listaFilmeHoje = new ListaEncadeada();

        ArrayList<Genero> generos = new ArrayList<>();
        ArrayList<Filme> arrayFilmes = new ArrayList<>();

        int opcao = 1;
        int i;

        String nome = "";

        while (opcao != 8) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "-- BEM-VINDO AO ABSOLUTE CINEMA --\n\n"
                    + "1- Buscar na ARVORE os cinemas em que determinado filme esta passando\n\n"
                    + "OK 2 - Criar Genero.\n"
                    + "OK 3- Adicionar na FILA CADASTRO DE FILMES\n"
                    + "OK 4- Transferir da fila item '2' para FILA FILMES EM BREVE\n"
                    + "OK 5- Transferir da fila item '3' para LISTA DE FILMES HOJE\n\n"
                    + "6- Criar reserva de lugar em LISTA\n"
                    + "7- Buscar historico de lugares na PILHA\n\n"
                    + "OK 8- Sair\n\n"));

            switch (opcao) {
                case 1:

                    break;

                case 2:

                    Genero genero = new Genero(JOptionPane.showInputDialog(null, "Insira o nome do novo gênero:"));
                    generos.add(genero);

                    System.out.println(generos);

                    JOptionPane.showMessageDialog(null, "Gênero criado com sucesso.");

                    break;

                case 3:
                    Genero genero2 = new Genero(nome);
                    Filme filme = new Filme(nome, genero2);
                    nome = JOptionPane.showInputDialog(null, "Insira o nome do novo filme:");
                    filme.setNome(nome);

                    if (generos == null) {
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

                case 4:
                    filaFilmesEmBreve.enfileirar(filaCadastroDeFilmes.desenfileirar());
                    filaCadastroDeFilmes.exibeFilaCadastro();
                    filaFilmesEmBreve.exibeFilaEmBreve();

                    break;

                case 5:
                    listaFilmeHoje.insereNo_fim(new IntNoSimples(filaFilmesEmBreve.desenfileirar()));
                    listaFilmeHoje.exibeLista();

                    break;

                case 6:

                    break;

                case 7:

                    break;

                case 8:
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Por favor, selecione uma opção válida.");
            }
        }

    }

}
