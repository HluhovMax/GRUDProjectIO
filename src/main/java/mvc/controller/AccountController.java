package mvc.controller;

import mvc.model.Account;
import mvc.repository.AccountRepository;
import mvc.repository.JavaIOAccountRepositoryImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max Hluhov on 23.10.2018.
 */
public class AccountController {
    private AccountRepository accountRepository;
    private Account account;
    private List<Account> accountList;

    public AccountController() {
        accountRepository = new JavaIOAccountRepositoryImpl();
        account = new Account();
        accountList = new ArrayList<>();
    }

    public void saveToAccountRepo(Account account) {
        if (account != null) {
            try {
                accountRepository.save(account);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void updateToAccountRepo(Account account) {
        if (account != null) {
            try {
                accountRepository.update(account);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void deleteFromAccountRepo(Long id) {
        if (id != 0) {
            try {
                accountRepository.delete(id);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Account getByIdFromAccountRepo(Long id) {
        if (id != 0) {
            try {
                account = accountRepository.getById(id);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            String data = account.getData().substring(0,
                    account.getData().length() - 1);
            account.setData(data);
            return account;
        }
        return null;
    }

    public List<Account> getAll() {
        try {
            accountList = accountRepository.getAll();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<Account> accounts = new ArrayList<>();
        for (Account a : accounts) {
            String s = a.getData().substring(0,
                    a.getData().length() - 1);
            a.setData(s);
            accounts.add(a);
        }
        accountList = accounts;
        return accountList;
    }
}
