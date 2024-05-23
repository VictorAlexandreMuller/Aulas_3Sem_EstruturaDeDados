package absolute.cinema.utils;

import absolute.cinema.objetos.Cinema;
import absolute.cinema.objetos.Filme;
import absolute.cinema.objetos.Genero;

public class IntNoSimples {

    public Filme valorFilme;
    public Cinema valorCinema;
    public Genero valorGenero;
    public IntNoSimples prox;

    public IntNoSimples(Filme ValorNo) {
        valorFilme = ValorNo;
        prox = null;
    }
    
    public IntNoSimples(Cinema ValorNo) {
        valorCinema = ValorNo;
        prox = null;
    }
    
    public IntNoSimples(Genero ValorNo) {
        valorGenero = ValorNo;
        prox = null;
    }
}
