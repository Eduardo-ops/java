package tratamentodeexcecoes.aula07.exerciciodefixacao.aplication;

/*
 * Fazer um programa para ler os dados de uma conta bancária e depois realizar um saque nesta conta, mostrando
 * o novo saldo. Um saque não pode ocorrer ou se não houver saldo na conta, ou se o valor do saque for superior ao
 * limite de saque da conta. Implemente a conta bancária conforme o projeto citado.
 * */

import tratamentodeexcecoes.aula07.exerciciodefixacao.model.entities.Account;
import tratamentodeexcecoes.aula07.exerciciodefixacao.model.exceptions.DomainAccountException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number, opcao;
        String holder;
        Double depositAmount, withdrawAmount;
        Account account = null;

        try {
            System.out.println("***** Bem vindo ao Banco X ***** \n");

            do {
                System.out.println("1 - Cadastrar conta bancária");
                System.out.println("2 - Realizar depósito");
                System.out.println("3 - Realizar saque");
                System.out.println("4 - Verificar conta");
                System.out.println("0 - Sair\n");

                opcao = scanner.nextInt();

                if (opcao == 1) {
                    System.out.println("Informe o número da conta bancária:");
                    number = scanner.nextInt();

                    System.out.println("Informe a agência:");
                    holder = scanner.next();

                    account = new Account(number, holder);
                }
                else if (opcao == 2) {
                    System.out.println("Informe o valor do depósito:");
                    account.deposit(depositAmount = scanner.nextDouble());
                }
                else if (opcao == 3) {
                    System.out.println("Informe o valor do saque:");
                    account.withdraw(withdrawAmount = scanner.nextDouble());
                }
                else if (opcao == 4) {
                    System.out.println(account.toString());
                }
                else if (opcao == 0) {
                    System.out.println("Agradecemos a preferência em nossos serviços!");
                }
            } while (opcao != 0);
        }
        catch (DomainAccountException e) {
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e) {
            System.out.println("O valor informado não corresponde ao tipo esperado.");
        }
        catch (NullPointerException e) {
            System.out.println("Não há nenhum cadastro realizado.");
        }
        catch (RuntimeException e) {
            System.out.println("Erro inesperado.\n");
            System.out.println(e.getMessage());
        }
    }
}
