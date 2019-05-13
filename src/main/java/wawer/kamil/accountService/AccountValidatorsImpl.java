package wawer.kamil.accountService;

import org.apache.commons.lang3.StringUtils;
import wawer.kamil.model.Account;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AccountValidatorsImpl implements AccountValidators {

    @Override
    public boolean checkAllValidators(Account account) {
        //TODO co w przypadku gdy któreś pole nie jest nulle ale jest puste? Założenie: odrzucić
        boolean currency = isCurrencyEqualsPLN(account.getCurrency());
        boolean balance = isBalanceLowerThanZero(account.getBalance());
        LocalDate dateCreatedByString = LocalDate.parse(account.getClosingDate());
        boolean date = isCloseDateIsBeforePresentDate(dateCreatedByString);
        boolean format = isIbanHasCorrectFormat(account.getAccountIban());
        boolean name = isNameNotNull(account.getName());

        return currency && balance && date && format && name;
    }


    @Override
    public boolean isCurrencyEqualsPLN(String currency) {
        //TODO czy mam uwzględniać wilkość liter? Założenie, że ma być wielkimi literami
        if (currency != null && !currency.isEmpty()) {
            String upperCaseCurrency = currency.toUpperCase();
            return upperCaseCurrency.equals("PLN");
        } else return false;
    }

    @Override
    public boolean isBalanceLowerThanZero(String balance) {
        if (balance != null && !balance.isEmpty() && isNumeric(balance)) {
            BigDecimal balanceInBigDecimal = convertStringToBigDecimal(balance);
            BigDecimal emptyAccount = BigDecimal.ZERO;
            int result = balanceInBigDecimal.compareTo(emptyAccount);
            return result != -1;
        } else return false;
    }



    @Override
    public boolean isCloseDateIsBeforePresentDate(LocalDate closingDate) {
        if (closingDate != null) {
            LocalDate presentDate = LocalDate.now(); //TODO Czy uwzględniemy strefę czasową w której się znajdujemy czy inne strefy czasowe? Założenie że tylko te podane.
            return presentDate.compareTo(closingDate) <= 0;
        } else return false;
    }

    @Override
    public boolean isIbanHasCorrectFormat(String iban) {
        //TODO Czy zakładamy że spacje w podanym numerze sa nieakceptowalne? czy też dopuszczalne? Założenie: tylko ciągły numer rachunku bez spacji.
        if (iban != null && !iban.isEmpty()) {
            int length = iban.length();
            if (length == 28) {
                String countryCodeInIbanNumber = iban.substring(0, 2);
                String ibanNumberOfAccount = iban.substring(2);
                boolean isIbanContainsPolishPrefix = countryCodeInIbanNumber.equals("PL");
                boolean isIbanContainsOnlyNumbersAfterPrefix = StringUtils.isNumeric(ibanNumberOfAccount);

                return isIbanContainsPolishPrefix && isIbanContainsOnlyNumbersAfterPrefix;
            } else return false;
        } else return false;
    }

    @Override
    public boolean isNameNotNull(String name) {
        return name != null && !name.isEmpty();
    }

    private BigDecimal convertStringToBigDecimal(String balance) {
        double balanceInInteger = Double.parseDouble(balance);
        return BigDecimal.valueOf(balanceInInteger);
    }

    private boolean isNumeric(String string){
        boolean numeric = true;
        try {
            Double.parseDouble(string);
        } catch (NumberFormatException e) {
            numeric = false;
        }
        return numeric;
    }
}
