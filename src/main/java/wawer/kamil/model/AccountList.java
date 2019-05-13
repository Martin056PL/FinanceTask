package wawer.kamil.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.List;

@JacksonXmlRootElement(localName = "accounts")
public final class AccountList implements Serializable {

    private static final long serialVersionUID = 9215731280802778862L;
    @JacksonXmlProperty(localName = "account")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Account> accountList;

    public AccountList() {
        //constructor for XML Mapping
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
