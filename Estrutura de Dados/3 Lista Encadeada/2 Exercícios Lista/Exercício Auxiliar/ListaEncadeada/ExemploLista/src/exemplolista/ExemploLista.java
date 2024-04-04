package exemplolista;

import javax.swing.JOptionPane;

public class ExemploLista {
    int i = 0;
    IntNoSimples temp_no;
    int valor;
    public static void main(String[] args) {
        ListaEncadeada l = new ListaEncadeada();
        int opcao = 1, valor, posicao;
	while (opcao != 7) { 
		opcao = Integer.parseInt (JOptionPane.showInputDialog(null, 
                        "Escolha uma Opçao \n" + "1-Inserir Nó no início \n" + 
		"2-Inserir Nó no fim \n" + "3-Inserir Nó em uma posição\n" + "4-Localizar Nó \n" + 
		"5-Excluir Nó \n" + "6-Exibir lista \n" + "7-Sair"));
		switch (opcao) {
		case 1 :
			valor = Integer.parseInt (JOptionPane.showInputDialog(null, "Inserir um Nó no início da lista\n" + 
			"Digite um valor"));
			l.insereNo_inicio(new IntNoSimples(valor));
			break;
		case 2 :
			valor = Integer.parseInt (JOptionPane.
			showInputDialog(null, "Inserir um Nó no final da lista \n" +
			"Digite um valor"));
			l.insereNo_fim(new IntNoSimples(valor));
			break;
		case 3 :
			valor = Integer.parseInt (JOptionPane.showInputDialog(null, 
                                "Inserir um Nó em uma posição \n" + 
                                "Digite um valor"));
                        posicao = Integer.parseInt (JOptionPane.showInputDialog(null, "Digite a posição"));
                        l.insereNo_posicao(new IntNoSimples(valor),posicao);
			break;
		case 4:
			valor = Integer.parseInt (JOptionPane.showInputDialog(null, "Localiza um valor \n" + 
                                "Digite um valor"));
			l.buscaNo(valor);
		break;
		case 5:
			valor = Integer.parseInt (JOptionPane.showInputDialog(null, 
                                "Exclui um nó da lista \n" + "Digite um valor"));
			l.excluiNo(valor);
			break;
		case 6:
			JOptionPane.showMessageDialog(null,"Exibe a lista");
			l.exibeLista();
			break;
		default : JOptionPane.showMessageDialog(null,"Sair");
            }
        }
    
    }
}
