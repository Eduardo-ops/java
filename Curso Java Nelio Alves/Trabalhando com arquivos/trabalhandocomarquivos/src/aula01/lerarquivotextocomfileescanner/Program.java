package aula01.lerarquivotextocomfileescanner;

/*
 * leitura básica de arquivo.
 * Lendo arquivo texto com a classe File e Scanner.
 * */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        File file = new File("C:\\temp\\in.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
