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
                //showListaAutores();
                break;
            case 6:
                //showListaVizinhos();
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
        System.out.println("0 - Voltar");
        System.out.print("\n$ Digite a opção: ");

        Scanner ler = new Scanner(System.in);
        int opc = ler.nextInt();

        switch(opc) {
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
        System.out.println("0 - Voltar");
        System.out.print("\n$ Digite a opção: ");

        Scanner ler = new Scanner(System.in);
        int opc = ler.nextInt();

        switch(opc) {
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
        System.out.println("0 - Voltar");
        System.out.print("\n$ Digite a opção: ");

        Scanner ler = new Scanner(System.in);
        int opc = ler.nextInt();

        switch(opc) {
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
    }
}