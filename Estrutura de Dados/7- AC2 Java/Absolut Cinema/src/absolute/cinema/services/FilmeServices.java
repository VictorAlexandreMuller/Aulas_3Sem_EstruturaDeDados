package absolute.cinema.services;

import absolute.cinema.objetos.Cinema;
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
            return;
        }

        Genero generoEscolhido = GeneroServices.SelecionarGenero(listaGeneros);

        if (generoEscolhido == null) {
            return;
        }

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

    public static Filme SelecionarFilmeEmCartaz(ListaEncadeada listaEmCartazHoje) {

        StringBuilder opcoesFilmeEmCartaz = new StringBuilder();
        IntNoSimples temp_no = listaEmCartazHoje.primeiro;
        int posicao = 0;

        while (temp_no != null) {
            opcoesFilmeEmCartaz.append(posicao + 1)
                    .append(": ")
                    .append(temp_no.valorFilme.getNome())
                    .append("\n");

            temp_no = temp_no.prox;
            posicao++;
        }

        String escolhaFilmeEmCartaz = JOptionPane.showInputDialog(null,
                "Escolha o Filme Em Cartaz:\n" + opcoesFilmeEmCartaz.toString());

        if (escolhaFilmeEmCartaz == null || escolhaFilmeEmCartaz.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Opção inválida.");
            return null;
        }

        int escolha;

        try {
            escolha = Integer.parseInt(escolhaFilmeEmCartaz) - 1;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Opção inválida.");
            return null;
        }

        if (escolha < 0 || escolha >= listaEmCartazHoje.ContarNos()) {
            JOptionPane.showMessageDialog(null,
                    "Opção inválida.");
            return null;
        }

        IntNoSimples noEscolhido = listaEmCartazHoje.primeiro;
        for (int j = 0; j < escolha; j++) {
            noEscolhido = noEscolhido.prox;
        }

        return noEscolhido.valorFilme;
    }

    public static Filme FilmeAddCinema(ListaEncadeada listaFilmeHoje, ListaEncadeada listaCinemas, ArvoreNaria arvoreGeneroFilmeCinemaPoltrona) {
        if (listaFilmeHoje.ContarNos() == 0) {
            JOptionPane.showMessageDialog(null, "Não há nenhum Filme Em Cartaz para que possa ser gerado algum vínculo.");
            return null;
        } else if (listaCinemas.ContarNos() == 0) {
            JOptionPane.showMessageDialog(null, "Não há nenhum Cinema cadastrado para que possa ser gerado algum vínculo.");
        }

        Filme filmeSelecionado = FilmeServices.SelecionarFilmeEmCartaz(listaFilmeHoje); // return noEscolhido.valorFilme;

        Cinema cinemaSelecionado = CinemaServices.SelecionarCinema(listaCinemas); // return noEscolhido.valorCinema;
        
        arvoreGeneroFilmeCinemaPoltrona.insere(cinemaSelecionado, filmeSelecionado);

        JOptionPane.showMessageDialog(null, "O cinema ''" + cinemaSelecionado
                + "'' foi vinculado ao filme ''" + filmeSelecionado + "''."
                + "\n"
                + "Repita a ação caso deseje vincular outro cinema a este filme.");
        
        return null;
    }

}
