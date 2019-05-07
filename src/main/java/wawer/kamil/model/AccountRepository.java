package wawer.kamil.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class AccountRepository {

    public List<Account> getAccountRepository() {
        List<Account> accountList = defaultAccountRepository();
        return accountList;
    }

    private List<Account> defaultAccountRepository() {
        List<Account> accountList = new LinkedList<>();
        /*0*/    accountList.add(new Account("PL61109010140000071219812870", "name4", "PLN", BigDecimal.ZERO, LocalDate.parse("2029-10-11")));
        /*1*/    accountList.add(new Account("PL61109010140000071219812875", "name1", "PLN", BigDecimal.valueOf(123.45), LocalDate.parse("2031-06-10")));
        /*2*/    accountList.add(new Account("PL61109010140000071219812871", "name2", "PLN", BigDecimal.valueOf(85.00), LocalDate.parse("2035-10-01")));
        /*3*/    accountList.add(new Account("PL61109010140000071219812872", "name3", "USD", BigDecimal.valueOf(1000000.00), LocalDate.parse("2059-10-01")));
        /*4*/    accountList.add(new Account("PLL1109010140000071219812873", "name5", "PLN", BigDecimal.valueOf(999.00), LocalDate.parse("2050-01-01")));
        /*5*/    accountList.add(new Account("PL61109010140000071219812874", "name6", "PLN", BigDecimal.valueOf(-100.00), LocalDate.parse("2019-05-07")));
        /*6*/    accountList.add(new Account("PLL1109010140000071219812876", "name7", "PLN", BigDecimal.valueOf(1), LocalDate.parse("2010-01-01")));
        return accountList;
    }
}
