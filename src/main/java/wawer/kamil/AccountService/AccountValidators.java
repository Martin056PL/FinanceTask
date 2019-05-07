package wawer.kamil.AccountService;

import org.apache.commons.lang3.StringUtils;
import wawer.kamil.model.Account;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AccountValidators {

    private boolean isCurrencyEqualsPLN(Account account) {
        //TODO czy mam uwzględniać wilkość liter? Założenie, że ma być wielkimi literami
        String currency = account.getCurrency();
        return currency.equals("PLN");
    }

    private boolean isBalanceLowerThanZero(Account account) {
        BigDecimal border = BigDecimal.ZERO;
        BigDecimal balance = account.getBalance();
        int result = balance.compareTo(border);
        System.out.println(result);
        return result != -1;
    }

    private boolean isCloseDateIsBeforePresentDate(Account account) {
        LocalDate closingDate = account.getClosingDate();
        LocalDate presentDate = LocalDate.now(); //TODO Czy uwzględniemy strefę czasową w której się znajdujemy czy inne strefy czasowe? Założenie że tylko te podane.
        boolean isBefore = closingDate.isBefore(presentDate);
        System.out.println(isBefore);
        if (isBefore) return false;
        else return true;
    }

    private boolean isIbanHasCorrectFormat(Account account) throws NullPointerException {
        String accountIban = account.getAccountIban();
        String iban = StringUtils.deleteWhitespace(accountIban);//TODO Czy zakładamy że spacje w podanym numerze sa nieakceptowalne? czy też dopuszczalne? Założenie: tylko ciągły numer rachunku bez spacji.
        if (iban != null) {
            int length = iban.length();
            if (length == 28) {
                String begining = iban.substring(0, 2);
                String rest = iban.substring(2);
                boolean isIbanContainsPolishPrefix = begining.equals("PL");
                boolean isIbanContainsOnlyNumbersAfterPrefix = StringUtils.isNumeric(rest);

                return isIbanContainsPolishPrefix && isIbanContainsOnlyNumbersAfterPrefix;
            } else return false;
        } else throw new NullPointerException();
    }
}
