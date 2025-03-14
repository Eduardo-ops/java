public class Financiamento {

    public Double valorTotal;
    public Double entrada;
    public Integer parcelas;

    public Financiamento(Double valorTotal, Double entrada, Integer parcelas) {

        if (entrada < valorTotal * 0.2) {
            throw new RuntimeException("O valor de entrada deve ser pelo menos 20% do valor total.");
        } else if (parcelas < 216) {
            throw new RuntimeException("O número mínimo de parcelas deve ser 216.");
        }

        this.valorTotal = valorTotal;
        this.entrada = entrada;
        this.parcelas = parcelas;
    }

    public double prestacao() {
        return (valorTotal - entrada) / parcelas;
    }
}
