package it.unibo.pps.e1;

public abstract interface BankAccount {
    int balance = 0;
    int NO_FEE = 0;
    int BASE_FEE = 1;

    public int getBalance();

    public void deposit(int amount);

    public void withdraw(int amount);

    public int getFee(int amount);
}
