package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest extends CoreBankAccountTest{
    
    @Override
    protected BankAccount getAccount() {
        return new GoldBankAccount(new CoreBankAccount());
    }

    @Test
    public void testCanWithdrawWithOverDraft(){
        int deposit = 1000;
        int withdraw = 1200;
        account.deposit(deposit);
        account.withdraw(withdraw);
        assertEquals(deposit - withdraw, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanOverDraft(){
        int deposit = 1000;
        int withdraw = 1600;
        this.account.deposit(deposit);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdraw));
    }

}
