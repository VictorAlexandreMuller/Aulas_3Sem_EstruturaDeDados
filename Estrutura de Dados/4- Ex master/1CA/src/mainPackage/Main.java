package mainPackage;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        ListaEncadeada listaE = new ListaEncadeada();
        Pilha pilhaPizzaria = new Pilha(20);
        Fila filaPizzaria = new Fila(20);
        
        int opcao = 1, codigoDoPedido, distancia;
        String descricao, endereco;
        int i = 0;
        IntNoSimples temp_no;
	while (opcao != 7) { 
		opcao = Integer.parseInt (JOptionPane.showInputDialog(null, 
                        "Escolha uma Opçao \n" +
                                
                        "1- Adicionar Novo Pedido\n" +
                        "2- Cancelar Pedido\n" +
                        "3- Listar Todos os Pedidos\n" +
                        "4- Incluir pedidos para preparo\n" +
                        "5- Incluir pedidos para entrega\n" +
                        "6- Gerar relatório para entrega\n" +
                        "7- Informar entrega realizada\n" +
                        "8- Sair\n"));
                
		switch (opcao) {
                    case 1:
                        codigoDoPedido = Integer.parseInt(JOptionPane.
                                showInputDialog(null,
                                        "Inserir um novo pedido no final da lista \n"
                                        + "Digite o código do pedido:"));
                        descricao = JOptionPane.
                                showInputDialog(null,
                                        "Inserir um novo pedido no final da lista \n"
                                        + "Digite a descrição do pedido:");
                        endereco = JOptionPane.
                                showInputDialog(null,
                                        "Inserir um novo pedido no final da lista \n"
                                        + "Digite o endereço do pedido:");
                        distancia = Integer.parseInt(JOptionPane.
                                showInputDialog(null,
                                        "Inserir um novo pedido no final da lista \n"
                                        + "Digite a distância do pedido:"));
                        
                        listaE.insereNo_fim(new IntNoSimples(new Pedido(codigoDoPedido, descricao, endereco, distancia)));
                        break;
                        
                    case 2:
                        codigoDoPedido = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Cancelar Pedido \n"
                                + "Digite o código do pedido a ser cancelado"));
                        listaE.excluiNo(codigoDoPedido);
                        break;
                        
                    case 3:
                        JOptionPane.showMessageDialog(null,
                          "Lista exibida!");
			listaE.exibeLista();
                        break;
                        
                    case 4:
                        codigoDoPedido = Integer.parseInt(
                        JOptionPane.showInputDialog(
                        "Informe o número do pedido:"));
                        
                        int tamanhoLista = listaE.ContarNos();
                        
                        for (i = 1; i < 4; i++) {
                            filaPizzaria.enfileirar(listaE.buscaNo(i).valor);
                        }
                        filaPizzaria.exibeFila();
                        break;
                        
		    case 5:
                        codigoDoPedido = Integer.parseInt(JOptionPane.showInputDialog(
                                "Qual pedido gostaria de encaminhar para a entrega? (Digite o código a ser empilhado)"));
                        
                        for (i = 1; i < 4; i++) {
                            pilhaPizzaria.empilhar(listaE.buscaNo(i).valor);
                        }
			break;
                        
                    case 6:
                        System.out.println("Pilha de Pedidos a serem entregue");
                        pilhaPizzaria.ExibePilha();
			break;
                        
                    case 7:
                        
			
			break;
                        
                    case 8:
                        System.exit(0);
                        
		default : JOptionPane.showMessageDialog(null,
                          "Sair");
            }
        }
    }

}
