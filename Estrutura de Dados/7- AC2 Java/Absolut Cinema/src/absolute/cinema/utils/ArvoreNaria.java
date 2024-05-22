package absolute.cinema.utils;

public class ArvoreNaria {

    private Nodo raiz;

    public ArvoreNaria(Object valorRaiz) {
        raiz = new Nodo(valorRaiz);
    }

    public Nodo getRaiz() {
        return raiz;
    }

    // busca recursiva em busca do nodo especificado no parametro
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

    // insere um novo nodo como filho do nodo que contem o valor especificado no parametro
    public boolean insere(Object novoValor, Object valorPai) {
        Nodo pai = buscaNodo(valorPai, raiz);
        if (pai == null) {
            return false;
        }
        Nodo filho = new Nodo(novoValor);
        pai.adicionarFilho(filho);
        return true;
    }

    // exibe a arvore a partir de um novo especifico passado no parametro
    public void exibirArvore(Nodo nodo, boolean fim) {
        if (nodo == null) {
            return;
        }
        System.out.print(nodo.getValor().toString() + "(");
        for (Nodo filho : nodo.getFilhos()) {
            exibirArvore(filho, false);
        }
        System.out.print(")");
        if (fim) {
            System.out.println("\n---------------------");
        }
    }

    // exibe a arvore toda, ou seja, a partir da raiz
    public void exibirArvore() {
        exibirArvore(raiz, true);
        System.out.println();
    }
}
