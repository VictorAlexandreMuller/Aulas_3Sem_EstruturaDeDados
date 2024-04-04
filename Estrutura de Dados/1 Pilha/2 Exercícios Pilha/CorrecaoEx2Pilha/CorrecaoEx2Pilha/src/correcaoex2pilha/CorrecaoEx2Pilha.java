/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package correcaoex2pilha;

import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class CorrecaoEx2Pilha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pilha p = new Pilha(10);
        Pilha aux = new Pilha(10);
        String placa, buscaPlaca;
        boolean achou=false;
        do{
            placa = JOptionPane.showInputDialog("Informe"
                    + " a placa do veículo:");
            if(placa.equals("sair")){
                break;
            }
            else{
                p.empilhar(placa);
                aux.empilhar(placa);
            }
        }while(!p.cheia());
        
        buscaPlaca = JOptionPane.showInputDialog("Digite a placa"
                + " do carro que irá sair da rua:");
        while(!aux.vazia()){
            placa = String.valueOf(aux.desempilhar());
            if(placa.equals(buscaPlaca)){
                achou = true;
                break;
            }
        }
        if (achou){
            while(!p.vazia()){
                placa = String.valueOf(p.desempilhar());
                if(placa.equals(buscaPlaca)){
                    break;
                }
                else{
                    JOptionPane.showMessageDialog(null, 
                            "O carro a ser removido é:"+ placa);
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, 
                    "Veículo não se encontra estacionado na rua!");
        }
        
        
    }
    
}
