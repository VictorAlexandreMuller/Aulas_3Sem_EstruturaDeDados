package absolute.cinema.services;

import absolute.cinema.objetos.Filme;
import absolute.cinema.objetos.Genero;
import absolute.cinema.utils.IntNoSimples;
import javax.swing.JOptionPane;
import absolute.cinema.utils.ListaEncadeada;
import absolute.cinema.utils.Fila;

public class FilmeServices {
    
    public static void CadastroFilme(ListaEncadeada listaFilmes, ListaEncadeada listaGenero, Fila filaFilmesCadastrados) {
        
        Genero generoEscolhido = GeneroServices.SelecionarGenero(listaGenero);
        
        String nomeFilme = JOptionPane.showInputDialog(null,
                "Digite o nome do filme que deseja cadastrar:");
        
        Filme filme = new Filme(nomeFilme, generoEscolhido);
        
        filme.setNome(nomeFilme);
        filme.setGenero(generoEscolhido);
        
        listaFilmes.insereNo_fim(new IntNoSimples(filme));
        filaFilmesCadastrados.enfileirar(filme);
        
        JOptionPane.showMessageDialog(null, "O filme ''" + filme + "'' do gênero ''" + generoEscolhido + "'' foi criado e adicionado à fila com sucesso.");
        filaFilmesCadastrados.exibeFilaCadastroFilme();
        
    }    
}
