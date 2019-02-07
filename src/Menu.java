import java.util.Scanner;

public class Menu {
    private static Menu INSTANCE = new Menu();

    private Menu() {
        
    }

    public static Menu getInstance() {
        return INSTANCE;
    }

    public void showMenu() {
        System.out.println("--------------------------");
        System.out.println("MENU PRINCIPAL");
        System.out.println("1 - Registrar Empréstimo");
        System.out.println("2 - Registrar Devolução");
        System.out.println("3 - Registrar Doação");

        System.out.println("4 - Listar Livros");
        System.out.println("5 - Listar Autores");
        System.out.println("6 - Listar Vizinhos");

        System.out.println("7 - Listar Empréstimos");
        System.out.println("8 - Listar Devoluções");
        System.out.println("9 - Listar Doações");

        System.out.println("0 - Sair");
        System.out.print("\n$ Digite a opção: ");

        Scanner ler = new Scanner(System.in);
        int opc = ler.nextInt();

        switch(opc) {
            case 1:
                showMenuEmprestimo();
                break;
            case 2:
                showMenuDevolucao();
                break;
            case 3:
                showMenuDoacao();
                break;
            case 4:
                showListaLivros();
                break;
            case 5:
                showListaAutores();
                break;
            case 6:
                showListaVizinhos();
                break;
            case 7:
                showListaEmprestimos();
                break;
            case 8:
                showListaDevolucoes();
                break;
            case 9:
                showListaDoacoes();
                break;
            case 0:
                System.out.println("\nVolte logo!");
                break;
            default:
                showMenu();
                break;
        }
    }

    public void showMenuEmprestimo() {
        System.out.println("--------------------------");
        System.out.println("MENU EMPRÉSTIMO");

        System.out.println("Insira o código do vizinho");
        Scanner ler = new Scanner(System.in);
        int opc = ler.nextInt();
        Vizinho vizinho = null;
        for(Vizinho v: Database.getInstance().getVizinhos()) {
            if(v.getCodigo() == opc) vizinho = v;
        }

        System.out.println("Insira o código do livro");
        opc = ler.nextInt();
        Livro livro = null;
        for(Livro l: Database.getInstance().getLivros()) {
            if(l.getCodigo() == opc) livro = l;
        }

        Emprestimo emprestimo = new Emprestimo(vizinho, livro);
        System.out.println("--------------------------");
        System.out.println("MENU EMPRÉSTIMO\n");
        System.out.println(emprestimo.toString() + "\n");
        System.out.println("1 - Sim");
        System.out.println("0 - Não");
        System.out.print("$ Confirma empréstimo?: ");
        opc = ler.nextInt();

        switch(opc) {
            case 1:
                Database.getInstance().registrarEmprestimo(emprestimo);
                System.out.println("\nEmpréstimo registrado!\n");
                // Wait 2 seconds;
                try{ 
                    Thread.sleep(2000); 
                } catch(Exception e) {
                    Thread.currentThread().interrupt();
                }
            case 0:
                showMenu();
                break;
            default:
                showMenuEmprestimo();
                break;
        }
    }

    public void showMenuDevolucao() {
        System.out.println("--------------------------");
        System.out.println("MENU DEVOLUÇÃO");

        System.out.println("Insira o código do vizinho");
        Scanner ler = new Scanner(System.in);
        int opc = ler.nextInt();
        Vizinho vizinho = null;
        for(Vizinho v: Database.getInstance().getVizinhos()) {
            if(v.getCodigo() == opc) vizinho = v;
        }

        System.out.println("Insira o código do livro");
        opc = ler.nextInt();
        Livro livro = null;
        for(Livro l: Database.getInstance().getLivros()) {
            if(l.getCodigo() == opc) livro = l;
        }

        Devolucao devolucao = new Devolucao(vizinho, livro);
        System.out.println("--------------------------");
        System.out.println("MENU DEVOLUÇÃO\n");
        System.out.println(devolucao.toString() + "\n");
        System.out.println("1 - Sim");
        System.out.println("0 - Não");
        System.out.print("$ Confirma devolução?: ");
        opc = ler.nextInt();

        switch(opc) {
            case 1:
                Database.getInstance().registrarDevolucao(devolucao);
                System.out.println("\nDevolução registrada!\n");
                // Wait 2 seconds;
                try{ 
                    Thread.sleep(2000); 
                } catch(Exception e) {
                    Thread.currentThread().interrupt();
                }
            case 0:
                showMenu();
                break;
            default:
                showMenuDevolucao();
                break;
        }
    }

