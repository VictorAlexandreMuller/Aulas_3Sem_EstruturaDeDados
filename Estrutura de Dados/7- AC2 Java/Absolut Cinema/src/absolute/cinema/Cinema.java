package absolute.cinema;

public class Cinema {
    
    private static int proximoId = 1;
    private int id;
    private String nome;

    public Cinema(int id, String nome) {
        this.id = proximoId++;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "ESTE É O MÉTODO toSting DO OBJETO CINEMA.";
    }
    
}
