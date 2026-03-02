package it.unibo.pps.e1;

public class GoldBankAccount implements BankAccount {

    private final BankAccount baseBankAccount;

    public GoldBankAccount(BankAccount baseBankAccount) {
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
        int creditLimit = -500;
        if (this.getBalance() - amount > creditLimit ){
            int fee = getFee(amount);
            baseBankAccount.withdraw(amount + fee);
        } else {
            throw new IllegalStateException();
        }

    }

    @Override
    public int getFee(int amount) {
        return NO_FEE;
    }
}
