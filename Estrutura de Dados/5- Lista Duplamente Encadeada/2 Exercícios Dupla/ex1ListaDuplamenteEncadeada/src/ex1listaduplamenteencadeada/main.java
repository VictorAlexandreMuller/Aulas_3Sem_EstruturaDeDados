package ex1listaduplamenteencadeada;

import javax.swing.JOptionPane;

public class main {

    public static void main(String[] args) {

        ListaDupla listaDupla = new ListaDupla();
        
        int opcao = 1, numero;

        while (opcao != 3) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Escolha uma Opção: \n\n"
                    + "1- Adicionar Numero\n"
                    + "2- Mostrar Lista Duplamente Encadeada\n"
                    + "3- Sair\n\n"));

            switch (opcao) {
                case 1:
                    numero = Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    null,
                                    "Insira um novo numero"));
                    listaDupla.insereNo(new IntNoDuplo(numero));
                    
                    break;

                case 2:
                    IntNoDuplo temp_no = listaDupla.primeiro;
                    while (temp_no != null) {
                        System.out.println(temp_no.valor);
                        temp_no = temp_no.prox;
                    }

                    break;

                case 3:
                    System.exit(0);

                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Por favor, selecione uma opção válida.");
            }
        }
    }

}
