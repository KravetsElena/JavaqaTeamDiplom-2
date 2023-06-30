package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void positiveInitialBalance() {       /////// положит старт баланс

        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                1);
        Assertions.assertEquals(1_000, account.getBalance());

    }

    @Test
    public void negativeInitialBalance() {                   //////// отриц старт баланс   ------------!!!!!!!!!!

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -1_000,
                    5_000,
                    1);
        });

    }

    @Test
    public void nullInitialBalance() {                 ///Нулевой старт баланс

        CreditAccount account = new CreditAccount(
                0,
                5_000,
                1);
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void positiveCreditLimit() {       /////// положит лимит

        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                1);
        Assertions.assertEquals(5_000, account.getCreditLimit());
    }

    @Test
    public void negativeCreditLimit() {       /////// отриц  лимит     ---------------!!!!!!!!!!

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    1_000,
                    -5_000,
                    1);
        });

    }

    @Test
    public void nullCreditLimit() {       /////// нулевой лимит

        CreditAccount account = new CreditAccount(
                1_000,
                0,
                1);
        Assertions.assertEquals(0, account.getCreditLimit());
    }

    @Test
    public void positiveRate() {       /////// положит ставка

        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                1);
        Assertions.assertEquals(1, account.getRate());
    }

    @Test
    public void negativeRate() {       /////// отриц ставка

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    1_000,
                    5_000,
                    -5);
        });
    }

    @Test
    public void nullRate() {       /////// нулевая ставка      ----------!!!!!!!!!!

        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                0);
        Assertions.assertEquals(0, account.getRate());
    }

    @Test
    public void shouldPayAnderCreditLimit() {         ////Покупка < лимита

        CreditAccount account = new CreditAccount(1_000, 5_000, 1);
        boolean expected = true;
        boolean actual = account.pay(4_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayCreditLimit() {                  ////Покупка  = лимиту        -------------!!!!!!!

        CreditAccount account = new CreditAccount(1_000, 5_000, 1);
        boolean expected = true;
        boolean actual = account.pay(6_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayOverCreditLimit() {           //// Покупка > лимита

        CreditAccount account = new CreditAccount(1_000, 5_000, 1);
        boolean expected = false;
        boolean actual = account.pay(7_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayNull() {             /// Покупка = 0

        CreditAccount account = new CreditAccount(1_000, 5_000, 1);
        boolean expected = false;
        boolean actual = account.pay(0);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayBelowNull() {          //// Покупка < 0

        CreditAccount account = new CreditAccount(1_000, 5_000, 1);
        boolean expected = false;
        boolean actual = account.pay(-1_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void AddBalanceToPositive() {        //// пополнение на полож сумму

        CreditAccount account = new CreditAccount(1_000, 5_000, 1);
        boolean expected = true;
        boolean actual = account.add(1_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void AddBalanceToNegative() {        //// пополнение на отриц сумму

        CreditAccount account = new CreditAccount(1_000, 5_000, 1);
        boolean expected = false;
        boolean actual = account.add(-1_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void AddBalanceToNull() {        //// пополнение на 0

        CreditAccount account = new CreditAccount(1_000, 5_000, 1);
        boolean expected = false;
        boolean actual = account.add(0);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddToPositiveBalance() {

        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldYearChangeIfBalanceNegative() {  ///////% при отриц  балансе

        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );
        account.pay(400);
        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test
    public void shouldYearChangeIfBalancePositive() {  ///////% при положит страт балансе  ----------!!!!!!!!!

        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldYearChangeIfBalanceNull() {  ///////% при 0 страт балансе

        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        Assertions.assertEquals(0, account.yearChange());
    }
}
