import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Database {
    private ArrayList<Livro> livros;
    private ArrayList<Autor> autores;
    private ArrayList<Vizinho> vizinhos;

    private ArrayList<Emprestimo> emprestimos;
    private ArrayList<Devolucao> devolucoes;
    private ArrayList<Doacao> doacoes;

    private static Database INSTANCE = new Database();

    private Database() {
        livros = new ArrayList<>();
        autores = new ArrayList<>();
        vizinhos = new ArrayList<>();

        emprestimos = new ArrayList<>();
        devolucoes = new ArrayList<>();
        doacoes = new ArrayList<>();

        carregarLivros();
        carregarAutores();
        carregarVizinhos();

        carregarLivrosAutores();
        carregarEmprestimos();
        carregarDevolucoes();
        carregarDoacoes();
    }

    public static Database getInstance() {
        return INSTANCE;
    }
    public static void start() {
        getInstance();
    }

    public ArrayList<Livro> getLivros() {
        return this.livros;
    }
    public ArrayList<Autor> getAutores() {
        return this.autores;
    }
    public ArrayList<Vizinho> getVizinhos() {
        return this.vizinhos;
    }
    public ArrayList<Emprestimo> getEmprestimos() {
        return this.emprestimos;
    }
    public ArrayList<Devolucao> getDevolucoes() {
        return this.devolucoes;
    }
    public ArrayList<Doacao> getDoacoes() {
        return this.doacoes;
    }
    // Métodos para carregar os dados principais
    public void carregarLivros() {
        Path path = Paths.get("Livros.txt");
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
        String linha = br.readLine();
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

    public void carregarAutores() {
        Path path = Paths.get("Autores.txt");
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
        String linha = br.readLine();
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
    
    public void carregarVizinhos() {
        Path path = Paths.get("Vizinhos.txt");
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
        String linha = br.readLine();
        while ((linha = br.readLine()) != null) {
            // separador: ;
            Scanner sc = new Scanner(linha).useDelimiter(";");

            // Atributos do Vizinho
            int codigo = Integer.parseInt(sc.next());
            String nome = sc.next();

            // Cria o objeto Vizinho e adiciona na lista
            vizinhos.add(new Vizinho(codigo, nome));
        }
        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }



    //Métodos para carregar os dados de ligação
    public void carregarLivrosAutores() {
        Path path = Paths.get("Livros_Autores.txt");
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
        String linha = br.readLine();
        while ((linha = br.readLine()) != null) {
            // separador: ;
            Scanner sc = new Scanner(linha).useDelimiter(";");

            // Atributos do Livro
            int codigoLivro = Integer.parseInt(sc.next());
            int codigoAutor = Integer.parseInt(sc.next());
            // Procura o livro com o codigo lido
            for(Livro l: livros) {
                if(l.getCodigo() == codigoLivro) {
                    // Procura o autor com o codigo lido
                    for(Autor a: autores) {
                        if(a.getCodigo() == codigoAutor) {
                            // Atribui o autor encontrado ao livro encontrado
                            l.setAutor((Autor) a);
                            // Atribui o livro encontrado ao autor encontrado
                            a.addLivro(l);
                        }
                    }
                }
            }
            
        }
        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }

    public void carregarEmprestimos() {
        Path path = Paths.get("Emprestimos.txt");
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String linha = br.readLine();
            while ((linha = br.readLine()) != null) {
                // separador: ;
                Scanner sc = new Scanner(linha).useDelimiter(";");

                // Dados do empréstimo
                int codigoVizinho = Integer.parseInt(sc.next());
                int codigoLivro = Integer.parseInt(sc.next());
                String data = sc.next();

                // Procura o vizinho com o mesmo codigo lido
                for(Vizinho v: vizinhos) {
                    if(v.getCodigo() == codigoVizinho) {
                        // Procura o livro com o codigo lido
                        for(Livro l: livros) {
                            if(l.getCodigo() == codigoLivro) {
                                // Cria o objeto empréstimo e adiciona na lista
                                emprestimos.add(new Emprestimo(v,l,data));
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }

    public void carregarDevolucoes() {
        Path path = Paths.get("Devolucoes.txt");
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String linha = br.readLine();
            while ((linha = br.readLine()) != null) {
                // separador: ;
                Scanner sc = new Scanner(linha).useDelimiter(";");

                // Dados do empréstimo
                int codigoVizinho = Integer.parseInt(sc.next());
                int codigoLivro = Integer.parseInt(sc.next());
                String data = sc.next();

                // Procura o vizinho com o mesmo codigo lido
                for(Vizinho v: vizinhos) {
                    if(v.getCodigo() == codigoVizinho) {
                        // Procura o livro com o codigo lido
                        for(Livro l: livros) {
                            if(l.getCodigo() == codigoLivro) {
                                // Cria o objeto empréstimo e adiciona na lista
                                devolucoes.add(new Devolucao(v,l,data));
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }

    public void carregarDoacoes() {
        Path path = Paths.get("Doacoes.txt");
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String linha = br.readLine();
            while ((linha = br.readLine()) != null) {
                // separador: ;
                Scanner sc = new Scanner(linha).useDelimiter(";");

                // Dados do empréstimo
                int codigoVizinho = Integer.parseInt(sc.next());
                int codigoLivro = Integer.parseInt(sc.next());
                String data = sc.next();

                // Procura o vizinho com o mesmo codigo lido
                for(Vizinho v: vizinhos) {
                    if(v.getCodigo() == codigoVizinho) {
                        // Procura o livro com o codigo lido
                        for(Livro l: livros) {
                            if(l.getCodigo() == codigoLivro) {
                                // Cria o objeto empréstimo e adiciona na lista
                                doacoes.add(new Doacao(v,l,data));
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }
    


    // Listagem
    public void listarLivros() {
        for(Livro l: livros) {
            System.out.println();
            System.out.println(l.toString());
        }
    }

    public void listarAutores() {
        for(Autor a: autores) {
            System.out.println();
            System.out.println(a.toString());
        }
    }

    public void listarVizinhos() {
        for(Vizinho v: vizinhos) {
            System.out.println();
            System.out.println(v.toString());
        }
    }

    public void listarEmprestimos() {
        for(Emprestimo e: emprestimos) {
            System.out.println();
            System.out.println(e.toString());
        }
    }

    public void listarDevolucoes() {
        for(Devolucao d: devolucoes) {
            System.out.println();
            System.out.println(d.toString());
        }
    }
    
    public void listarDoacoes() {
        for(Doacao d: doacoes) {
            System.out.println();
            System.out.println(d.toString());
        }
    }

    // Registrar dados
    public void registrarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
        Path path = Paths.get("Emprestimos.txt");
        try(PrintWriter writer = new PrintWriter(
            Files.newBufferedWriter(path, Charset.defaultCharset()))) {
            writer.println("Vizinho;Livro;Data");
            for(Emprestimo e: emprestimos) {
                writer.println(e.getVizinho().getCodigo() + ";" +
                                e.getLivro().getCodigo() + ";" +
                                e.getData());
            }
        } catch (IOException e) {
            System.err.format("Erro de E/S: %S%n", e);
        }
    }

    public void registrarDevolucao(Devolucao devolucao) {
        devolucoes.add(devolucao);
        Path path = Paths.get("Devolucoes.txt");
        try(PrintWriter writer = new PrintWriter(
            Files.newBufferedWriter(path, Charset.defaultCharset()))) {
            writer.println("Vizinho;Livro;Data");
            for(Devolucao d: devolucoes) {
                writer.println(d.getVizinho().getCodigo() + ";" +
                                d.getLivro().getCodigo() + ";" +
                                d.getData());
            }
        } catch (IOException e) {
            System.err.format("Erro de E/S: %S%n", e);
        }
    }

    public void registrarDoacao(Doacao doacao) {
        doacoes.add(doacao);
        Path path = Paths.get("Doacoes.txt");
        try(PrintWriter writer = new PrintWriter(
            Files.newBufferedWriter(path, Charset.defaultCharset()))) {
            writer.println("Vizinho;Livro;Data");
            for(Doacao d: doacoes) {
                writer.println(d.getVizinho().getCodigo() + ";" +
                                d.getLivro().getCodigo() + ";" +
                                d.getData());
            }
        } catch (IOException e) {
            System.err.format("Erro de E/S: %S%n", e);
        }
    }
}