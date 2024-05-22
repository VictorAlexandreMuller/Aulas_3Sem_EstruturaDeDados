package absolute.cinema.services;

import absolute.cinema.objetos.Filme;
import absolute.cinema.objetos.Genero;
import absolute.cinema.utils.ArvoreNaria;
import absolute.cinema.utils.IntNoSimples;
import javax.swing.JOptionPane;
import absolute.cinema.utils.ListaEncadeada;
import absolute.cinema.utils.Fila;

public class FilmeServices {

    /*
        "Serviços de Filme:\n"
                    + "OK 40- Cadastrar Filme. (FILA)\n"
                    + "OK 45- Mostrar Lista de Filmes Cadastrados\n"
                    + "50- Mostrar Fila de transferencia\n"
                    + "52- Mostrar Fila de Filmes Em Breve\n"
                    + "53- Mostrar Lista de Filmes Em Cartaz Hoje\n"
    
     */
    public static void CadastroFilme(ListaEncadeada listaFilmes, ListaEncadeada listaGeneros, Fila filaDeTransferencia, ArvoreNaria arvore) {

        if (listaGeneros.ContarNos() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, crie ao menos um gênero antes de cadastrar qualquer filme.");
        } else {

            Genero generoEscolhido = GeneroServices.SelecionarGenero(listaGeneros);

            String nomeFilme = JOptionPane.showInputDialog(null,
                    "Digite o nome do filme que deseja cadastrar:");

            Filme filme = new Filme(nomeFilme, generoEscolhido);

            filme.setNome(nomeFilme);
            filme.setGenero(generoEscolhido);

            listaFilmes.insereNo_fim(new IntNoSimples(filme));
            filaDeTransferencia.enfileirar(filme);
            listaFilmes.exibeListaFilme();
            arvore.insere(filme, generoEscolhido);

            JOptionPane.showMessageDialog(null, "O filme ''" + filme + "'' do gênero ''" + generoEscolhido + "'' foi criado e adicionado à fila com sucesso.");
            filaDeTransferencia.exibeFilaDeTransferencia();
        }
    }

    public static Filme MostrarListaFilmeCadastrados(ListaEncadeada listaFilme) {

        listaFilme.exibeListaFilmeJOPT();
        return null;
    }

    public static Filme MostrarFilaDeTransferencia(Fila filaDeTransferencia) {

        filaDeTransferencia.exibeFilaDeTransferencia();
        return null;
    }

    public static Filme MostrarFilaEmBreve(Fila filaEmBreve) {

        filaEmBreve.exibeFilaEmBreve();
        return null;
    }

    public static Filme MostrarListaEmCartazHoje(ListaEncadeada listaEmCartazHoje) {

        listaEmCartazHoje.exibeListaEmCartazHojeJOPT();
        return null;
    }
}
