package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class CoreBankAccountTest {

    protected BankAccount account;

    protected abstract BankAccount getAccount();

    @BeforeEach
    void init(){
        this.account = getAccount();
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
        assertEquals(deposit - withdraw - account.getFee(withdraw), this.account.getBalance());
    }




}
