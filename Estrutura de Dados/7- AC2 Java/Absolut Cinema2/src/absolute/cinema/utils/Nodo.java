package absolute.cinema.utils;

import java.util.ArrayList;
import java.util.List;

public class Nodo {

    private Object valor;
    private List<Nodo> filhos;

    public Nodo(Object valor) {
        this.valor = valor;
        this.filhos = new ArrayList<>();
    }

    public Object getValor() {
        return valor;
    }

    public List<Nodo> getFilhos() {
        return filhos;
    }

    public void adicionarFilho(Nodo filho) {
        this.filhos.add(filho);
    }

}
