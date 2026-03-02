package it.unibo.pps.e1;

public class BronzeBankAccount implements BankAccount {

    private final BankAccount baseBankAccount;

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
        int fee = getFee(amount);
        baseBankAccount.withdraw(amount + fee);
    }

    @Override
    public int getFee(int amount) {
        int withdrawLimitWithNoFee = 100;
        return  (amount < withdrawLimitWithNoFee) ? NO_FEE : BASE_FEE;
    }

}
