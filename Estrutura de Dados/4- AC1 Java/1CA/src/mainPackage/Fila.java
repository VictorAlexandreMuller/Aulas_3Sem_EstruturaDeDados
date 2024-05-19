package mainPackage;

public class Fila {

    private int tamanho;
    private int inicio;
    private int fim;
    private int total;
    private Pedido vetor[];

    public Fila(int tam) {
        inicio = 0;
        fim = 0;
        total = 0;
        tamanho = tam;
        vetor = new Pedido[tam];
    }

    public boolean vazia() {
        if (total == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean cheia() {
        if (total == tamanho) {
            return true;
        } else {
            return false;
        }
    }

    public void enfileirar(Pedido elem) {
        if (!cheia()) {
            vetor[fim] = elem;
            fim++;
            total++;
        } else {
            System.out.println("Fila Cheia");
        }
    }

    public Pedido desenfileirar() {
        if (!vazia()) {
            Pedido elem = vetor[inicio];
            inicio = (inicio + 1) % tamanho; // Atualiza o início considerando uma fila circular
            total--;
            return elem;
        } else {
            System.out.println("Fila vazia");
            return null; // Ou lançar uma exceção, dependendo do tratamento que deseja fazer
        }
    }

    /* DO PROFESSOR
	public String desenfileirar(){
		String elem ; 
		if (vazia() == false)
		{
			elem = String.valueOf(vetor[inicio]);
                        System.out.println(elem);
			inicio++;
			total --;
		}else
			elem = "Fila vazia"; 
		return elem; 
	   }
     */
    public void exibeFila() {
        if (vazia() == true) {
            System.out.println("Fila Vazia.");
            /*
            JOptionPane.showMessageDialog(null, 
                    "FILA VAZIA!"); */
        } else {
            for (int i = inicio; i < fim; i++) {
                System.out.println("FILA: Pedido de numero: " + vetor[i].getCodigoDoPedido() + " - Se encontra na posicao: " + i + " da fila.");
            }
        }
        System.out.println(" ");
    }

    // Novos metodos criados fora do escopo do professor ------------------------------
    public int tamanho() {
        return total;
    }

    public Pedido consultar(int j) {
        if (j >= 0 && j < total) {
            return vetor[(inicio + j) % tamanho];
        } else {
            System.out.println("Posicao invalida na fila");
            return null;
        }
    }

}
