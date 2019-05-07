package wawer.kamil.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public final class Account {

    private String accountIban;
    private String name;
    private String currency;
    private BigDecimal balance;
    private LocalDate closingDate;

    public Account(String accountIban, String name, String currency, BigDecimal balance, LocalDate closingDate) {
        if (accountIban == null || name == null || currency == null || balance == null || closingDate == null)
            throw new IllegalArgumentException("Pola nie mogą być nullami");
        if (accountIban.isEmpty() || name.isEmpty() || currency.isEmpty())
            throw new IllegalArgumentException("Pola nie mogą byc puste");
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
