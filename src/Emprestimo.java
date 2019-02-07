import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Emprestimo {
    private Vizinho vizinho;
    private Livro livro;
    private String data;
    
    public Emprestimo(Vizinho vizinho, Livro livro) {
        setVizinho(vizinho);
        setLivro(livro);
        this.data = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
    }

    public Vizinho getVizinho() {
        return this.vizinho;
    }
    public void setVizinho(Vizinho vizinho) {
        this.vizinho = vizinho;
    }
    public Livro getLivro() {
        return this.livro;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    public String getData() {
        return this.data;
    }

    @Override
    public String toString() {
        String emprestimo = "(Vizinho): " + this.vizinho.getNome() + 
                        "\n (Livro): " + this.livro.getTitulo() +
                        "\n (Data): " + this.data;
        return emprestimo;
    }
}