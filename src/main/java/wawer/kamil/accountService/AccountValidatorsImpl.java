package wawer.kamil.accountService;

import org.apache.commons.lang3.StringUtils;
import wawer.kamil.model.Account;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AccountValidatorsImpl implements AccountValidators {

    @Override
    public boolean checkAllValidators(Account account) {
        boolean currency = isCurrencyEqualsPLN(account.getCurrency());
        boolean balance = isBalanceLowerThanZero(account.getBalance());
        LocalDate dateCreatedByString = LocalDate.parse(account.getClosingDate());
        boolean date = isCloseDateIsBeforePresentDate(dateCreatedByString);
        boolean format = isIbanHasCorrectFormat(account.getAccountIban());
        return currency && balance && date && format;
    }

    @Override
    public boolean isCurrencyEqualsPLN(String currency) {
        //TODO czy mam uwzględniać wilkość liter? Założenie, że ma być wielkimi literami
        if (currency != null) {
            String upperCaseCurrency = currency.toUpperCase();
            return upperCaseCurrency.equals("PLN");
        } else return false;
    }

    @Override
    public boolean isBalanceLowerThanZero(BigDecimal balance) {
        if(balance!=null) {
            BigDecimal border = BigDecimal.ZERO;
            int result = balance.compareTo(border);
            return result != -1;
        }else return false;
    }

    @Override
    public boolean isCloseDateIsBeforePresentDate(LocalDate closingDate) {
        if(closingDate != null) {
            LocalDate presentDate = LocalDate.now(); //TODO Czy uwzględniemy strefę czasową w której się znajdujemy czy inne strefy czasowe? Założenie że tylko te podane.
            return presentDate.compareTo(closingDate) <= 0;
        }else return false;
    }

    @Override
    public boolean isIbanHasCorrectFormat(String iban) throws NullPointerException {
        //TODO Czy zakładamy że spacje w podanym numerze sa nieakceptowalne? czy też dopuszczalne? Założenie: tylko ciągły numer rachunku bez spacji.
        if (iban != null) {
            int length = iban.length();
            if (length == 28) {
                String begining = iban.substring(0, 2);
                String rest = iban.substring(2);
                boolean isIbanContainsPolishPrefix = begining.equals("PL");
                boolean isIbanContainsOnlyNumbersAfterPrefix = StringUtils.isNumeric(rest);

                return isIbanContainsPolishPrefix && isIbanContainsOnlyNumbersAfterPrefix;
            } else return false;
        } else return false;
    }
}
