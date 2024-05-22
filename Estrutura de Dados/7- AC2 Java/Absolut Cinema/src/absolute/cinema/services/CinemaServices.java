package absolute.cinema.services;

import absolute.cinema.objetos.Cinema;
import absolute.cinema.utils.IntNoSimples;
import absolute.cinema.utils.ListaEncadeada;
import javax.swing.JOptionPane;

public class CinemaServices {
    
    /*
    "Serviços de Cinema:\n"
                    + "OK 55- Criar novo Cinema.\n"
                    + "60- Mostrar Lista de Cinemas Cadastrados.\n"
                    + "65- Adicionar Filme ao Cinema.\n"
    */
    
    public static void CadastrarCinema(ListaEncadeada listaCinemas, int quantidadeDePoltronas) {
        
        String nomeCinema = JOptionPane.showInputDialog(null, "Insira o nome do novo Cinema a ser cadastrado:");
                    quantidadeDePoltronas = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a quantidade de poltronas existentes neste cinema:"));

                    Cinema cinema = new Cinema(nomeCinema, quantidadeDePoltronas);

                    listaCinemas.insereNo_fim(new IntNoSimples(cinema));

                    listaCinemas.exibeListaCinema();

                    JOptionPane.showMessageDialog(null, "Cinema ''" + cinema + "'' criado com sucesso.");

        
    }
    
    public static Cinema MostrarCinemasCadastrados (ListaEncadeada listaCinema) {
        
        listaCinema.exibeListaCinemaJOPT();
        return null;
    }
    
    
    
}
