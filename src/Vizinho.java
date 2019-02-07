import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Vizinho extends Pessoa {
    private int codigo;

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

    public List<Emprestimo> getEmprestimos() {
        List<Emprestimo> emprestimos = Database.getInstance().getEmprestimos()
                                        .stream()
                                        .filter(e -> e.getVizinho().getCodigo() == this.codigo)
                                        .collect(Collectors.toList());
        return emprestimos;
    }

    @Override
    public String toString() {
        String vizinho = "(Código): " + this.codigo + 
                        "\n (Nome): " + super.getNome();
        return vizinho;
    }
}