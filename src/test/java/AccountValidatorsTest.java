import org.junit.Assert;
import org.junit.Test;
import wawer.kamil.accountService.AccountValidators;
import wawer.kamil.accountService.AccountValidatorsImpl;
import wawer.kamil.model.Account;

import java.math.BigDecimal;

public class AccountValidatorsTest {

    private AccountValidators validators;

    public AccountValidatorsTest() {
        this.validators = new AccountValidatorsImpl();
    }

    // NULLS
    @Test
    public void shouldReturnFalseWhenAccountIbanIsNull() {
        Account account = new Account(null, "name1", "PLN", "12.13", "30-08-2030");
        boolean result = validators.isIbanHasCorrectFormat(account.getAccountIban());
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenAccountNameIsNull() {
        Account account = new Account("PL61109010140000071219812870", null, "PLN", "12.13", "30-08-2030");
        boolean result = validators.isNameNotNull(account.getName());
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenAccountCurrencyIsNull() {
        Account account = new Account("PL61109010140000071219812870", "name1", null, "12.13", "30-08-2030");
        boolean result = validators.isCurrencyEqualsPLN(account.getCurrency());
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenAccountBalanceIsNull() {
        Account account = new Account("PL61109010140000071219812870", "name1", "PLN", null, "30-08-2030");
        boolean result = validators.isBalanceLowerThanZero(account.getBalance());
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenAccountClosingDateIsNull() {
        Account account = new Account("PL61109010140000071219812870", "name1", "PLN", "12.13", null);
        boolean result = validators.isIbanHasCorrectFormat(account.getClosingDate());
        Assert.assertFalse(result);
    }

    //CURRENCY
    @Test
    public void shouldReturnTrueWhenCurrencyEqualsPLN() {
        Account account = new Account("PL61109010140000071219812870", "name1", "PLN", "12.13", "2020-12-12");
        boolean result = validators.isCurrencyEqualsPLN(account.getCurrency());
        Assert.assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenCurrencyEqualsPLNInLowerCase() {
        Account account = new Account("PL61109010140000071219812870", "name1", "pln", "12.13", "2020-12-12");
        boolean result = validators.isCurrencyEqualsPLN(account.getCurrency());
        Assert.assertTrue(result);
    }

    @Test
    public void shouldReturnFalseWhenCurrencyNotEqualsPLNForExampleUSD() {
        Account account = new Account("PL61109010140000071219812870", "name1", "USD", "12.13", "2020-12-12");
        boolean result = validators.isCurrencyEqualsPLN(account.getCurrency());
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenCurrencyIsEmpty() {
        Account account = new Account("PL61109010140000071219812870", "name1", "", "12.13", "2020-12-12");
        boolean result = validators.isCurrencyEqualsPLN(account.getCurrency());
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenCurrencyIsWroteWithSpaces() {
        Account account = new Account("PL61109010140000071219812870", "name1", "P L N ", "12.13", "2020-12-12");
        boolean result = validators.isCurrencyEqualsPLN(account.getCurrency());
        Assert.assertFalse(result);
    }

    //BALANCE

    @Test
    public void shouldReturnFalseWhenBalanceIsEmpty() {
        Account account = new Account("PL61109010140000071219812870", "name1", "PLN ", "", "2020-12-12");
        boolean result = validators.isBalanceLowerThanZero(account.getBalance());
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnTrueWhenBalanceGraterThanZero() {
        Account account = new Account("PL61109010140000071219812870", "name1", "PLN ", "12.13", "2020-12-12");
        boolean result = validators.isBalanceLowerThanZero(account.getBalance());
        Assert.assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenBalanceEqualsZero() {
        Account account = new Account("PL61109010140000071219812870", "name1", "PLN ", "0", "2020-12-12");
        boolean result = validators.isBalanceLowerThanZero(account.getBalance());
        Assert.assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenBalanceLowerThanZero() {
        Account account = new Account("PL61109010140000071219812870", "name1", "PLN ", "12.13", "2020-12-12");
        boolean result = validators.isBalanceLowerThanZero(account.getBalance());
        Assert.assertFalse(result);
    }

}
