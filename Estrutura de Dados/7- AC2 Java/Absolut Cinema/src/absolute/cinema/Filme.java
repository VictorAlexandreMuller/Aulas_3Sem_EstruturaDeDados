package absolute.cinema;

import java.util.ArrayList;
import java.util.List;

public class Filme {

    private static int proximoId = 1;
    private int id;
    private String nome;
    List<Cinema> cinemas;
    private Genero genero;

    public Filme(String nome, Genero genero) {
        this.id = proximoId++;
        this.nome = nome;
        this.cinemas = new ArrayList<>();
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
    
    public void addCinema(Cinema cinema){
        this.cinemas.add(cinema);
    }

    @Override
    public String toString() {
        return "Filme: " + nome + " Gênero: " + genero;
    }

}
