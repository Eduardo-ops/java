package tratamentodeexcecoes.aula01.estrututuratrycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            String[] vect = scanner.nextLine().split(" ");
            int position = scanner.nextInt();

            System.out.println(vect[position]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid position!\n");
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid type variable informed\n");
        }

        System.out.println("Programa continua em execução.");

        scanner.close();
    }
}
