package absolute.cinema.objetos;

public class Genero {

    private static int proximoId = 1;
    private int id;
    private String nome;

    public Genero(String nome) {
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
        return nome;
    }

    public String imprimirCadastroGenero() {
        return "ID Genero: " + id + " - Genero: " + nome + ".";

    }

}
