import java.util.ArrayList;

public class Autor extends Pessoa {
    private int codigo;
    private ArrayList<Livro> livros;

    public Autor(int cod, String nome) {
        super(nome);
        setCodigo(cod);
    }

    public ArrayList getLivros() {
        return this.livros;
    }
    public void addLivro(Livro livro) {
        livros.add(livro);
    }

    public int getCodigo() {
        return this.codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        String autor = "(Código): " + this.codigo + 
                    "\n (Nome): " + super.getNome();
        return autor;
    }
}