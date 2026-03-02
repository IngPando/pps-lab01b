package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends CoreBankAccountTest{


    @Override
    protected BankAccount getAccount() {
        return new SilverBankAccount(new CoreBankAccount());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        int deposit = 1000;
        int withdraw = 1200;
        this.account.deposit(deposit);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdraw));
    }

}
