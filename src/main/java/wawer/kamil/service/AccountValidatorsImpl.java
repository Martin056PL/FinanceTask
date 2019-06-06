package wawer.kamil.service;

import org.apache.commons.lang3.StringUtils;
import wawer.kamil.model.Account;
import wawer.kamil.utils.Logging;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.logging.Logger;

public class AccountValidatorsImpl implements AccountValidators {

    private static final int properLengthOfIbanNumber = 28;
    private Logger logging = Logging.getInstance();

    public AccountValidatorsImpl() throws IOException {
    }

    @Override
    public boolean checkAllValidators(Account account) {
        if (account != null) {

            boolean iban = isIbanHasCorrectFormat(account.getAccountIban());
            if (!iban) {
                logging.info("IBAN for Account with iban number: " + account.getAccountIban() + " is incorrect!");
            }
            boolean name = isNameNotNullAndIsNotEmpty(account.getName());
            if (!name) {
                logging.info("Name for Account with iban number: " + account.getAccountIban() + " is incorrect!");
            }
            boolean currency = isCurrencyEqualsPLN(account.getCurrency());
            if (!currency) {
                logging.info("Currency for Account with iban number: " + account.getAccountIban() + " is incorrect!");
            }
            boolean balance = isBalanceLowerThanZero(account.getBalance());
            if (!balance) {
                logging.info("Balance for Account with iban number: " + account.getAccountIban() + " is incorrect!");
            }
            boolean date = isCloseDateIsBeforePresentDate(account.getClosingDate());
            if (!date) {
                logging.info("CloseDate for Account with iban number: " + account.getAccountIban() + " is incorrect!");
            }
            return iban && name && currency && balance && date;

        } else return false;
    }

    @Override
    public boolean isIbanHasCorrectFormat(String iban) {
        if (isNotNullAndIsNotEmptyIncludingBlankString(iban)) {
            String trimedString = iban.trim();
            int length = trimedString.length();
            if (length == properLengthOfIbanNumber) {
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
            LocalDate presentDate = LocalDate.now();
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
