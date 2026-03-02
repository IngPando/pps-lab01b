package it.unibo.pps.e1;

public class GoldBankAccount implements BankAccount {

    private BankAccount baseBankAccount;


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
        int overDraftLimit = 500;
        if (this.getBalance() < amount - overDraftLimit ){
            throw new IllegalStateException();
        }
        baseBankAccount.withdraw(amount);
    }
}
