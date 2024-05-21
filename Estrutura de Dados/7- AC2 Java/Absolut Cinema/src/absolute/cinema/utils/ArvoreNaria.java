package absolute.cinema.utils;

public class ArvoreNaria {

    private Nodo raiz;

    public ArvoreNaria(int chaveRaiz) {
        raiz = new Nodo(chaveRaiz);
    }

    public Nodo buscaChave(int chave, Nodo raiz) {
        if (raiz == null) {
            return null;
        }
        if (raiz.chave == chave) {
            return raiz;
        }
        Nodo p = raiz.primFilho;
        while (p != null) {
            Nodo resp = buscaChave(chave, p);
            if (resp != null) {
                return resp;
            }
            p = p.proxIrmao;
        }
        return null;
    }

    public boolean insere(int novaChave, int chavePai) {
        Nodo pai = buscaChave(chavePai, raiz);
        if (pai == null) {
            return false;
        }
        Nodo filho = new Nodo(novaChave);
        if (pai.primFilho == null) {
            pai.primFilho = filho;
        } else {
            Nodo p = pai.primFilho;
            while (p.proxIrmao != null) {
                p = p.proxIrmao;
            }
            p.proxIrmao = filho;
        }
        return true;
    }

    public void exibirArvore(Nodo raiz) {
        if (raiz == null) {
            return;
        }
        System.out.print(raiz.chave + "(");
        Nodo p = raiz.primFilho;
        while (p != null) {
            exibirArvore(p);
            p = p.proxIrmao;
        }
        System.out.print(")");
    }

    public void exibirArvore() {
        exibirArvore(raiz);
        System.out.println();
    }

    public Nodo getRaiz() {
        return raiz;
    }

}
