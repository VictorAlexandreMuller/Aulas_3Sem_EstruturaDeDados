package mainPackage;

public class Pedido {
    private static int proximoCodigo = 1;
    
    private int codigoDoPedido;
    private String descricao;
    private String endereco;
    private int distancia;
    private boolean entregue;

    public Pedido() {
        this.codigoDoPedido = proximoCodigo++;
    }

    public Pedido(String descricao, String endereco, int distancia) {
        this.codigoDoPedido = proximoCodigo++;
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

    public boolean isEntregue() {
        return entregue;
    }

    public void marcarEntregue() {
        this.entregue = true;
    }
    
}
