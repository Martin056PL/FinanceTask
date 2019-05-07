package wawer.kamil.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Arrays;

@JacksonXmlRootElement(localName = "accounts")
public final class AccountList {

    @JacksonXmlElementWrapper(localName = "account", useWrapping = false)

    private Account[] account;

    public AccountList() {
    }

    public AccountList(Account[] employee) {
        this.account = employee;
    }

    public Account[] getAccount() {
        return account;
    }

    public void setAccount(Account[] account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employees=" + Arrays.toString(account) +
                '}';
    }
}
