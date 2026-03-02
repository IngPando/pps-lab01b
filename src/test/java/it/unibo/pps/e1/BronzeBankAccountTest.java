package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest {

    private BronzeBankAccount account;

    @BeforeEach
    void init(){
        this.account = new BronzeBankAccount(new CoreBankAccount());
    }

    @Test
    public void testInitiallyEmpty() {
        int initialBalance = 0;
        assertEquals(initialBalance, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        int deposit = 1000;
        this.account.deposit(deposit);
        assertEquals(deposit, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        int deposit = 1000;
        int withdraw = 50;
        this.account.deposit(deposit);
        this.account.withdraw(withdraw);
        assertEquals(deposit - withdraw, this.account.getBalance());
    }

    // if withdraw amount < 100 the fee is equal to 0 otherwise fee is 1
    @Test
    public void testCanWithdrawWithoutFee(){
        int deposit = 1000;
        int withdraw = 90;
        this.account.deposit(deposit);
        this.account.withdraw(withdraw);
        assertEquals(deposit - withdraw, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawWithFee(){
        int deposit = 1000;
        int withdraw = 250;
        int fee = 1;
        this.account.deposit(deposit);
        this.account.withdraw(withdraw);
        assertEquals(deposit - withdraw - fee, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        int deposit = 1000;
        int withdraw = 1600;
        this.account.deposit(deposit);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdraw));
    }

}
