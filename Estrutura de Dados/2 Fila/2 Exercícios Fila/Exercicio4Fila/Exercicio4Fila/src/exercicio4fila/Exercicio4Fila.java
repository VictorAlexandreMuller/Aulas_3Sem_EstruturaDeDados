/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicio4fila;

import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class Exercicio4Fila {
    public static void main(String[] args) {
        Fila filaProcesso = new Fila(20);
        int numProc;
        int opcao;
        
        do{
            opcao = Integer.parseInt(
          JOptionPane.showInputDialog("1 - Inserir processo na fila\n"
                + "2 - Retirar processo mais antigo\n"
                + "3 - Exibir os processos na fila\n"
                + "0 - Sair\n"
                + "Informe a opção desejada:\n"));
            
            switch(opcao){
                case 0: break;
                case 1: numProc = Integer.parseInt(
                        JOptionPane.showInputDialog(
                        "Informe o número do processo:"));
                        filaProcesso.enfileirar(numProc);
                        break;
                case 2: 
                        JOptionPane.showMessageDialog(null, 
                 "Processo removido:" + filaProcesso.desenfileirar());
                        break;
                case 3:
                        filaProcesso.exibeFila();
                        break;
                default:  
                    JOptionPane.showMessageDialog(null, 
                            "Opção inválida!");
            }
        }while(opcao!=0);
        
    }
    
}
