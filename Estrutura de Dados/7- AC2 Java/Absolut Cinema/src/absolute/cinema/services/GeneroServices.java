package absolute.cinema.services;

import absolute.cinema.objetos.Genero;
import absolute.cinema.utils.ArvoreNaria;
import javax.swing.JOptionPane;
import absolute.cinema.utils.IntNoSimples;
import absolute.cinema.utils.ListaEncadeada;

public class GeneroServices {

    /*
    
    "Serviços de Gênero:\n"
                    + "OK 1- Criar novo Gênero.\n"
                    + "OK 2- Mostrar Lista de Gêneros\n"
    
     */
    public static void CadastrarGenero(ListaEncadeada listaGenero, ArvoreNaria arvore) {

        Genero genero = new Genero(JOptionPane.showInputDialog(null, "Insira o nome do novo Gênero:"));

        listaGenero.insereNo_fim(new IntNoSimples(genero));

        listaGenero.exibeListaGenero();

        arvore.insere(genero, "SelecionarOGenero");

        JOptionPane.showMessageDialog(null, "Gênero ''" + genero + "'' criado com sucesso.");
    }

    public static Genero MostrarListaGenero(ListaEncadeada listaGenero) {

        listaGenero.exibeListaGeneroJOPT();
        return null;
    }

    public static Genero SelecionarGenero(ListaEncadeada listaGeneros) {

        StringBuilder opcoesGenero = new StringBuilder();
        IntNoSimples temp_no = listaGeneros.primeiro;
        int posicao = 0;

        while (temp_no != null) {
            opcoesGenero.append(posicao + 1)
                    .append(": ")
                    .append(temp_no.valorGenero.getNome())
                    .append("\n");

            temp_no = temp_no.prox;
            posicao++;
        }

        String escolhaGenero = JOptionPane.showInputDialog(null,
                "Escolha o Gênero do filme a ser cadastrado:\n" + opcoesGenero.toString());

        if (escolhaGenero == null || escolhaGenero.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Opção inválida.");
            return null;
        }

        int escolha;

        try {
            escolha = Integer.parseInt(escolhaGenero) - 1;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Opção inválida.");
            return null;
        }

        if (escolha < 0 || escolha >= listaGeneros.ContarNos()) {
            JOptionPane.showMessageDialog(null,
                    "Opção inválida.");
            return null;
        }

        IntNoSimples noEscolhido = listaGeneros.primeiro;
        for (int j = 0; j < escolha; j++) {
            noEscolhido = noEscolhido.prox;
        }

        return noEscolhido.valorGenero;
    }

}
