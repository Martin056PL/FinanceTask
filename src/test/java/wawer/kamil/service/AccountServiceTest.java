package wawer.kamil.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import wawer.kamil.model.Account;

import java.util.LinkedList;
import java.util.List;

public class AccountServiceTest {

    private AccountService service;

    public AccountServiceTest(){
        this.service = new AccountServiceImpl();
    }

    private List<Account> getDefaultRepository(){
        List<Account> listOfAccounts = new LinkedList<>();
        listOfAccounts.add(new Account("PL61109010140000071219812870", "name4", "PLN", "0", "2029-10-11"));
        listOfAccounts.add(new Account("PL61109010140000071219812875", "name1", "PLN", "123.45", "2031-06-10"));
        listOfAccounts.add(new Account("PL61109010140000071219812871", "name2", "PLN", "85.00","2035-10-01"));
        listOfAccounts.add(new Account("PL61109010140000071219812872", "name3", "USD", "1000000.00", "2059-10-01"));
        listOfAccounts.add(new Account("PLL1109010140000071219812873", "name5", "PLN", "999.00", "2050-01-01"));
        listOfAccounts.add(new Account("PL61109010140000071219812874", "name6", "PLN", "-100.00", "2039-05-15"));
        listOfAccounts.add(new Account("PLL1109010140000071219812876", "name7", "PLN", "1", "2010-01-01"));
        return listOfAccounts;
    }

    @Test
    public void should_Size_Of_Default_Repository_Is_Equal_7(){
        //when
        List<Account> defaultRepository = getDefaultRepository();
        //then
        Assert.assertEquals(7,defaultRepository.size());
    }

    @Test
    public void should_Validate_Accounts_And_Add_Them_Into_Validated_List_And_List_should_Contain_3_Proper_Values(){
        //given
        List<Account> defaultRepository = getDefaultRepository();
        List<Account> expectedRepository = new LinkedList<>();
        expectedRepository.add(new Account("PL61109010140000071219812870", "name4", "PLN", "0", "2029-10-11"));
        expectedRepository.add(new Account("PL61109010140000071219812875", "name1", "PLN", "123.45", "2031-06-10"));
        expectedRepository.add(new Account("PL61109010140000071219812871", "name2", "PLN", "85.00","2035-10-01"));

        //when
        List<Account> validatedRepository = service.validateEverySingleAccount(defaultRepository);

        //then
        Assert.assertTrue(validatedRepository.containsAll(expectedRepository));
    }

    @Test
    public void should_Validate_Accounts_Incorrect_Accounts_Return_Empty_List(){
        //given
        List<Account> defaultRepository = new LinkedList<>();
        defaultRepository.add(new Account("PLASDWQEDASDAWDQWDSADQWDASDA", "name4", "PLN", "0", "2029-10-11"));
        defaultRepository.add(new Account("PL61109010140000071219812875", "name1", "USD", "123.45", "2031-06-10"));
        defaultRepository.add(new Account("PL61109010140000071219812871", "name2", "PLN", "-342.03","2035-10-01"));
        defaultRepository.add(new Account("PL61109010140000071219812871", "name2", "PLN", "342.03","1992-10-01"));
        //when
        List<Account> validatedRepository = service.validateEverySingleAccount(defaultRepository);

        //then
        Assert.assertTrue(validatedRepository.isEmpty());
    }

    @Test
    public void should_Return_Empty_List_When_There_Is_Not_Aby_Account(){
        //given
        List<Account> defaultRepository = new LinkedList<>();
        //when
        List<Account> validatedRepository = service.validateEverySingleAccount(defaultRepository);
        //then
        Assert.assertTrue(validatedRepository.isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void should_Return_Empty_List_When_There_Is_Not_Aby_Account_sd(){
        //given
        List<Account> defaultRepository = null;
        //when
        List<Account> validatedRepository = service.validateEverySingleAccount(defaultRepository);
        //then
        Assert.assertTrue(validatedRepository.isEmpty());
    }
}
