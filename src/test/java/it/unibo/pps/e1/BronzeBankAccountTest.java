package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends CoreBankAccountTest{


    @Override
    protected BankAccount getAccount() {
        return new BronzeBankAccount(new CoreBankAccount());
    }

    // if withdraw amount < 100 the fee is equal to 0 otherwise fee is 1
    @Test
    public void testCanWithdrawWithoutFee(){
        int deposit = 1000;
        int withdraw = 90;
        this.account.deposit(deposit);
        this.account.withdraw(withdraw);
        assertEquals(deposit - withdraw - account.getFee(withdraw), this.account.getBalance());
    }

    @Test
    public void testCanWithdrawWithFee(){
        int deposit = 1000;
        int withdraw = 250;
        this.account.deposit(deposit);
        this.account.withdraw(withdraw);
        assertEquals(deposit - withdraw - account.getFee(withdraw), this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        int deposit = 1000;
        int withdraw = 1600;
        this.account.deposit(deposit);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdraw));
    }

}
