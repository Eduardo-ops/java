package tratamentodeexcecoes.aula02.printstacktrace;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        method1();
        System.out.println("End of program");

    }

    public static void method1() {

        System.out.println("**** METHOD 1 START ****");

        method2();

        System.out.println("**** METHOD 1 END ****");

    }

    public static void method2() {

        System.out.println("**** METHOD 2 START ****");

        Scanner scanner = new Scanner(System.in);

        try {
            String[] vect = scanner.nextLine().split(" ");
            int position = scanner.nextInt();

            System.out.println(vect[position]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid position!\n");

            /*
             * PrintStackTrace mostra a sequência da pilha de chamadas dos métodos.
             * Geralmente é apresentado quando não tem nenhum tratamento de exceções no programa,
             * no qual, apresenta no terminal a exceção e o caminho(pilha) dos métodos de onde
             * percorreu e originou.
             * */
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.out.println("Invalid type variable informed\n");
            e.printStackTrace();
        }

        System.out.println("Programa continua em execução.");

        scanner.close();

        System.out.println("**** METHOD 2 END ****");
    }
}
