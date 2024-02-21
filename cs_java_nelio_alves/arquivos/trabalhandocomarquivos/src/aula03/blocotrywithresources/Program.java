package aula03.blocotrywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * O mesmo exercício da aula 2, porém adaptado para uma melhor sintaxe.
 * */

public class Program {

    public static void main(String[] args) {

        String path = "C:\\temp\\in.txt";
        String line = null;

        try (BufferedReader bufferedRead = new BufferedReader(new FileReader(path))) {

            // Lendo apenas uma linha do arquivo.
            System.out.println(line = bufferedRead.readLine());

            // Forma básica para fazer leitura com bufferedReader
            while (line != null) {
                System.out.println(line);
                line = bufferedRead.readLine();
            }
        }
        catch (IOException e) {
            System.out.println("Error :" + e.getMessage());
        }
    }
}
