package exercicio2fila;
import javax.swing.JOptionPane;
public class Exercicio2Fila {
    
    public static int maior(Fila f){
        int valor;
        int maior=Integer.parseInt(f.desenfileirar());
        while(!f.vazia()){
            valor =Integer.parseInt(f.desenfileirar());
            if(valor > maior){
                maior = valor;
            }
        }
        return maior;
    }
    
    public static int menor(Fila f){
        int valor;
        int menor=Integer.parseInt(f.desenfileirar());
        while(!f.vazia()){
            valor =Integer.parseInt(f.desenfileirar());
            if(valor < menor){
                menor = valor;
            }
        }
        return menor;
    }
    public static int media(Fila f){
        int qtdElem=0, soma=0, valor;
        while(!f.vazia()){
            valor = Integer.parseInt(f.desenfileirar());
            soma += valor;
            qtdElem++;
        }
        return(soma/qtdElem);
    }
    public static void main(String[] args) {
    //Criação das Filas - 3 Cópias
    //As cópias são necessárias para obter o maior, menor e a média
        Fila F = new Fila(10);
        Fila F2 = new Fila(10);
        Fila F3 = new Fila(10);
        int valor;   
        while(!F.cheia()){
            valor = Integer.parseInt(JOptionPane.showInputDialog(
            "Informe o valor a ser inserido na Fila:"));
            if(valor==0) break;
            F.enfileirar(valor);
            F2.enfileirar(valor);
            F3.enfileirar(valor);
        }
        JOptionPane.showMessageDialog(null, 
                "O maior valor encontrado na fila é:"+
                        maior(F));
        JOptionPane.showMessageDialog(null, 
                "O menor valor encontrado na fila é:"+
                        menor(F2));
        JOptionPane.showMessageDialog(null, 
                "A media dos valores encontrados na fila é:"+
                        media(F3));
    }
    
}
