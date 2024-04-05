package mainPackage;

public class Pedido {
    private int codigoDoPedido;
    private String descricao;
    private String endereco;
    private int distancia;

    public Pedido() {
    }

    public Pedido(int codigoDoPedido, String descricao, String endereco, int distancia) {
        this.codigoDoPedido = codigoDoPedido;
        this.descricao = descricao;
        this.endereco = endereco;
        this.distancia = distancia;
    }

    public int getCodigoDoPedido() {
        return codigoDoPedido;
    }

    public void setCodigoDoPedido(int codigoDoPedido) {
        this.codigoDoPedido = codigoDoPedido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    
    
    
}
