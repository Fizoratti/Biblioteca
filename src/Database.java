import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.io.IOException;

public class Database {
    private ArrayList<Livro> livros;
    private ArrayList<Pessoa> autores;
    private ArrayList<Pessoa> vizinhos;

    private static Database INSTANCE = new Database();

    private Database() {
        livros = new ArrayList<>();
        autores = new ArrayList<>();
        vizinhos = new ArrayList<>();

        carregarLivros();
        carregarPessoas();
        //carregarVizinhos();
    }

    public static Database getInstance() {
        return INSTANCE;
    }
    public static void start() {
        getInstance();
    }

    public void carregarLivros() {
        Path path = Paths.get("Livros.txt");
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
        String linha = null;
        while ((linha = br.readLine()) != null) {
            // separador: ;
            Scanner sc = new Scanner(linha).useDelimiter(";");

            // Atributos do Livro
            int codigo = Integer.parseInt(sc.next());
            String titulo = sc.next();
            int ano = Integer.parseInt(sc.next());
            // Cria uma instancia do Livro e adiciona na lista
            livros.add(new Livro(codigo, titulo, ano));
        }
        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }

    public void carregarPessoas() {
        Path path = Paths.get("Autores.txt");
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
        String linha = null;
        while ((linha = br.readLine()) != null) {
            // separador: ;
            Scanner sc = new Scanner(linha).useDelimiter(";");

            // Atributos do Autor
            int codigo = Integer.parseInt(sc.next());
            String nome = sc.next();
            // Cria o objeto Autor e adiciona na lista
            autores.add(new Autor(codigo, nome));
        }
        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }
     
}