package absolute.cinema.utils;

public class Nodo {

    public int chave;
    public Nodo primFilho;
    public Nodo proxIrmao;

    public Nodo(int chave) {
        this.chave = chave;
        this.primFilho = null;
        this.proxIrmao = null;
    }

}
