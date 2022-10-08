/*
 * Exercício proposto para um financiamento.
 * Regras de negócio:
 * - O valor de entrada deve ser pelo menos 20% do valor total do financiamento.
 * - A quantidade de parcelas deve ser no mínimo 216
 * */

public class ProgramaPrincipal {

    public static void main(String[] args) {

        double valorTotal = 200000.0;
        double entrada = 15000.0;
        int parcelas = 60;

        try {
            Financiamento financiamento = new Financiamento(valorTotal, entrada, parcelas);
            System.out.println("Valor de cada parcela: " + financiamento.prestacao());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
