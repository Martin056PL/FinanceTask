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

    @Test
    public void shouldReturnFalseWhenAccountClosingDateIsNull() {
        Account account = new Account("PL61109010140000071219812870", "name1", "PLN", "12.13", null);
        boolean result = validators.isIbanHasCorrectFormat(account.getClosingDate());
        Assert.assertFalse(result);
    }

        //CURRENCY
        @Test
        public void shouldReturnFalseWhenAccountCurrencyIsNull() {
            Account account = new Account("PL61109010140000071219812870", "name1", null, "12.13", "30-08-2030");
            boolean result = validators.isCurrencyEqualsPLN(account.getCurrency());
            Assert.assertFalse(result);
        }

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
    public void shouldReturnFalseWhenAccountBalanceIsNull() {
        Account account = new Account("PL61109010140000071219812870", "name1", "PLN", null, "30-08-2030");
        boolean result = validators.isBalanceLowerThanZero(account.getBalance());
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenBalanceIsEmpty() {
        Account account = new Account("PL61109010140000071219812870", "name1", "PLN", "", "2020-12-12");
        boolean result = validators.isBalanceLowerThanZero(account.getBalance());
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnTrueWhenBalanceGraterThanZero() {
        Account account = new Account("PL61109010140000071219812870", "name1", "PLN", "12.13", "2020-12-12");
        boolean result = validators.isBalanceLowerThanZero(account.getBalance());
        Assert.assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenBalanceEqualsZero() {
        Account account = new Account("PL61109010140000071219812870", "name1", "PLN", "0", "2020-12-12");
        boolean result = validators.isBalanceLowerThanZero(account.getBalance());
        Assert.assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenBalanceLowerThanZero() {
        Account account = new Account("PL61109010140000071219812870", "name1", "PLN", "-12.13", "2020-12-12");
        boolean result = validators.isBalanceLowerThanZero(account.getBalance());
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenBalanceInNotNumerical() {
        Account account = new Account("PL61109010140000071219812870", "name1", "PLN", "notNumeric.forSure", "2020-12-12");
        boolean result = validators.isBalanceLowerThanZero(account.getBalance());
        Assert.assertFalse(result);
    }

        //ACCOUNT NAME
        @Test
        public void shouldReturnFalseWhenAccountNameIsNull() {
            Account account = new Account("PL61109010140000071219812870", null, "PLN", "12.13", "30-08-2030");
            boolean result = validators.isNameNotNull(account.getName());
            Assert.assertFalse(result);
        }

        @Test
        public void shouldReturnFalseWhenAccountNameIsEmpty() {
            Account account = new Account("PL61109010140000071219812870", "", "PLN", "12.13", "30-08-2030");
            boolean result = validators.isNameNotNull(account.getName());
            Assert.assertFalse(result);
        }

        @Test
        public void shouldReturnTrueWhenAccountNameHasAnyTitle() {
            Account account = new Account("PL61109010140000071219812870", "anyName123!", "PLN", "12.13", "30-08-2030");
            boolean result = validators.isNameNotNull(account.getName());
            Assert.assertTrue(result);
    }

    // IBAN NUMBER
    @Test
    public void shouldReturnFalseWhenAccountIbanIsNull() {
        Account account = new Account(null, "name1", "PLN", "12.13", "30-08-2030");
        boolean result = validators.isIbanHasCorrectFormat(account.getAccountIban());
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenAccountIbanIsEmpty() {
        Account account = new Account("", "name1", "PLN", "12.13", "30-08-2030");
        boolean result = validators.isIbanHasCorrectFormat(account.getAccountIban());
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnTrueWhenAccountIbanIsCorrect() {
        Account account = new Account("PL61109010140000071219812870", "name1", "PLN", "12.13", "30-08-2030");
        boolean result = validators.isIbanHasCorrectFormat(account.getAccountIban());
        Assert.assertTrue(result);
    }

    @Test
    public void shouldReturnFalseWhenAccountIbanHasLittleLettersInPrefix() {
        Account account = new Account("pl61109010140000071219812870", "name1", "PLN", "12.13", "30-08-2030");
        boolean result = validators.isIbanHasCorrectFormat(account.getAccountIban());
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenAccountIbanHasMoreThan28Signs() {
        Account account = new Account("PL611090101400000712198128701231231231233123", "name1", "PLN", "12.13", "30-08-2030");
        boolean result = validators.isIbanHasCorrectFormat(account.getAccountIban());
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenAccountIbanHasLessThan28Signs() {
        Account account = new Account("PL611090101", "name1", "PLN", "12.13", "30-08-2030");
        boolean result = validators.isIbanHasCorrectFormat(account.getAccountIban());
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenAccountIbanHasNotPolishPrefix() {
        Account account = new Account("CZ61109010140000071219812870", "name1", "PLN", "12.13", "30-08-2030");
        boolean result = validators.isIbanHasCorrectFormat(account.getAccountIban());
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenAccountIbanHasLettersInSecondPartOfNumber() {
        Account account = new Account("CZ611090101RK0000712PD812870", "name1", "PLN", "12.13", "30-08-2030");
        boolean result = validators.isIbanHasCorrectFormat(account.getAccountIban());
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenAccountIbanHasSpecialSignsInSecondPartOfNumber() {
        Account account = new Account("CZ611090101RK0@007__PD812270", "name1", "PLN", "12.13", "30-08-2030");
        boolean result = validators.isIbanHasCorrectFormat(account.getAccountIban());
        Assert.assertFalse(result);
    }
}
