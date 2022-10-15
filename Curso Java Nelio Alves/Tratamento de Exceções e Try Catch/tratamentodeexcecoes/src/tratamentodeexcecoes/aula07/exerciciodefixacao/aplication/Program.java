package tratamentodeexcecoes.aula07.exerciciodefixacao.aplication;


import tratamentodeexcecoes.aula07.exerciciodefixacao.model.entities.Account;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number, opcao;
        String holder;
        Double initialDeposite;
        Account account = null;

        System.out.println("***** Bem vindo ao Banco ***** \n");

        do {
            System.out.println("1 - Cadastrar conta bancária");
            System.out.println("2 - Realizar saque\n");

            opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("Informe o número da conta bancária:");
                number = scanner.nextInt();

                System.out.println("Informe a agência:");
                holder = scanner.next();

                System.out.println("Informe o depósito inicial:");
                initialDeposite = scanner.nextDouble();

                account = new Account(number, holder, initialDeposite);
            } else if (opcao == 2) {
                System.out.println("Conta: " + account.getNumber());
                System.out.println("Limite de saque: " + account.getWithdrawLimit());
                System.out.println("Realizar saque");
            } else if (opcao == 0) {
                System.out.println("Obrigado por utilizar o sistema!");
            }


        } while (opcao != 0);
    }
}
