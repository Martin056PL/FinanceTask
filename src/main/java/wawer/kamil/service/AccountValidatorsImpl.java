package wawer.kamil.service;

import org.apache.commons.lang3.StringUtils;
import wawer.kamil.utils.Logging;
import wawer.kamil.model.Account;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class AccountValidatorsImpl implements AccountValidators {

    @Override
    public boolean checkAllValidators(Account account) {
        if (account != null) {
            Logging.LOGGER.info("IBAN:");
            boolean format = isIbanHasCorrectFormat(account.getAccountIban());
            Logging.LOGGER.info("iban has correct form:  " + format);

            Logging.LOGGER.info("NAME:");
            boolean name = isNameNotNullAndIsNotEmpty(account.getName());
            Logging.LOGGER.info("name has correct format: " + name);

            Logging.LOGGER.info("CURRENCY:");
            boolean currency = isCurrencyEqualsPLN(account.getCurrency());
            Logging.LOGGER.info("currency has correct format: " + currency);

            Logging.LOGGER.info("Balance:");
            boolean balance = isBalanceLowerThanZero(account.getBalance());
            Logging.LOGGER.info("balance has correct format: " + balance);

            Logging.LOGGER.info("DATE:");
            boolean date = isCloseDateIsBeforePresentDate(account.getClosingDate());
            Logging.LOGGER.info("date has correct format: " + date);

            boolean isAccountCorrect = format && name && currency && balance && date;

            Logging.LOGGER.info("SUMMARY: Is all data in service validated correctly: " + isAccountCorrect);
            return isAccountCorrect;
        } else return false;
    }

    @Override
    public boolean isIbanHasCorrectFormat(String iban) {
        //TODO Czy zakładamy że spacje w podanym numerze sa nieakceptowalne? czy też dopuszczalne? Założenie: tylko ciągły numer rachunku bez spacji.
        if (isNotNullAndIsNotEmptyIncludingBlankString(iban)) {
            String trimedString = iban.trim();
            int length = trimedString.length();
            if (length == 28) {
                String countryCodeInIbanNumber = trimedString.substring(0, 2);
                String ibanNumberOfAccount = trimedString.substring(2);
                boolean isIbanContainsPolishPrefix = countryCodeInIbanNumber.toUpperCase().equals("PL");
                boolean isIbanContainsOnlyNumbersAfterPrefix = StringUtils.isNumeric(ibanNumberOfAccount);
                return isIbanContainsPolishPrefix && isIbanContainsOnlyNumbersAfterPrefix;
            } else return false;
        } else return false;
    }

    @Override
    public boolean isNameNotNullAndIsNotEmpty(String name) {
        return isNotNullAndIsNotEmptyIncludingBlankString(name);
    }

    @Override
    public boolean isCurrencyEqualsPLN(String currency) {
        //TODO czy mam uwzględniać wilkość liter? Założenie, że ma być wielkimi literami
        if (isNotNullAndIsNotEmptyIncludingBlankString(currency)) {
            String upperCaseCurrency = currency.toUpperCase().trim();
            return upperCaseCurrency.equals("PLN");
        } else return false;
    }

    @Override
    public boolean isBalanceLowerThanZero(String balance) {
        if (isNotNullAndIsNotEmptyIncludingBlankString(balance) && isNumeric(balance)) {
            BigDecimal balanceInBigDecimal = convertStringToBigDecimal(balance);
            BigDecimal emptyAccount = BigDecimal.ZERO;
            int result = balanceInBigDecimal.compareTo(emptyAccount);
            return result != -1;
        } else return false;
    }

    @Override
    public boolean isCloseDateIsBeforePresentDate(String closingDate) {
        if (isNotNullAndIsNotEmptyIncludingBlankString(closingDate)) {
            LocalDate presentDate = LocalDate.now(); //TODO Czy uwzględniemy strefę czasową w której się znajdujemy czy inne strefy czasowe? Założenie że tylko te podane.
            if (isDateHasCorrectFormat(closingDate)) {
                LocalDate localDateClosingDate = LocalDate.parse(closingDate);
                return presentDate.compareTo(localDateClosingDate) <= 0;
            } else return false;
        } else return false;
    }

    private boolean isNotNullAndIsNotEmptyIncludingBlankString(String accountInformation) {
        return accountInformation != null && !accountInformation.trim().isEmpty();
    }

    private boolean isDateHasCorrectFormat(String closingDate) {
        boolean result = true;
        try {
            LocalDate.parse(closingDate);
        } catch (DateTimeParseException e) {
            result = false;
        }
        return result;
    }

    private BigDecimal convertStringToBigDecimal(String balance) {
        double balanceInInteger = Double.parseDouble(balance);
        return BigDecimal.valueOf(balanceInInteger);
    }

    private boolean isNumeric(String string) {
        boolean numeric = true;
        try {
            Double.parseDouble(string);
        } catch (NumberFormatException e) {
            numeric = false;
        }
        return numeric;
    }
}
