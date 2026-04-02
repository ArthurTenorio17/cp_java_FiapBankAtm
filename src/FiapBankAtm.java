import java.util.Scanner;

public class FiapBankAtm {

    public static boolean temRepetido(String senha) {
        for (int i = 0; i < senha.length(); i++) {
            for (int j = i + 1; j < senha.length(); j++) {
                if (senha.charAt(i) == senha.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String senhaCadastrada;
        boolean senhaValida;

        System.out.println("=====================");
        System.out.println("==== Bem-Vindo! =====");
        System.out.println("=== FIAP BANK ATM ===");
        System.out.println("=====================");

        do {
            System.out.print("Cadastre uma senha (6 dígitos, sem repetição): ");
            senhaCadastrada = scanner.nextLine();

            senhaValida = senhaCadastrada.matches("\\d{6}") && !temRepetido(senhaCadastrada);

            if (!senhaValida) {
                System.out.println("Senha inválida!");
            }

        } while (!senhaValida);
    }
}