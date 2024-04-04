/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicio3fila;

import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class Exercicio3Fila {
    public static void main(String[] args) {
        Fila F1 = new Fila(10);
        Fila F2 = new Fila(10);
        int valor, qtdElemF1=0, qtdElemF2=0;
        
        while(!F1.cheia()){
            valor = Integer.parseInt(
                    JOptionPane.showInputDialog("Informe o "
                    + "valor a ser inserido na Fila F1:"));
            if(valor == 0) break;
            F1.enfileirar(valor);
        }
        
        while(!F2.cheia()){
               valor = Integer.parseInt(
                    JOptionPane.showInputDialog("Informe o "
                    + "valor a ser inserido na Fila F2:"));
            if(valor == 0) break;
            F2.enfileirar(valor);
        }
        
        while(!F1.vazia()){
            F1.desenfileirar();
            qtdElemF1++;
        }
        while(!F2.vazia()){
            F2.desenfileirar();
            qtdElemF2++;
        }
        if(qtdElemF1 > qtdElemF2){
            JOptionPane.showMessageDialog(null, 
                    "Fila F1 tem mais elementos que a Fila F2");
        }
        else{
            JOptionPane.showMessageDialog(null, 
                    "Fila F2 tem mais elementos que a Fila F1");        
        }
    }
    
}
