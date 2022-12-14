package tratamentodeexcecoes.aula07.exerciciodefixacao.model.entities;

import tratamentodeexcecoes.aula07.exerciciodefixacao.model.exceptions.DomainAccountException;

public class Account {

    /*
     * Número da conta bancária
     * */
    private int number;
    /*
     * Titular da conta
     * */
    private String holder;

    /*
     * Saldo total atual
     * */
    private Double balance;

    /*
     * Limite do saque
     * */
    private Double withdrawLimit;

    public Account(int number, String holder, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = 0.0;
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double depositAmount) {
        this.balance += depositAmount;
    }

    public void withdraw(Double withdrawAmount) throws DomainAccountException {
        validateWithdraw(withdrawAmount);
        this.balance -= withdrawAmount;
        System.out.println("Saldo atual: " + this.balance + "\n");
    }

    public void validateWithdraw(Double withdrawAmount) throws DomainAccountException {
        if (this.balance < withdrawAmount) {
            throw new DomainAccountException("Erro em saque: Não há saldo suficiente.");
        }
        if (withdrawAmount > getWithdrawLimit()) {
            throw new DomainAccountException("Erro em saque: O valor do saque é maior do que o valor permitido.");
        }
    }

    @Override
    public String toString() {
        return "Conta: " +
                number +
                "\nTitular: " +
                holder +
                "\nSaldo Atual: " +
                balance +
                "\nLimite de saque: " +
                withdrawLimit + "\n";
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }
}
