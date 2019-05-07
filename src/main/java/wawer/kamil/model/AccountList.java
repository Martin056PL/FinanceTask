package wawer.kamil.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Arrays;
import java.util.List;

@JacksonXmlRootElement(localName = "accounts")
public final class AccountList {

    @JacksonXmlElementWrapper(localName = "account", useWrapping = false)

    private Account[] account;
    private List<Account> accountList;

    public AccountList() {
    }

    public AccountList(List<Account> employee) {
        this.accountList = employee;
    }

    public List<Account> getAccount() {
        return accountList;
    }

    public void setAccount(List<Account> account) {
        this.accountList = account;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employees=" + accountList.toString() +
                '}';
    }
}
