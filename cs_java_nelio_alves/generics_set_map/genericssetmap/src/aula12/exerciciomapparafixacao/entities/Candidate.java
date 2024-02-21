package aula12.exerciciomapparafixacao.entities;

public class Candidate {

    private String name;
    private int votings;

    public Candidate() {
    }

    public Candidate(String name, int votings) {
        this.name = name;
        this.votings = votings;
    }

    public Candidate parse(String line, String separator) {
        String[] parts = line.split(separator);

        if (parts.length != 2) {
            throw new IllegalArgumentException("Linha de candidato mal-formada: " + line);
        }

        return new Candidate(
                parts[0].trim(),
                Integer.parseInt(parts[1].trim())
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return votings;
    }

    public void setNumber(int number) {
        this.votings = number;
    }
}
