package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest {

    private GoldBankAccount account;

    @BeforeEach
    void init(){
        this.account = new GoldBankAccount(new CoreBankAccount());
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
        int withdraw = 200;
        this.account.deposit(deposit);
        this.account.withdraw(withdraw);
        assertEquals(deposit - withdraw, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawWithOverDraft(){
        int deposit = 1000;
        int withdraw = 1200;
        this.account.deposit(deposit);
        this.account.withdraw(withdraw);
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
