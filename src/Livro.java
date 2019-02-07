public class Livro {
    private int codigo;
    private String titulo;
    private int anoPublicacao;
    private Autor autor;

    // Construtor
    public Livro(int cod, String tit, int ano) {
        codigo = cod;
        titulo = tit;
        anoPublicacao = ano;
    }

    // Get&Set
    public int getCodigo() {
        return this.codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getTitulo() {
        return this.titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getAnoPublicacao() {
        return this.anoPublicacao;
    }
    public void setAnoPublicacao(int ano) {
        this.anoPublicacao = ano;
    }
    public Autor getAutor(){
        return this.autor;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        String livro = "(Número): " + this.codigo + 
                    "\n (Título): " + this.titulo +
                    "\n (Ano) : " + this.anoPublicacao;
        if(autor != null) livro.concat("\n (Autor) " + this.autor.getNome());
        
        return livro;
    }
}