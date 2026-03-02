package it.unibo.pps.e1;

public class SilverBankAccount implements BankAccount{

    private final BankAccount baseBankAccount;

    public SilverBankAccount(BankAccount baseBankAccount){
        this.baseBankAccount = baseBankAccount;
    }

    public int getBalance() {
        return baseBankAccount.getBalance();
    }

    public void deposit(int amount) {
        baseBankAccount.deposit(amount);
    }

    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        baseBankAccount.withdraw(amount + 1);
    }
}
