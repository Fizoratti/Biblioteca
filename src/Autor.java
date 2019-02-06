import java.util.ArrayList;

public class Autor extends Pessoa {
    private ArrayList<Livro> livros;

    public Autor(String nome) {
        super(nome);
    }

    public ArrayList getLivros() {
        return this.livros;
    }
    public void addLivro(Livro livro) {
        livros.add(livro);
    }
}