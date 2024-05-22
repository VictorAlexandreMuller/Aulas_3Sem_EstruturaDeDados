package absolute.cinema.objetos;

public class PoltronaReservar {
    
    private static int proximoId = 1;
    private int id;
    
    private int numero;
    private Filme filme;
    private Cinema cinema;

    public PoltronaReservar(int numero, Filme filme, Cinema cinema) {
        this.id = proximoId++;
        this.numero = numero;
        this.filme = filme;
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
    
    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    @Override
    public String toString() {
        return "Poltrona: " + numero + ".";
    }
    
    public String imprimirCadastroPoltrona() {
        return "ID: " + id + " - Reserva do Filme: ''" + filme + "'', no Cinema: ''" + cinema + "'', na Poltrona: " + numero + ".";
    }
    
}
