package absolute.cinema.objetos;

public class PoltronaReservar {
    
    private static int proximoId = 1;
    private int id;
    
    private int numero;
    private Cinema cinema;

    public PoltronaReservar(int numero, Cinema cinema) {
        this.id = proximoId++;
        this.numero = numero;
        this.cinema = cinema;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public String toString() {
        return "Poltrona: " + numero + ".";
    }
    
    public String imprimirCadastroPoltrona() {
        return "ID Reserva: " + id + " - Cinema: " + cinema + " - Poltrona: " + numero + ".";

    }
    
}
