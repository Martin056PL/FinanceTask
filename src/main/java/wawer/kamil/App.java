package wawer.kamil;

import wawer.kamil.model.AccountRepository;

public class App {

    public static void main(String[] args) {

        AccountRepository repository = new AccountRepository();
        System.out.println(repository.getAccountRepository());

    }
}
