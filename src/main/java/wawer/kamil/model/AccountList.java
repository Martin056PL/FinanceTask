package wawer.kamil.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "accounts")
public final class AccountList {

    @JacksonXmlProperty(localName = "account")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Account> accountList;

    public AccountList() {
    }

    public AccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> account) {
        this.accountList = account;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employees=" + accountList.toString() +
                '}';
    }
}
