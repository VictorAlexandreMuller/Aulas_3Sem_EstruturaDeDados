package absolute.cinema.utils;

public class ArvoreNaria {

    private Nodo raiz;

    public ArvoreNaria(Object valorRaiz) {
        raiz = new Nodo(valorRaiz);
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public Nodo buscaNodo(Object valor, Nodo nodo) {
        if (nodo == null) {
            return null;
        }
        if (nodo.getValor().equals(valor)) {
            return nodo;
        }
        for (Nodo filho : nodo.getFilhos()) {
            Nodo resultado = buscaNodo(valor, filho);
            if (resultado != null) {
                return resultado;
            }
        }
        return null;
    }

    public boolean insere(Object novoValor, Object valorPai) {
        Nodo pai = buscaNodo(valorPai, raiz);
        if (pai == null) {
            return false;
        }
        Nodo filho = new Nodo(novoValor);
        pai.adicionarFilho(filho);
        return true;
    }

    public void exibirArvore(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        System.out.print(nodo.getValor().toString() + "(");
        for (Nodo filho : nodo.getFilhos()) {
            exibirArvore(filho);
        }
        System.out.print(")");
    }

    public void exibirArvore() {
        exibirArvore(raiz);
        System.out.println();
    }
}
