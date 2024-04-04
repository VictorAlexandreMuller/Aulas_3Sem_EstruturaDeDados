/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicio1.fila;

import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class Exercicio1Fila {
    public static void main(String[] args) {
        Fila F = new Fila(10);
        int valor;
        while(!F.cheia()){
            valor = Integer.parseInt(JOptionPane.showInputDialog(
                "Informe o valor"
                + " a ser inserido na Fila:"));
            if(valor!=0){
                F.enfileirar(valor);
            }
            else{
                break;
            }
        }
        F.exibeFila();
    }
    
}
