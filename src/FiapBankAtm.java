import java.util.Scanner;

public class FiapBankAtm {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String senhaCadastrada;
        boolean senhaValida;

        System.out.println("=====================");
        System.out.println("==== Bem-Vindo! =====");
        System.out.println("=== FIAP BANK ATM ===");
        System.out.println("=====================");

        do {
            System.out.print("Cadastre uma senha (6 dígitos): ");
            senhaCadastrada = scanner.nextLine();

            senhaValida = senhaCadastrada.matches("\\d{6}");

            if (!senhaValida) {
                System.out.println("Senha inválida!");
            }

        } while (!senhaValida);
    }
}