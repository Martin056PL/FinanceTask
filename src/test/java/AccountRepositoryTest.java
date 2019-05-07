import org.junit.Assert;
import org.junit.Test;
import wawer.kamil.model.AccountRepository;

public class AccountRepositoryTest {

    private AccountRepository repository;

    public AccountRepositoryTest() {
        this.repository = new AccountRepository();
    }

    @Test
    public void shouldReturnEqualSizeOfDefaultAccountList(){
        int accountSizeRepository = repository.getAccountRepository().size();
        Assert.assertEquals(accountSizeRepository,7);
    }
}
