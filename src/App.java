public class App {
    public static void main(String args[]) {
        System.out.print("Bem-vindo à Biblioteca Ágil!\n");

        Database.start();

        Menu.getInstance().showMenu();

    }
}