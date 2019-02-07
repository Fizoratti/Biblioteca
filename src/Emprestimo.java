import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Emprestimo {
    private Vizinho vizinho;
    private Livro livro;
    private Date data;
    
    public Emprestimo(Vizinho vizinho, Livro livro) {
        setVizinho(vizinho);
        setLivro(livro);
        this.data = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
    }
}