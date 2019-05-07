package wawer.kamil.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public final class Account {
    @JacksonXmlProperty(localName = "iban", isAttribute = true)
    private String accountIban;
    @JacksonXmlProperty(localName = "name")
    private String name;
    @JacksonXmlProperty(localName = "currency")
    private String currency;
    @JacksonXmlProperty(localName = "balance")
    private BigDecimal balance;
    @JacksonXmlProperty(localName = "closingDate")
    private String closingDate;

    public Account() {
    }

    public Account(String accountIban, String name, String currency, BigDecimal balance, String closingDate) {
        this.accountIban = accountIban;
        this.name = name;
        this.currency = currency;
        this.balance = balance;
        this.closingDate = closingDate;
    }

    public String getAccountIban() {
        return accountIban;
    }

    public void setAccountIban(String accountIban) {
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

    public String getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(String closingDate) {
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountIban, account.accountIban) &&
                Objects.equals(name, account.name) &&
                Objects.equals(currency, account.currency) &&
                Objects.equals(balance, account.balance) &&
                Objects.equals(closingDate, account.closingDate);
    }
}
