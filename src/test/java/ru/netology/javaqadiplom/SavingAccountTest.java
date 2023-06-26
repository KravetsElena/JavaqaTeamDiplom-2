package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
//import org.junitpackage ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        assertEquals(2_000 + 3_000, account.getBalance());
    }
        private SavingAccount account;
    @Test
    public void testNegativeRateThrowsException() {
        int initialBalance = 1000;
        int minBalance = 500;
        int maxBalance = 5000;
        int rate = -5;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(initialBalance, minBalance, maxBalance, rate);
        });
    }

    @Test
    public void testInvalidMinMaxBalanceThrowsException() {
        int initialBalance = 1000;
        int minBalance = 5000;
        int maxBalance = 500;
        int rate = 5;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(initialBalance, minBalance, maxBalance, rate);
        });
    }
     @BeforeEach
     @Test
    void setUp() {
        account = new SavingAccount(1000, 0, 5000, 10);
    }

        @Test
        void testPaySufficientBalance() {
            assertTrue(account.pay(500));
            assertEquals(500, account.getBalance());
        }

        @Test
        void testPayInsufficientBalance() {
            assertFalse(account.pay(1500));
            assertEquals(1000, account.getBalance());
        }

        @Test
        void testPayZeroAmount() {
            assertFalse(account.pay(0));
            assertEquals(1000, account.getBalance());
        }

        @Test
        void testPayNegativeAmount() {
            assertFalse(account.pay(-500));
            assertEquals(1000, account.getBalance());
        }

        @Test
        void testAddWithinMaxBalance() {
            assertTrue(account.add(500));
            assertEquals(1500, account.getBalance());
        }

        @Test
        void testAddExceedMaxBalance() {
            assertFalse(account.add(4000));
            assertEquals(1000, account.getBalance());
        }

        @Test
        void testAddZeroAmount() {
            assertFalse(account.add(0));
            assertEquals(1000, account.getBalance());
        }

        @Test
        void testAddNegativeAmount() {
            assertFalse(account.add(-500));
            assertEquals(1000, account.getBalance());
        }

        @Test
        void testYearChange() {
            assertEquals(100, account.yearChange());
            assertEquals(1100, account.getBalance());
        }
}