    public void showMenuDoacao() {
        System.out.println("--------------------------");
        System.out.println("MENU DOAÇÃO");

        Vizinho vizinho = null;
        System.out.print("$ Insira o código do vizinho: ");
        Scanner ler = new Scanner(System.in);
        int opc = Integer.parseInt(ler.nextLine());
        for(Vizinho v: Database.getInstance().getVizinhos()) {
            if(v.getCodigo() == opc) vizinho = v;
        }

        Livro livro = null;
        int codigoLivro = Database.getInstance().getLivros().size()+1;
        System.out.print("$ Insira o título do livro: ");
        String titulo = ler.nextLine();

        Autor autor = null;
        int codigoAutor = Database.getInstance().getAutores().size()+1;
        System.out.print("$ Insira o nome do autor (entre aspas): ");
        String nome = ler.nextLine();

        System.out.print("$ Insira o ano de publicação: ");
        int ano = Integer.parseInt(ler.nextLine());

        livro = new Livro(codigoLivro, titulo, ano);
        autor = new Autor(codigoAutor, nome);
        Doacao doacao = new Doacao(vizinho, livro);

        System.out.println("--------------------------");
        System.out.println("MENU DOAÇÃO\n");
        System.out.println(doacao.toString() + "\n");
        System.out.println("1 - Sim");
        System.out.println("0 - Não");
        System.out.print("$ Confirma doação?: ");
        opc = ler.nextInt();

        switch(opc) {
            case 1:
                Database.getInstance().getLivros().add(livro);
                Database.getInstance().getAutores().add(autor);
                Database.getInstance().registrarDoacao(doacao);
                System.out.println("\nDoação registrada!\n");
                // Wait 2 seconds;
                try{ 
                    Thread.sleep(2000); 
                } catch(Exception e) {
                    Thread.currentThread().interrupt();
                }
            case 0:
                showMenu();
                break;
            default:
                showMenuDoacao();
                break;
        }
    }

    public void showListaLivros() {
        System.out.println("--------------------------");
        System.out.println("LISTA DE LIVROS");
        Database.getInstance().listarLivros();
        System.out.println("\nFim!");
        // Wait 2 seconds;
        try{ 
            Thread.sleep(2000); 
        } catch(Exception e) {
            Thread.currentThread().interrupt();
        }
        showMenu();
    }

    public void showListaAutores() {
        System.out.println("--------------------------");
        System.out.println("LISTA DE AUTORES");
        Database.getInstance().listarAutores();
        System.out.println("\nFim!");
        // Wait 2 seconds;
        try{ 
            Thread.sleep(2000); 
        } catch(Exception e) {
            Thread.currentThread().interrupt();
        }
        showMenu();
    }

    public void showListaVizinhos() {
        System.out.println("--------------------------");
        System.out.println("LISTA DE VIZINHOS");
        Database.getInstance().listarVizinhos();
        System.out.println("\nFim!");
        // Wait 2 seconds;
        try{ 
            Thread.sleep(2000); 
        } catch(Exception e) {
            Thread.currentThread().interrupt();
        }
        showMenu();
    }

    public void showListaEmprestimos() {
        System.out.println("--------------------------");
        System.out.println("LISTA DE EMPRESTIMOS");
        Database.getInstance().listarEmprestimos();
        System.out.println("\nFim!");
        // Wait 2 seconds;
        try{ 
            Thread.sleep(2000); 
        } catch(Exception e) {
            Thread.currentThread().interrupt();
        }
        showMenu();
    }

    public void showListaDevolucoes() {
        System.out.println("--------------------------");
        System.out.println("LISTA DE DEVOLUÇÕES");
        Database.getInstance().listarDevolucoes();
        System.out.println("\nFim!");
        // Wait 2 seconds;
        try{ 
            Thread.sleep(2000); 
        } catch(Exception e) {
            Thread.currentThread().interrupt();
        }
        showMenu();
    }

    public void showListaDoacoes() {
        System.out.println("--------------------------");
        System.out.println("LISTA DE DOAÇÕES");
        Database.getInstance().listarDoacoes();
        System.out.println("\nFim!");
        // Wait 2 seconds;
        try{ 
            Thread.sleep(2000); 
        } catch(Exception e) {
            Thread.currentThread().interrupt();
        }
        showMenu();
    }
}