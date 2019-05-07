import wawer.kamil.AccountService.AccountValidators;
import wawer.kamil.model.Account;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AccountValidatorsTest {

    private AccountValidators validators;
    private Account account;

    public AccountValidatorsTest() {
        this.validators = new AccountValidators();
        this.account = new Account("PL61109010140000071219812870", "name4", "PLN", BigDecimal.ZERO, LocalDate.parse("2029-10-11"));
    }

    /*@Test
    public void shouldReturnTrueWithCorrectItIsDefaultData() {
        boolean isAccountCorrect = validators.checkAllValidators(account);
        Assert.assertTrue(isAccountCorrect);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnNullPointerExceptionWhenIbanNumberIsNull() {
        Account account = new Account(null, "Asd", "asda", BigDecimal.ZERO, LocalDate.parse("2010-12-12"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnNullPointerExceptionWhenAccountNameIsNull() {
        account.setName(null);
        System.out.println(account);
        boolean isAccountCorrect = validators.checkAllValidators(account);
    }
    @Test
    public void shouldReturnFalseWithIncorrectIbanNumber() {
        boolean isAccountCorrect = validators.checkAllValidators(account);
        Assert.assertTrue(isAccountCorrect);
    }

    @Test
    public void shouldReturnTrueIfCurrencyEqualsPLNInCorrectCase () {
        boolean isAccountCorrect = validators.isCurrencyEqualsPLN("PLN");
        Assert.assertTrue(isAccountCorrect);
    }
    @Test
    public void shouldReturnTrueIfCurrencyEqualsPLNInIncorrectCase () {
        boolean isAccountCorrect = validators.isCurrencyEqualsPLN("pln");
        Assert.assertFalse(isAccountCorrect);
    }
    @Test
    public void shouldReturnFalseIfCurrencyEqualsOtherCurrencyPrefix () {
        AccountValidators validators = new AccountValidators();
        Method method =

        boolean isAccountCorrect = validators.isCurrencyEqualsPLN("USD");
        Assert.assertFalse(isAccountCorrect);
    }*/

}
