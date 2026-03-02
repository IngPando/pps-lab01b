package it.unibo.pps.e1;

public class BronzeBankAccount implements BankAccount {

    private BankAccount baseBankAccount;

    public BronzeBankAccount(BankAccount baseBankAccount) {
        this.baseBankAccount = baseBankAccount;
    }

    @Override
    public int getBalance() {
        return baseBankAccount.getBalance();
    }

    @Override
    public void deposit(int amount) {
        baseBankAccount.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        int fee = (amount < 100) ? 0 : 1;
        baseBankAccount.withdraw(amount + fee);
    }
}
