package wawer.kamil.accountService;

import wawer.kamil.model.Account;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface AccountValidators {

    boolean checkAllValidators(Account account);

    boolean isCurrencyEqualsPLN(String currency);

    boolean isBalanceLowerThanZero(String balance);

    boolean isCloseDateIsBeforePresentDate(LocalDate closingDate);

    boolean isIbanHasCorrectFormat(String iban);

    boolean isNameNotNull(String name);
}
