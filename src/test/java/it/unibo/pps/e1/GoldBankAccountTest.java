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
    public void testCanWithdrawToNegativeBalance(){
        int deposit = 1000;
        int withdraw = 1200;
        account.deposit(deposit);
        account.withdraw(withdraw);
        assertEquals(deposit - withdraw, this.account.getBalance());
    }

    // the credit limit is set to -500$ by domain description
    @Test
    public void testCannotWithdrawMoreThanCreditLimit(){
        int deposit = 1000;
        int withdraw = 1600;
        this.account.deposit(deposit);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdraw));
    }

}
