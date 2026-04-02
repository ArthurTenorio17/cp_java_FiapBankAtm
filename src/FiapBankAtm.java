import java.util.Scanner;

public class FiapBankAtm {

    // Verifica se há dígitos repetidos
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

        double saldo = 0.0;
        String senhaCadastrada;
        String senhaDigitada;
        int opcao;

        System.out.println("=====================");
        System.out.println("==== Bem-Vindo! =====");
        System.out.println("=== FIAP BANK ATM ===");
        System.out.println("=====================");

        // Cadastro de senha
        boolean senhaValida;

        do {
            System.out.print("Cadastre uma senha (6 dígitos, sem repetição): ");
            senhaCadastrada = scanner.nextLine();

            senhaValida = senhaCadastrada.matches("\\d{6}") && !temRepetido(senhaCadastrada);

            if (!senhaValida) {
                System.out.println("Senha inválida!");
            }

        } while (!senhaValida);

        // Login
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

        // Menu
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("Saldo atual: R$ " + saldo);
                    break;

                case 2:
                    System.out.print("Digite o valor para depósito: ");
                    double deposito = scanner.nextDouble();

                    if (deposito > 0) {
                        saldo += deposito;
                        System.out.println("Depósito realizado!");
                    } else {
                        System.out.println("Valor inválido!");
                    }
                    break;

                case 3:
                    System.out.print("Digite o valor para saque: ");
                    double saque = scanner.nextDouble();

                    if (saque <= 0) {
                        System.out.println("Valor inválido!");
                    } else if (saque > saldo) {
                        System.out.println("Saldo insuficiente!");
                    } else {
                        saldo -= saque;
                        System.out.println("Saque realizado!");
                    }
                    break;

                case 4:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 4);

        scanner.close();
    }
}