package wawer.kamil.accountService;

import wawer.kamil.model.Account;
import wawer.kamil.model.AccountList;

import java.util.Iterator;
import java.util.List;

public class AccountService {

    //TODO Zrobic metode na porównywanie list i porzadkowanie ich;

    private AccountList list;
    private AccountValidators validators;

    public AccountService() {
        this.list = new AccountList();
        this.validators = new AccountValidators();
    }

    public List<Account> servis(List<Account> repo){
        Iterator<Account> iterator = repo.iterator();
        boolean hasNext = iterator.hasNext();
        while (hasNext){
            Account account = iterator.next();
            System.out.println(account);
            if(validators.checkAllValidators(account)){
                continue;
            }else{
                iterator.remove();
            }
            hasNext = iterator.hasNext();
        }
        return repo;
    }

    private List<Account> getAccountList() {
        List<Account> repository = list.getAccountList();
        return repository;
    }

}
