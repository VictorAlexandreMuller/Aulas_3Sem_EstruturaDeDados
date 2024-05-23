package absolute.cinema.objetos;

import java.util.HashMap;
import java.util.Map;

public class Cinema {

    private static int proximoId = 1;
    private int id;
    private String nome;
    private int quantidadePoltronas;
    private Map<Filme, boolean[]> poltronasReservadasPorFilme;

    public Cinema(String nome, int quantidadePoltronas) {
        this.id = proximoId++;
        this.nome = nome;
        this.quantidadePoltronas = quantidadePoltronas;
        this.poltronasReservadasPorFilme = new HashMap<>();
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

    public int getQuantidadePoltronas() {
        return quantidadePoltronas;
    }

    public void setQuantidadePoltronas(int quantidadePoltronas) {
        this.quantidadePoltronas = quantidadePoltronas;
    }

    public boolean reservarPoltrona(int numeroPoltrona, Filme filme) {
        if (numeroPoltrona < 1 || numeroPoltrona > quantidadePoltronas) {
            return false;
        }

        boolean[] poltronasReservadas = poltronasReservadasPorFilme.getOrDefault(filme, new boolean[quantidadePoltronas]);
        if (poltronasReservadas[numeroPoltrona - 1]) {
            return false; // Poltrona já reservada
        }

        poltronasReservadas[numeroPoltrona - 1] = true;
        poltronasReservadasPorFilme.put(filme, poltronasReservadas);
        return true; // Poltrona reservada com sucesso
    }

    @Override
    public String toString() {
        return nome;
    }

    public String imprimirCadastroCinema() {
        return "ID: " + id + " - Cinema: " + nome + " - Possui (" + quantidadePoltronas + ") poltronas.";
    }

}
