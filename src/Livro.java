public class Livro {
    private int codigo;
    private String titulo;
    private Autor autor;
    private int anoPublicacao;

    // Construtor
    public livro(int cod, String tit, Autor aut, int ano) {
        codigo = cod;
        titulo = tit;
        autor = aut;
        anoPublicacao = ano;
    }
}