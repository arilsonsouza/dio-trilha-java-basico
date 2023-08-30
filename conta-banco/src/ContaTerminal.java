import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, informe seu nome!");
        String nomeCliente = scanner.nextLine();

        System.out.println("Por favor, digite o saldo inicial!");
        double saldoConta = scanner.nextDouble();

        scanner.nextLine();
        System.out.println("Por favor, digite o número da Agência!");
        String agenciaConta = scanner.nextLine();

        System.out.println("Por favor, digite o número da Conta!");
        int numeroConta = scanner.nextInt();

        scanner.close();

        String mensagem = String.format(
                "Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %s e seu saldo %s já está disponível para saque",
                nomeCliente, agenciaConta, numeroConta, saldoConta);
        System.out.println(mensagem);
    }
}
