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
        //carregarLivros();
        carregarPessoas();
    }

    public static Database getInstance() {
        return INSTANCE;
    }
    public static void start() {
        getInstance();
    }

    public void carregarLivros() {

    }

    public void carregarPessoas() {
        Path path = Paths.get("Autores.txt");
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
        String linha = null;
        while ((linha = br.readLine()) != null) {
            // separador: ;
            Scanner sc = new Scanner(linha).useDelimiter(";");
            System.out.println(sc.next()+"; "+sc.next()+"; ");

        }
        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }
     
}