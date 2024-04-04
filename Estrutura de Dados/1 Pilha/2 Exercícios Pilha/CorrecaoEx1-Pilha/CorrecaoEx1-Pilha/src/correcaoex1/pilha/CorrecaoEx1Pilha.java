/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package correcaoex1.pilha;

import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class CorrecaoEx1Pilha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pilha p = new Pilha(10); //Criação do objeto Pilha
        int num;
        do{
           num = Integer.parseInt(JOptionPane.showInputDialog(
           "Digite o número inteiro a ser inserido na Pilha:"));
           if(num==0){
               break;
           }
           else{
                 p.empilhar(num);
            }   
        }while(num!=0 && !p.cheia());
        p.ExibePilha();
    }
    
}
