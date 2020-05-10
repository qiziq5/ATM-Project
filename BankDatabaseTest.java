package demo.pkg.test;

import demo.pkg.Account;
import demo.pkg.BankDatabase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankDatabaseTest {
    BankDatabase bankDatabase;

    // Integration ID = 1; action = Integrate with BankDatabase, Account
    @Before
    public void setUp() {

        bankDatabase = new BankDatabase();
    }


    @Test
    public void getAccount() {
        Account account = bankDatabase.getAccount(12345);

        Assert.assertEquals(1000, account.getAvailableBalance(), 0);  //Compare Available Balance
        Assert.assertEquals(1200, account.getTotalBalance(), 0);      //Compare Total Balance
        Assert.assertEquals(12345, account.getAccountNumber());             //Compare Account number
    }


    @Test
    public void shouldNotAuthenticate() {
        boolean auth = bankDatabase.authenticateUser(12345, 12345); //Check authentication for fail

        Assert.assertFalse(auth);
    }

    @Test
    public void shouldAuthenticate() {
        boolean auth = bankDatabase.authenticateUser(12345, 54321); //Check authentication for pass

        Assert.assertTrue(auth);
    }

    @Test
    public void getAvailableBalance(){
        double availableBalance = bankDatabase.getAvailableBalance(12345); //Test available balance on account;

        Assert.assertEquals(1000, availableBalance, 0);
    }

    @Test
    public void getTotalBalance(){
        double availableBalance = bankDatabase.getTotalBalance(12345);     //Test Total balance on account;

        Assert.assertEquals(1200, availableBalance, 0);
    }

    @Test
    public void credit(){
        bankDatabase.credit(12345, 100);

        Assert.assertEquals(1200+100, bankDatabase.getTotalBalance(12345), 0); //Check credit account
    }

    @Test
    public void debit(){
        bankDatabase.debit(12345, 100);

        Assert.assertEquals(1000-100, bankDatabase.getAvailableBalance(12345), 0); //Check debit account
    }
}
