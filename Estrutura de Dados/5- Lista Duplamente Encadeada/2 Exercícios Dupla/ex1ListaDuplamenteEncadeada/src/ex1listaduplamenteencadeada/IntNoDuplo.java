package ex1listaduplamenteencadeada;

public class IntNoDuplo {
    int valor;
    IntNoDuplo prox;
    IntNoDuplo ant;
 
    IntNoDuplo (int ValorNo){
    valor = ValorNo;
    prox = ant = null;
    }
}
