package aula05.manipulandopastascomfile;

import java.io.File;
import java.util.Scanner;

/*
 * Exercícios que lê diretórios e arquivos de um determinado caminho indicado e também
 * nos possibilita criar novos diretórios no caminho(diretório) indicado ao programa.
 * */

public class Program {

    public static void main(String[] args) {

        String strPath = "";
        File path = null;
        File[] folders = null;
        File[] files = null;
        Boolean success = false;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a folder path:");
        strPath = sc.nextLine();

        path = new File(strPath);

        // Listando apenas os diretórios do caminho indicado.
        folders = path.listFiles(File::isDirectory);

        // Imprimindo no console todos os caminhos encontrado no path.
        System.out.println("FOLDERS:");
        for (File folder : folders) {
            System.out.println(folder);
        }

        // Listando apenas os arrquivos do caminho indicado.
        files = path.listFiles(File::isFile);

        // Imprimindo no console todos os arquivos encontrado no path.
        System.out.println("FILES:");
        for (File file : files) {
            System.out.println(file);
        }

        // Vai criar um novo diretório dentro do diretório do caminho recebido.
        success = new File(strPath + "\\subdiretório2").mkdir();
        System.out.println("Directory created successfully: " + success);

        sc.close();
    }
}
