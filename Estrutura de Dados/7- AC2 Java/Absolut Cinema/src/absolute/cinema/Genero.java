package absolute.cinema;

import java.util.ArrayList;
import java.util.List;

public class Genero {
    
    private static int proximoId = 1;
    private int id;
    private String nome;
    List<Filme> filmes;

    public Genero(String nome) {
        this.id = proximoId++;
        this.nome = nome;
        this.filmes = new ArrayList<>();
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

    public void addFilme (Filme filme) {
        this.filmes.add(filme);
    }
    
    @Override
    public String toString() {
        return nome;
    }
    
    
}
