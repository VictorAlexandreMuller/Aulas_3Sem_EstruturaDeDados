package mainPackage;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        ListaEncadeada listaE = new ListaEncadeada();
        ArrayList<Pedido> pedidosEntreguess = new ArrayList<>();
        Pilha pilhaPizzaria = new Pilha(20);
        Fila filaPizzaria = new Fila(20);

        int opcao = 1, codigoDoPedido, distancia;
        String descricao, endereco;
        int i = 0;
        int entregasRealizadas = 0;

        while (opcao != 8) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Escolha uma Opção: \n\n"
                    + "1- Adicionar Novo Pedido\n"
                    + "2- Cancelar Pedido\n"
                    + "3- Listar Todos os Pedidos\n"
                    + "4- Incluir pedidos para preparo\n"
                    + "5- Incluir pedidos para entrega\n"
                    + "6- Gerar relatório para entrega\n"            
                    + "7- Informar entrega realizada\n"                              
                    + "8- Sair\n\n"));

            switch (opcao) {
                case 1:
                    descricao = JOptionPane.
                            showInputDialog(null,
                                    "Inserir um novo pedido no final da lista \n"
                                    + "Informe a descrição do pedido:");
                    endereco = JOptionPane.
                            showInputDialog(null,
                                    "Inserir um novo pedido no final da lista \n"
                                    + "Informe o endereço do pedido:");
                    distancia = Integer.parseInt(JOptionPane.
                            showInputDialog(null,
                                    "Inserir um novo pedido no final da lista \n"
                                    + "Informe a distância do pedido (km):"));

                    listaE.insereNo_fim(new IntNoSimples(new Pedido(descricao, endereco, distancia)));
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
                    // Percorre todos os pedidos na lista encadeada
                    for (i = 1; i <= listaE.ContarNos(); i++) {

                        Pedido pedido = listaE.buscaNo(i).valor;
                        boolean jaNaFila = false;

                        // Verifica se o pedido já está na fila
                        for (int j = 0; j < filaPizzaria.tamanho(); j++) {
                            Pedido pedidoNaFila = (Pedido) filaPizzaria.consultar(j);
                            if (pedidoNaFila.getCodigoDoPedido() == pedido.getCodigoDoPedido()) {
                                jaNaFila = true;
                                break;
                            }
                        }

                        // Adiciona o pedido se ele não estiver na fila
                        if (!jaNaFila) {
                            filaPizzaria.enfileirar(pedido);
                        }
                    }
                    filaPizzaria.exibeFila();
                    pilhaPizzaria.ExibePilha();
                    break;

                case 5:

                    // Remove os pedidos da fila e armazena eles temporariamente
                    Pedido[] pedidos = new Pedido[filaPizzaria.tamanho()];
                    for (i = 0; i < pedidos.length; i++) {
                        pedidos[i] = (Pedido) filaPizzaria.desenfileirar();
                    }

                    // Organiza os pedidos pela distância usando bubble sort
                    for (i = 0; i < pedidos.length - 1; i++) {
                        for (int j = 0; j < pedidos.length - i - 1; j++) {
                            if (pedidos[j].getDistancia() < pedidos[j + 1].getDistancia()) {
                    // Troca os pedidos de lugar se for necessario (aula de revisao da prova)
                                Pedido temp = pedidos[j];
                                pedidos[j] = pedidos[j + 1];
                                pedidos[j + 1] = temp;
                            }
                        }
                    }

                    // Empilha os pedidos na pilha (o primeiro pedido empilhado será o mais distante)
                    for (Pedido pedido : pedidos) {
                        pilhaPizzaria.empilhar(pedido);
                    }
                    JOptionPane.showMessageDialog(null, "Pedidos retirados da fila e adicionados à pilha corretamente.");
                    filaPizzaria.exibeFila();
                    pilhaPizzaria.ExibePilha();
                    break;

                case 6:
                    // Exibe o nome do relatório para entrega
                    String relatorio = "Relatório para Entrega:\n";

                    // Retira os pedidos da pilha e os adiciona ao relatório
                    while (!pilhaPizzaria.vazia()) {
                        Pedido pedido = pilhaPizzaria.desempilhar();
                        relatorio += "Código do Pedido: " + pedido.getCodigoDoPedido() + "\n";
                        relatorio += "Endereço: " + pedido.getEndereco() + "\n";
                        relatorio += "Distância: " + pedido.getDistancia() + " km\n\n";
                        entregasRealizadas += 1;
                        pedidosEntreguess.add(pedido);
                    }
                    JOptionPane.showMessageDialog(null, relatorio);
                    filaPizzaria.exibeFila();
                    pilhaPizzaria.ExibePilha();
                    break;

                case 7:
                    if (entregasRealizadas < 2) {
                        JOptionPane.showMessageDialog(null, "Não é possível informar entrega realizada. Ainda é necessário realizar mais " + (2 - entregasRealizadas) + " entregas.");
                        break;
                    }

                    // Exclui os pedidos entregues da lista principal
                    for (Pedido pedido : pedidosEntreguess) {
                        listaE.excluiPedido(pedido);
                    }

                    JOptionPane.showMessageDialog(null, "Pedidos entregues foram removidos da lista com sucesso.");
                    listaE.exibeLista();
                    break;
                    
                case 8:
                    System.exit(0);

                default:
                    JOptionPane.showMessageDialog(null,
                            "Por favor, selecione uma opção válida.");
            }
        }
    }
    
}
