/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package correcaoex4pilha;

import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class CorrecaoEx4Pilha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pilha P = new Pilha(8);
        Pilha N = new Pilha(8);
        int[] array = new int[8];
        
        for(int i=0; i<array.length; i++){
            array[i] = Integer.parseInt(JOptionPane.showInputDialog(
                    "Informe o número a ser inserido no array:"));
            if(array[i] < 0){
                N.empilhar(array[i]);
            }
            else if(array[i] > 0){
                P.empilhar(array[i]);
            }
            else{
                N.desempilhar();
                P.desempilhar();
            }
            System.out.println("Array["+i+"]:"+ array[i]);
        }
        System.out.println("Pilha P");
        P.ExibePilha();
        System.out.println("Pilha N");
        N.ExibePilha();
        
    }
    
}
