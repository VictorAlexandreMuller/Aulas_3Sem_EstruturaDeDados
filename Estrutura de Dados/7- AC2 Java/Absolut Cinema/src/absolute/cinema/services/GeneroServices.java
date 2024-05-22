package absolute.cinema.services;

import absolute.cinema.objetos.Genero;
import javax.swing.JOptionPane;
import absolute.cinema.utils.IntNoSimples;
import absolute.cinema.utils.ListaEncadeada;

public class GeneroServices {
    
    /*
    
    "Serviços de Gênero:\n"
                    + "OK 1- Criar novo Gênero.\n"
                    + "OK 2- Mostrar Lista de Gêneros\n"
    
    */

    public static void CadastrarGenero(ListaEncadeada listaGenero) {

        Genero genero = new Genero(JOptionPane.showInputDialog(null, "Insira o nome do novo Gênero:"));

        listaGenero.insereNo_fim(new IntNoSimples(genero));

        listaGenero.exibeListaGenero();

        JOptionPane.showMessageDialog(null, "Gênero ''" + genero + "'' criado com sucesso.");
    }
    
    public static Genero MostrarListaGenero (ListaEncadeada listaGenero) {
        
        listaGenero.exibeListaGeneroJOPT();
        return null;
    }

    public static Genero SelecionarGenero(ListaEncadeada listaGenero) {

        StringBuilder opcoesGenero = new StringBuilder();
        IntNoSimples temp_no = listaGenero.primeiro;
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

        if (escolhaGenero == null || escolhaGenero.trim().isEmpty()) { // O método trim() remove espaços em branco de ambas as extremidades de uma string.
            JOptionPane.showMessageDialog(null, "Opção inválida.");
            return null;
        }

        int escolha = Integer.parseInt(escolhaGenero) - 1;

        if (escolha < 0 || escolha >= listaGenero.ContarNos()) {
            JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, insira uma opção válida.");
            return null;
        }

        IntNoSimples noEscolhido = listaGenero.primeiro;
        for (int j = 0; j < escolha; j++) {
            noEscolhido = noEscolhido.prox;
        }

        return noEscolhido.valorGenero;
    }

}
