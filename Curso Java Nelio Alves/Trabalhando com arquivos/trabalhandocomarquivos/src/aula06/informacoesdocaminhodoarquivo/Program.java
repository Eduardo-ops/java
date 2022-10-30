package aula06.informacoesdocaminhodoarquivo;

import java.io.File;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        String strPath = "";
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a file path: ");
        strPath = sc.nextLine();

        File path = new File(strPath);

        //Pegando o nome do arquivo.
        System.out.println("File name: " + path.getName());

        //Pegando o caminho do arquivo sem o nome do arquivo
        System.out.println("File path: " + path.getParent());

        //Pegando o caminho completo do arquivo
        System.out.println("Complet file path: " + path.getPath());

        sc.close();
    }
}
