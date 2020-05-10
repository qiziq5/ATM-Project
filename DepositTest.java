package demo.pkg.test;

import demo.pkg.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class DepositTest {
    Deposit deposit;
    Screen screen;
    BankDatabase bankDatabase;
    Keypad keypad;
    DepositSlot depositSlot;

    //Integration ID = 2 action = Integrate with BankDatabase, Screen, DepositSlot, Deposit

    @Before

    public void setUp() {
        screen = new Screen();
        bankDatabase = new BankDatabase();
        keypad = Mockito.mock(Keypad.class);
        depositSlot = new DepositSlot();
        deposit = new Deposit(12345, screen,
                bankDatabase, keypad,
                depositSlot);
    }

    @Test
    public void shouldReturnCanceled() {

        Mockito.when(keypad.getInput()).thenReturn(0);
        double v = deposit.promptForDepositAmount();

        Assert.assertEquals((double) 0, v, 0); // Check deposit return canceled
    }

    @Test
    public void shouldReturnValue() {

        Mockito.when(keypad.getInput()).thenReturn(100);
        double v = deposit.promptForDepositAmount();

        Assert.assertEquals((double) 1, v, 0); // Check deposit return value
    }
}
