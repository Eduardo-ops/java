package aula12.exerciciomapparafixacao.appplication;

import aula12.exerciciomapparafixacao.entities.Candidate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws IOException {

        Map<Candidate, Integer> votingResult = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        BufferedReader fileCsv = null;
        String line = "";
        String caminhoArquivo = "";

        System.out.println("Informe o caminho do arquivo csv:");
        caminhoArquivo = scanner.nextLine();

        fileCsv = new BufferedReader(new FileReader(caminhoArquivo));
        System.out.println("");

        while ((line = fileCsv.readLine()) != null) {
            Candidate candidate = new Candidate().parse(line, ";");
            votingResult.put(candidate, candidate.getNumber());
        }

        System.out.println("Total de candidatos: " + votingResult.size() + "\n");

        System.out.println("Rank dos candidatos vencedores:");
        for (Candidate key : votingResult.keySet()) {
            System.out.println(key.getName() + ":" + votingResult.get(key));
        }
    }
}
