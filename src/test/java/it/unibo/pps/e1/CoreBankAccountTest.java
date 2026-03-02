package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoreBankAccountTest {

    private CoreBankAccount account;

    @BeforeEach
    void init(){
        this.account = new CoreBankAccount();
    }

    @Test
    public void testInitiallyEmpty() {
        int initialBalance = 0;
        assertEquals(initialBalance, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        int depositAmount = 1000;
        this.account.deposit(depositAmount);
        assertEquals(depositAmount, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        int deposit = 1000;
        int withdraw  = 50;
        this.account.deposit(deposit);
        this.account.withdraw(withdraw);
        assertEquals(deposit - withdraw, this.account.getBalance());
    }


}
