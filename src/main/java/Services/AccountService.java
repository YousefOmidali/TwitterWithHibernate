package Services;

import Entity.Account;
import Entity.Comment;
import Repository.AccountRepository;

import java.util.List;


public class AccountService {
    private AccountRepository accountRepository = new AccountRepository();

    public void save(Account account) {
        accountRepository.save(account);
    }

    public void deleteById(Long id) {
        accountRepository.findById(id);
    }

    public void update(Account account) {
        accountRepository.update(account);
    }

    public Account findById(Long id) {
        return accountRepository.findById(id);
    }

    public Account findByUsername(String username) {
        return accountRepository.findByUserName(username);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account login(String username, String password) {
        return accountRepository.login(username, password);
    }
}
