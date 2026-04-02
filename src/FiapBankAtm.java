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
        String senhaDigitada;
        boolean senhaValida;

        System.out.println("=====================");
        System.out.println("==== Bem-Vindo! =====");
        System.out.println("=== FIAP BANK ATM ===");
        System.out.println("=====================");

        do {
            System.out.print("Cadastre uma senha: ");
            senhaCadastrada = scanner.nextLine();

            senhaValida = senhaCadastrada.matches("\\d{6}") && !temRepetido(senhaCadastrada);

        } while (!senhaValida);

        int tentativas = 3;
        boolean autenticado = false;

        while (tentativas > 0) {
            System.out.print("Digite sua senha: ");
            senhaDigitada = scanner.nextLine();

            if (senhaDigitada.equals(senhaCadastrada)) {
                autenticado = true;
                break;
            } else {
                tentativas--;
                System.out.println("Senha incorreta! Tentativas: " + tentativas);
            }
        }

        if (!autenticado) {
            System.out.println("Acesso bloqueado!");
            return;
        }
    }
}