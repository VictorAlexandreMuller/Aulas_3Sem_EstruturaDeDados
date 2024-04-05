package mainPackage;

public class Fila {
    private int tamanho;
    private int inicio;
    private int fim;
    private int total;
    private Pedido vetor[]; 
    
    public Fila(int tam){
		inicio = 0;
		fim = 0;
		total = 0;
		tamanho = tam;
		vetor = new Pedido [tam];
	}
	public boolean vazia() {
		if (total == 0)
			return true;
		else
			return false;
	}
	public boolean cheia() {
	if (total == tamanho)
		return true;
	else
		return false;
	}
	public void enfileirar(Pedido elem) {
		if (!cheia())
		{ 
			vetor[fim] = elem;
			fim++;
			total++;
		}
		else
			System.out.println("Fila Cheia");
		} 
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
	public void exibeFila(){
	for (int i = inicio; i < fim; i++)
		System.out.println("Posicao da fila: " + i + " Codigo do Pedido " + vetor[i].getCodigoDoPedido());
	}
}