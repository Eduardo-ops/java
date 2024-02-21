package aula02.filereaderebufferedreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Exemplo de forma mais manual.
 * Apenas uma demonstração de como abrir e fechar os arquivos de forma manual.
 * Classes utilizadas como FileRead e BufferedReader
 * */

public class Program {

    public static void main(String[] args) {

        String path = "C:\\temp\\in.txt";
        FileReader fileReader = null;
        BufferedReader bufferedRead = null;
        String line = null;

        try {
            fileReader = new FileReader(path);
            bufferedRead = new BufferedReader(fileReader);

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
        finally {
            try {
                if (bufferedRead != null) {
                    bufferedRead.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
