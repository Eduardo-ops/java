package aula04.filewriterbufferedwriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Gravando em um arquivo os valores strings de um array de string.
 * */

public class Program {

    public static void main(String[] args) {

        String[] lines = new String[]{"Teste de gravação da linha 1", "Teste de gravação da linha 2", "Teste de gravação da linha 3"};
        String path = "c:\\temp\\out.txt";

        /*
         * Se colocarmos o true por parâmetro em FileWriter, indica que se for executado mais de uma vez
         * o mesmo programa, será gravado os novos valores na sequência dos valores já existentes no arquivo,
         * caso contrário, se não tiver o true por parâmetro, será recriado um novo arquivo do zero.
         * */
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            for (String line : lines) {
                bw.write(line);// Captura o valor no índice do for e grava no arquivo.
                bw.newLine();// Faz a quebra de linha dentro do arquivo para salvar o novo valor.
            }
        }
        catch (IOException e) {
            System.out.println("Error :" + e.getMessage());
            e.printStackTrace();
        }
    }
}
