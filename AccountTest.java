package demo.pkg.test;
import demo.pkg.Account;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {

    Account account;

    //Integration ID = 3 action = Integrate Account
    @Before
    public void setUp(){

        account = new Account(1, 2, 100, 120); //Create new account
    }

    @Test
    public void validatePinOk(){
        boolean pin = account.validatePIN(2);   // Check pin is true

        Assert.assertTrue(pin);
    }
    @Test
    public void validatePinNotOk(){
        boolean pin = account.validatePIN(1);   // Check pin is false

        Assert.assertFalse(pin);
    }

    @Test
    public void shouldReturnAvailableBalance(){
        double availableBalance = account.getAvailableBalance();

        Assert.assertEquals(100, availableBalance, 0); // Check available balance
    }

    @Test
    public void shouldReturnTotalBalance(){
        double availableBalance = account.getTotalBalance();

        Assert.assertEquals(120, availableBalance, 0); // Check total balance
    }

    @Test
    public void shouldCreditAccount(){
        double totalBalance = account.getTotalBalance();
        account.credit(10.0);
        double newTotalBalance = account.getTotalBalance();

        Assert.assertEquals(totalBalance + 10, newTotalBalance, 0); // Check credit balance
    }

    @Test
    public void shouldDebitAccount(){
        double availableBalance = account.getAvailableBalance();
        account.debit(10.0);
        double newAvailableBalance = account.getAvailableBalance();

        Assert.assertEquals(availableBalance -10, newAvailableBalance, 0); // Check debit balance
    }

}
