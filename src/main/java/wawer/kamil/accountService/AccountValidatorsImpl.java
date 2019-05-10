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
            return currency.equals("PLN");
        } else throw new IllegalArgumentException();
    }

    @Override
    public boolean isBalanceLowerThanZero(BigDecimal balance) {
        BigDecimal border = BigDecimal.ZERO;
        int result = balance.compareTo(border);
        return result != -1;
    }

    @Override
    public boolean isCloseDateIsBeforePresentDate(LocalDate closingDate) {
        LocalDate presentDate = LocalDate.now(); //TODO Czy uwzględniemy strefę czasową w której się znajdujemy czy inne strefy czasowe? Założenie że tylko te podane.
        boolean isBefore = closingDate.isBefore(presentDate);
        if (isBefore) return false;
        else return true;
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
        } else throw new NullPointerException();
    }
}
