import java.util.ArrayList;

public class Vizinho extends Pessoa {
    private int codigo;
    private ArrayList<Emprestimo> emprestimos;

    public Vizinho(int cod, String nome) {
        super(nome);
        setCodigo(cod);
    }

    public int getCodigo() {
        return this.codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}