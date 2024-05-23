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
    
    // insere um novo nodo como filho do nodo que contém o valor especificado no parâmetro
    public boolean inserePoltrona(Object novoValor, Nodo nodoPai) {
        if (nodoPai == null) {
            return false;
        }
        Nodo filho = new Nodo(novoValor);
        nodoPai.adicionarFilho(filho);
        return true;
    }

    // arvore inline sem poltronas a partir de um determinado nodo
    public void exibirArvore(Nodo nodo, boolean fim) {
        if (nodo == null) {
            return;
        }
        System.out.print(nodo.getValor().toString() + " (");
        for (Nodo filho : nodo.getFilhos()) {
            exibirArvore(filho, false);
        }
        System.out.print(")");
        if (fim) {
            System.out.println("\n---------------------");
        }
    }

    // arvore inline inteira a partir da raiz sem poltronas
    public void exibirArvore() {
        exibirArvore(raiz, true);
        System.out.println();
    }

    // molde para os dois próximos métodos abaixo
    private void exibirArvoreJeitoDois(Nodo nodo, int nivel) {
        if (nodo == null) {
            return;
        }

        // indentação de acordo com o nível do nó
        for (int i = 0; i < nivel; i++) {
            System.out.print("  ");
        }

        // imprime o valor do nó
        System.out.println(nodo.getValor().toString());

        // imprime os filhos do nó
        for (Nodo filho : nodo.getFilhos()) {
            exibirArvoreJeitoDois(filho, nivel + 1);
        }
    }

    // arvore growth inteira sem poltronas
    public void exibirArvoreInteiraAPartirDaRaiz() {
        exibirArvoreJeitoDois(raiz, 0);
        System.out.println("\n---------------------");
    }

    // arvore growth a partir de um nodo sem poltronas
    public void exibirArvoreAPartirDeUmNodo(Nodo nodo) {
        exibirArvoreJeitoDois(nodo, 0);
        System.out.println("\n---------------------");
    }
    
    

}
