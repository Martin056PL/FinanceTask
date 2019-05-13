package wawer.kamil.accountService;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class AccountValidatorsTest {

    private AccountValidators validators;

    public AccountValidatorsTest() {
        this.validators = new AccountValidatorsImpl();
    }

    private final String nullString = null;
    private final String emptyString = "";
    private final String blankString = " ";

    // IBAN NUMBER
    @Test
    public void should_Return_False_When_Account_Iban_Is_Null() {
        //given
        String iban = nullString;
        //when
        boolean result = validators.isIbanHasCorrectFormat(iban);
        //than
        Assert.assertFalse(result);
    }

    @Test
    public void should_Return_False_When_Account_Iban_Is_Empty() {
        //given
        String iban = emptyString;
        //when
        boolean result = validators.isIbanHasCorrectFormat(iban);
        //than
        Assert.assertFalse(result);
    }

    @Test
    public void should_Return_False_When_Account_Iban_Is_Blank() {
        //given
        String iban = blankString;
        //when
        boolean result = validators.isIbanHasCorrectFormat(iban);
        //than
        Assert.assertFalse(result);
    }

    @Test
    public void should_Return_True_When_Account_Iban_Is_Correct() {
        //given
        String iban = "PL61109010140000071219812870";
        //when
        boolean result = validators.isIbanHasCorrectFormat(iban);
        //than
        Assert.assertTrue(result);
    }

    @Test
    public void should_Return_True_When_Account_Iban_Has_Blank_Signs_Before_And_Or_After_Proper_Number() {
        //given
        String iban = " PL61109010140000071219812870 ";
        //when
        boolean result = validators.isIbanHasCorrectFormat(iban);
        //than
        Assert.assertTrue(result);
    }

    @Test
    public void should_Return_True_When_Account_Iban_Has_Little_Letters_In_Prefix() {
        //given
        String iban = "pl61109010140000071219812870";
        //when
        boolean result = validators.isIbanHasCorrectFormat(iban);
        //than
        Assert.assertTrue(result);
    }

    @Test
    public void should_Return_False_When_Account_Iban_Has_More_Than_28_Signs() {
        //given
        String iban = "PL611090101400000712198128701231231231233123";
        //when
        boolean result = validators.isIbanHasCorrectFormat(iban);
        //than
        Assert.assertFalse(result);
    }

    @Test
    public void should_Return_False_When_Account_Iban_Has_Less_Than_28_Signs() {
        //given
        String iban = "PL611090101";
        //when
        boolean result = validators.isIbanHasCorrectFormat(iban);
        //than
        Assert.assertFalse(result);
    }

    @Test
    public void should_Return_False_When_Account_Iban_Has_Not_Polish_Prefix() {
        //given
        String iban = "CZ61109010140000071219812870";
        //when
        boolean result = validators.isIbanHasCorrectFormat(iban);
        //than
        Assert.assertFalse(result);
    }

    @Test
    public void should_Return_False_When_Account_Iban_Has_Letters_In_Second_Part_Of_Number() {
        //given
        String iban = "CZ611090101RK0000712PD812870";
        //when
        boolean result = validators.isIbanHasCorrectFormat(iban);
        //than
        Assert.assertFalse(result);
    }

    @Test
    public void should_Return_False_When_Account_Iban_Has_Forbidden_Signs_In_Second_Part_Of_Number() {
        //given
        String iban = "CZ611090101RK0@007__PD812!70";
        //when
        boolean result = validators.isIbanHasCorrectFormat(iban);
        //than
        Assert.assertFalse(result);
    }

    //ACCOUNT NAME
    @Test
    public void should_Return_False_When_Account_Name_Is_Null() {
        //given
        String name = nullString;
        //when
        boolean result = validators.isNameNotNullAndIsNotEmpty(name);
        //than
        Assert.assertFalse(result);
    }

    @Test
    public void should_Return_False_When_Account_Name_Is_Empty() {
        //given
        String name = emptyString;
        //when
        boolean result = validators.isNameNotNullAndIsNotEmpty(name);
        //than
        Assert.assertFalse(result);
    }

    @Test
    public void should_Return_False_When_Account_Name_Is_Blank() {
        //given
        String name = blankString;
        //when
        boolean result = validators.isNameNotNullAndIsNotEmpty(name);
        //than
        Assert.assertFalse(result);
    }

    @Test
    public void should_Return_True_When_Account_Name_Has_Any_Title() {
        //given
        String name = "anyName123!";
        //when
        boolean result = validators.isNameNotNullAndIsNotEmpty(name);
        //than
        Assert.assertTrue(result);
    }

    @Test
    public void should_Return_True_When_Account_Name_Has_Any_Title_With_Spaces_Between_And_Or_After_Name() {
        //given
        String name = " anyName123! ";
        //when
        boolean result = validators.isNameNotNullAndIsNotEmpty(name);
        //than
        Assert.assertTrue(result);
    }

    //CURRENCY
    @Test
    public void should_Return_False_When_Account_Currency_Is_Null() {
        //given
        String currency = nullString;
        //when
        boolean result = validators.isCurrencyEqualsPLN(currency);
        //than
        Assert.assertFalse(result);
    }

    @Test
    public void should_Return_False_When_Account_Currency_Is_Empty() {
        //given
        String currency = emptyString;
        //when
        boolean result = validators.isCurrencyEqualsPLN(currency);
        //than
        Assert.assertFalse(result);
    }

    @Test
    public void should_Return_False_When_Account_Currency_Is_Blank() {
        //given
        String currency = blankString;
        //when
        boolean result = validators.isCurrencyEqualsPLN(currency);
        //than
        Assert.assertFalse(result);
    }

    @Test
    public void should_Return_True_When_Account_Currency_Equals_PLN() {
        //given
        String currentCurrency = "PLN";
        //when
        boolean result = validators.isCurrencyEqualsPLN(currentCurrency);
        //than
        Assert.assertTrue(result);
    }

    @Test
    public void should_Return_True_When_Currency_Equals_PLN_In_Lower_Case() {
        //given
        String currentCurrency = "pln";
        //when
        boolean result = validators.isCurrencyEqualsPLN(currentCurrency);
        //than
        Assert.assertTrue(result);
    }

    @Test
    public void should_Return_False_When_Currency_Not_Equals_PLN_For_Example_USD() {
        //given
        String currentCurrency = "USD";
        //when
        boolean result = validators.isCurrencyEqualsPLN(currentCurrency);
        //than
        Assert.assertFalse(result);
    }

    @Test
    public void should_Return_False_When_Currency_Is_Wrote_With_Spaces() {
        //given
        String currentCurrency = "P L N ";
        //when
        boolean result = validators.isCurrencyEqualsPLN(currentCurrency);
        //than
        Assert.assertFalse(result);
    }

    @Test
    public void should_Return_True_When_Currency_Is_Wrote_With_Spaces_Before_And_Or_After_Currency() {
        //given
        String currentCurrency = " PLN ";
        //when
        boolean result = validators.isCurrencyEqualsPLN(currentCurrency);
        //than
        Assert.assertTrue(result);
    }

    //BALANCE
    @Test
    public void should_Return_False_When_Account_Balance_Is_Null() {
        //given
        String balance = nullString;
        //when
        boolean result = validators.isBalanceLowerThanZero(balance);
        //than
        Assert.assertFalse(result);
    }

    @Test
    public void should_Return_False_When_Balance_Is_Empty() {
        //given
        String balance = emptyString;
        //when
        boolean result = validators.isBalanceLowerThanZero(balance);
        //than
        Assert.assertFalse(result);
    }

    @Test
    public void should_Return_True_When_Balance_Grater_Than_Zero() {
        //given
        String balance = "123.63";
        //when
        boolean result = validators.isBalanceLowerThanZero(balance);
        //than
        Assert.assertTrue(result);
    }

    @Test
    public void should_Return_False_When_Separator_Is_Coma_Instead_Of_Dot() {
        //given
        String balance = "123,63";
        //when
        boolean result = validators.isBalanceLowerThanZero(balance);
        //than
        Assert.assertFalse(result);
    }

    @Test
    public void should_Return_True_When_Balance_Equals_Zero() {
        //given
        String balance = "0";
        //when
        boolean result = validators.isBalanceLowerThanZero(balance);
        //than
        Assert.assertTrue(result);
    }

    @Test
    public void should_Return_True_When_Balance_Lower_Than_Zero() {
        //given
        String balance = "-340.45";
        //when
        boolean result = validators.isBalanceLowerThanZero(balance);
        //than
        Assert.assertFalse(result);
    }

    @Test
    public void should_Return_False_When_Balance_In_Not_Numerical() {
        //given
        String balance = "10Zlotys";
        //when
        boolean result = validators.isBalanceLowerThanZero(balance);
        //than
        Assert.assertFalse(result);
    }

    //CLOSING DATE
    @Test
    public void should_Return_False_When_Account_Closing_Date_Is_Null() {
        //given
        String closingDate = nullString;
        //when
        boolean result = validators.isCloseDateIsBeforePresentDate(closingDate);
        //than
        Assert.assertFalse(result);
    }

    @Test
    public void should_Return_False_When_Account_Closing_Date_Is_Empty() {
        //given
        String closingDate = emptyString;
        //when
        boolean result = validators.isCloseDateIsBeforePresentDate(closingDate);
        //than
        Assert.assertFalse(result);
    }

    @Test
    public void should_Return_False_When_Account_Closing_Date_Is_Blank() {
        //given
        String closingDate = blankString;
        //when
        boolean result = validators.isCloseDateIsBeforePresentDate(closingDate);
        //than
        Assert.assertFalse(result);
    }

    @Test
    public void should_Return_True_When_Account_Closing_Date_Is_After_Present_Date() {
        //given
        String closingDate = LocalDate.now().plusMonths(2).toString();
        //when
        boolean result = validators.isCloseDateIsBeforePresentDate(closingDate);
        //than
        Assert.assertTrue(result);
    }

    @Test
    public void should_Return_True_When_Account_Closing_Date_Is_Equal_Present_Date() {
        //given
        String closingDate = LocalDate.now().toString();
        //when
        boolean result = validators.isCloseDateIsBeforePresentDate(closingDate);
        //than
        Assert.assertTrue(result);
    }
    @Test
    public void should_Return_False_When_Account_Closing_Date_Is_Before_Present_Date() {
        //given
        String closingDate = LocalDate.now().minusMonths(2).toString();
        //when
        boolean result = validators.isCloseDateIsBeforePresentDate(closingDate);
        //than
        Assert.assertFalse(result);
    }

}
