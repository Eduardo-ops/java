package tratamentodeexcecoes.aula03.blocofinaly;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        File file = new File("C:\\Teste para programa java\\teste.txt");
        Scanner scanner = null;

        // Trecho do código que abre o arquivo e mostra na tela.
        try {
            // Scanner recebe arquivo.
            scanner = new Scanner(file);
            // Percode todas as linhas do arquivo, utilizando o hasNextLine().
            while (scanner.hasNextLine()) {
                // Imprimi linha por linha do arquivo.
                System.out.println(scanner.nextLine());
            }
        }
        // Trata a exceção de arquivo não encontrado.
        catch (FileNotFoundException e) {
            System.out.println("Error opening file: " + e.getMessage());
        }
        // Independente do problema que pode ocorrer, precisa-se fechar o arquivo.
        finally {
            if (scanner != null) {
                // Fecha o scanner que contém o arquivo.
                scanner.close();
            }
            System.out.println("Finally block executed");
        }
    }
}
