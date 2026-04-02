import java.util.Scanner;

public class FiapBankAtm {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String senhaCadastrada;

        System.out.println("=====================");
        System.out.println("==== Bem-Vindo! =====");
        System.out.println("=== FIAP BANK ATM ===");
        System.out.println("=====================");

        System.out.print("Cadastre uma senha: ");
        senhaCadastrada = scanner.nextLine();
    }
}