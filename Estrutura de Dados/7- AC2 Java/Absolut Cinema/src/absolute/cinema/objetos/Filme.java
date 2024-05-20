package absolute.cinema.objetos;

public class Filme {

    private static int proximoId = 1;
    private int id;
    private String nome;
    private Genero genero;

    public Filme(String nome, Genero genero) {
        this.id = proximoId++;
        this.nome = nome;
        this.genero = genero;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
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
        return "ID Filme: " + id + " - Filme: " + nome + " - Gênero: " + genero + ".";
    }

}
