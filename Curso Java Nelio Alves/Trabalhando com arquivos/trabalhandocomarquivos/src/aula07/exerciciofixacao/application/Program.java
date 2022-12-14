package aula07.exerciciofixacao.application;

/*
 * Fazer um programa para ler o caminho de um arquivo .csv contendo os dados de itens vendidos.
 * Cada item possui um nome, preço unitário e quantidade, separados por vírgula. Você deve gerar
 * um novo arquivo chamado "summary.csv", localizado em uma subpasta chamada "out" a partir da pasta
 * original do arquivo de origem, contendo apenas o nome e o valor total para aquele item (preço unitário
 * multiplicado pela quantidade conforme exemplo.)
 *
 * */

import aula07.exerciciofixacao.entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String pathFile = null;
        String[] lines = null;
        String line = null;
        Product product = null;
        List<Product> products = new ArrayList<Product>();
        Boolean newSubDirectory = null;
        String newPath = null;
        File originPath = null;
        File newFileSummary = null;

        System.out.println("Enter the file path:");
        pathFile = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            line = br.readLine();

            while (line != null) {
                lines = line.split(",");

                products.add(new Product(lines[0], Double.parseDouble(lines[1]), Integer.parseInt(lines[2])));
                line = br.readLine();
            }

            originPath = new File(pathFile);
            newSubDirectory = new File(originPath.getParent() + "\\out").mkdir();

            newFileSummary = new File(originPath.getParent() + "\\out" + "\\summary.csv");
            newFileSummary.createNewFile();

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFileSummary))) {
                for (Product pd : products) {
                    bw.write(pd.getName() + "," + pd.getQuantity() * pd.getPrice());
                    bw.newLine();
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
