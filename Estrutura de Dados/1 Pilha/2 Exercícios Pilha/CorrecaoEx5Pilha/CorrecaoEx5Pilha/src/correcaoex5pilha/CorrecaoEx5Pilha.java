/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package correcaoex5pilha;

import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class CorrecaoEx5Pilha {

    public static void main(String[] args) {
        Pilha sites = new Pilha(10);
        String url;
        int op;
        
        do{
            op=Integer.parseInt(JOptionPane.showInputDialog(
            "1 - Visitar um novo site\n" +
            "2 - Voltar ao site anterior\n" + 
            "3 - Sair\n"
            ));

            switch(op){
                case 1:
                    url=JOptionPane.showInputDialog(
                       "Digite a url visitada:");
                    sites.empilhar(url);
                    break;
                case 2:
                   sites.desempilhar();
                   url = String.valueOf(sites.desempilhar());
                   JOptionPane.showMessageDialog(null, url);
                   break;
                case 3:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, 
                            "Operação inválida!");
           }
        }while(op!=3);
       
    }
    
}
