package aula12.exerciciomapparafixacao.appplication;

import aula12.exerciciomapparafixacao.entities.Candidate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Na contagem de votos de uma eleição, são gerados vários registos de votação contendo o nome do candidato
 * e a quantidade de votos (formato .csv) que ele obteve em uma urna de votação. Você deve fazer um programa
 * para ler os registros de votação a partir de um arquivo, e daí gerar um relatório consolidado com os totais
 * de cada candidato.
 * */

public class Program {

    public static void main(String[] args) throws IOException {

        Map<String, Integer> votingResultMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        BufferedReader fileCsv = null;
        String line = "";
        String caminhoArquivo = "";

        System.out.println("Informe o caminho do arquivo csv:");
        caminhoArquivo = scanner.nextLine();

        fileCsv = new BufferedReader(new FileReader(caminhoArquivo));
        System.out.println("");

        while ((line = fileCsv.readLine()) != null) {
            Candidate candidate = new Candidate().parse(line, ",");

            if (votingResultMap.get(candidate.getName()) == null) {
                votingResultMap.put(candidate.getName(), candidate.getNumber());
            } else {
                votingResultMap.put(candidate.getName(), candidate.getNumber() + votingResultMap.get(candidate.getName()));
            }
        }

        System.out.println("Total de candidatos: " + votingResultMap.size() + "\n");

        System.out.println("Rank dos candidatos vencedores:");
        for (String key : votingResultMap.keySet()) {
            System.out.println(key + ": " + votingResultMap.get(key));
        }
        scanner.close();
    }
}

/* RESOLUÇÃO DO INSTRUTOR SEM A CLASSE CANDIDATE
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> votes = new LinkedHashMap<>();

        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {

                String[] fields = line.split(",");
                String name = fields[0];
                int count = Integer.parseInt(fields[1]);

                if (votes.containsKey(name)) {
                    int votesSoFar = votes.get(name);
                    votes.put(name, count + votesSoFar);
                } else {
                    votes.put(name, count);
                }

                line = br.readLine();
            }

            for (String key : votes.keySet()) {
                System.out.println(key + ": " + votes.get(key));
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
*/