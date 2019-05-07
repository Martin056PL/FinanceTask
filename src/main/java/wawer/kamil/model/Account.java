package wawer.kamil.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Account {

    private String accountIban;
    private String name;
    private String currency;
    private BigDecimal balance;
    private LocalDate closingDate;

    public String getaccountIban() {
        return accountIban;
    }

    public void setaccountIban(String accountIban) {
        this.accountIban = accountIban;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDate getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountIban + '\'' +
                ", name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                ", balance=" + balance +
                ", closingDate=" + closingDate +
                '}';
    }
}
