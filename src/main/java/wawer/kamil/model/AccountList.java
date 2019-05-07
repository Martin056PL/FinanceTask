package wawer.kamil.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.LinkedList;
import java.util.List;

@JacksonXmlRootElement(localName = "accounts")
public final class AccountList {

    @JacksonXmlElementWrapper(localName = "accountList", useWrapping = false)
    private List<Account> accountList;

    public AccountList() {
    }

    public AccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(LinkedList<Account> account) {
        this.accountList = account;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employees=" + accountList.toString() +
                '}';
    }
}