package absolute.cinema.objetos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Cinema {

    private static int proximoId = 1;
    private int id;
    private String nome;

    private int quantidadePoltronas;
    private List<Boolean> poltronasDisponiveis;

    public Cinema(String nome, int quantidadePoltronas) {
        this.id = proximoId++;
        this.nome = nome;
        this.quantidadePoltronas = quantidadePoltronas;
        this.poltronasDisponiveis = new ArrayList<>(quantidadePoltronas);
        for (int i = 0; i < quantidadePoltronas; i++) {
            poltronasDisponiveis.add(true);
        }
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

    public boolean reservarPoltrona(int numeroPoltrona) {
        if (numeroPoltrona < 1 || numeroPoltrona > quantidadePoltronas) {
            JOptionPane.showMessageDialog(null, "Número da poltrona inválido.");
            ;
        }
        if (poltronasDisponiveis.get(numeroPoltrona - 1)) {
            poltronasDisponiveis.set(numeroPoltrona - 1, false);
            return true; // Poltrona pode ser reservada
        } else {
            return false; // Poltrona ja reservada
        }
    }

    public boolean isPoltronaDisponivel(int numeroPoltrona) {
        if (numeroPoltrona < 1 || numeroPoltrona > quantidadePoltronas) {
            throw new IllegalArgumentException("Número da poltrona inválido.");
        }
        return poltronasDisponiveis.get(numeroPoltrona - 1);
    }

    @Override
    public String toString() {
        return "ID Cinema: " + id + " - Cinema: " + nome + " - Possui (" + quantidadePoltronas + ") poltronas.";
    }
    
    public String imprimirNomeCinema() {
        return nome;
    }

}
