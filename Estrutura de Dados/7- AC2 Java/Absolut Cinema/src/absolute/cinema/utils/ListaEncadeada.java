package absolute.cinema.utils;

import javax.swing.JOptionPane;

public class ListaEncadeada {

    public IntNoSimples primeiro, ultimo;
    public int numero_nos = 0;

    public ListaEncadeada() {
        primeiro = ultimo = null;
    }

    public void insereNo_fim(IntNoSimples novoNo) {
        novoNo.prox = null;
        if (primeiro == null) {
            primeiro = novoNo;
        }
        if (ultimo != null) {
            ultimo.prox = novoNo;
        }
        ultimo = novoNo;
        numero_nos++;
    }

    public void insereNo_inicio(IntNoSimples novoNo) {
        novoNo.prox = primeiro;
        if (primeiro == null && ultimo == null) //Só tem um elemento na lista
        {
            ultimo = novoNo;
        }
        primeiro = novoNo;
        numero_nos++;
    }

    public int ContarNos() {
        int tamanho = 0;
        IntNoSimples temp_no = primeiro;
        while (temp_no != null) {
            tamanho++;
            temp_no = temp_no.prox;
        }
        return tamanho;
    }

    public void insereNo_posicao(IntNoSimples novoNo, int posicao) {
        IntNoSimples temp_no = primeiro;
        int numero_nos = ContarNos();
        int pos_aux;
        if (posicao == 0) {
            novoNo.prox = primeiro;
            if (primeiro == ultimo) {
                ultimo = novoNo;
            }
            primeiro = novoNo;
        } else {
            if (posicao <= numero_nos) {
                pos_aux = 1;
                while (temp_no != null && posicao > pos_aux) {
                    temp_no = temp_no.prox;
                    pos_aux++;
                }
                novoNo.prox = temp_no.prox;
                temp_no.prox = novoNo;
            } else {
                if (posicao > numero_nos) {
                    ultimo.prox = novoNo;
                    ultimo = novoNo;
                }
            }
        }
    }

// -------------------------------------------------------------------------------------------------------------------------
    public IntNoSimples buscaNoFilme(int buscaValor) {
        int i = 0;
        IntNoSimples temp_no = primeiro;
        while (temp_no != null) {
            if (temp_no.valorFilme.getId() == buscaValor) {
                //JOptionPane.showMessageDialog(null, "No " + temp_no.valorFilme + " posição " + i);
                return temp_no;
            }
            i++;
            temp_no = temp_no.prox;
        }
        return null;
    }

    public IntNoSimples buscaNoCinema(int buscaValor) {
        int i = 0;
        IntNoSimples temp_no = primeiro;
        while (temp_no != null) {
            if (temp_no.valorCinema.getId() == buscaValor) {
                //JOptionPane.showMessageDialog(null, "No " + temp_no.valorCinema + " posição " + i);
                return temp_no;
            }
            i++;
            temp_no = temp_no.prox;
        }
        return null;
    }

    public IntNoSimples buscaNoGenero(int buscaValor) {
        int i = 0;
        IntNoSimples temp_no = primeiro;
        while (temp_no != null) {
            if (temp_no.valorGenero.getId() == buscaValor) {
                //JOptionPane.showMessageDialog(null, "No " + temp_no.valorCinema + " posição " + i);
                return temp_no;
            }
            i++;
            temp_no = temp_no.prox;
        }
        return null;
    }

// -------------------------------------------------------------------------------------------------------------------------
    public void excluiNoFilme(int valor) {
        IntNoSimples temp_no = primeiro;
        IntNoSimples anterior_no = null;
        while (temp_no != null && temp_no.valorFilme.getId() != valor) {
            anterior_no = temp_no;
            temp_no = temp_no.prox;
        }
        if (temp_no == primeiro) {
            if (temp_no.prox != null) {
                primeiro = temp_no.prox;
            } else {
                primeiro = null;
            }
        } else {
            anterior_no.prox = temp_no.prox;
        }

        if (ultimo == temp_no) {
            ultimo = anterior_no;
        }
    }

    public void excluiNoCinema(int valor) {
        IntNoSimples temp_no = primeiro;
        IntNoSimples anterior_no = null;
        while (temp_no != null && temp_no.valorCinema.getId() != valor) {
            anterior_no = temp_no;
            temp_no = temp_no.prox;
        }
        if (temp_no == primeiro) {
            if (temp_no.prox != null) {
                primeiro = temp_no.prox;
            } else {
                primeiro = null;
            }
        } else {
            anterior_no.prox = temp_no.prox;
        }

        if (ultimo == temp_no) {
            ultimo = anterior_no;
        }
    }

    public void excluiNoGenero(int valor) {
        IntNoSimples temp_no = primeiro;
        IntNoSimples anterior_no = null;
        while (temp_no != null && temp_no.valorGenero.getId() != valor) {
            anterior_no = temp_no;
            temp_no = temp_no.prox;
        }
        if (temp_no == primeiro) {
            if (temp_no.prox != null) {
                primeiro = temp_no.prox;
            } else {
                primeiro = null;
            }
        } else {
            anterior_no.prox = temp_no.prox;
        }

        if (ultimo == temp_no) {
            ultimo = anterior_no;
        }
    }

// -------------------------------------------------------------------------------------------------------------------------
    public void exibeListaFilme() {
        IntNoSimples temp_no = primeiro;
        int i = 0;
        while (temp_no != null) {
            System.out.println("Lista de Filmes em Cartaz Hoje: " + "Posicao: " + i + " - " + temp_no.valorFilme); // O temp_no.valorFilme ja esta puxando o toString da classe Filme
            temp_no = temp_no.prox;
            i++;
        }
        System.out.println("---------------");
    }

    public void exibeListaCinema() {
        IntNoSimples temp_no = primeiro;
        int i = 0;
        while (temp_no != null) {
            System.out.println("Lista de Cinemas: " + "Posicao: " + i + " - " + temp_no.valorCinema); // O temp_no.valorCinema ja esta puxando o toString da classe Cinema
            temp_no = temp_no.prox;
            i++;
        }
        System.out.println("---------------");
    }

    public void exibeListaGenero() {
        IntNoSimples temp_no = primeiro;
        int i = 0;
        while (temp_no != null) {
            System.out.println("Lista de Cinemas: " + "Posicao: " + i + " - " + temp_no.valorGenero); // O temp_no.valorGenero ja esta puxando o toString da classe Genero
            temp_no = temp_no.prox;
            i++;
        }
        System.out.println("---------------");
    }

// -------------------------------------------------------------------------------------------------------------------------
}
