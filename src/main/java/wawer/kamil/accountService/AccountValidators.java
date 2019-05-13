package wawer.kamil.accountService;

import wawer.kamil.model.Account;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface AccountValidators {

    boolean checkAllValidators(Account account);

    boolean isCurrencyEqualsPLN(String currency);

    boolean isBalanceLowerThanZero(String balance);

    boolean isCloseDateIsBeforePresentDate(String closingDate);

    boolean isIbanHasCorrectFormat(String iban);

    boolean isNameNotNullAndIsNotEmpty(String name);
}
