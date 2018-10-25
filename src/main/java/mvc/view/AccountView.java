package mvc.view;

import mvc.controller.AccountController;
import mvc.exception.NoSuchElementException;
import mvc.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Max Hluhov on 23.10.2018.
 */
public class AccountView {
    private Long id;
    private String data;
    private Scanner idScanner;
    private Scanner dataScanner;
    private List<Account> accountList;
    private AccountController accountController;
    private Account account;

    public AccountView() {
        idScanner = new Scanner(System.in);
        dataScanner = new Scanner(System.in);
        accountList = new ArrayList<>();
        accountController = new AccountController();
        account = new Account();
    }

    public void saveAccount() {
        System.out.println("to save account, enter id & data: ");
        id = idScanner.nextLong();
        data = dataScanner.nextLine();
        if ((id != 0) && (data != null)) {
            account.setId(id);
            account.setData(data);
        }
        if (account != null) {
            accountController.saveToAccountRepo(account);
        }
    }

    public void updateAccount() {
        System.out.println("to update account, enter id & new data: ");
        id = idScanner.nextLong();
        data = dataScanner.nextLine();
        if ((id != 0) && (data != null)) {
            account.setId(id);
            account.setData(data);
        }
        if (account != null) {
            accountController.updateToAccountRepo(account);
        }
    }

    public void deleteAccount() {
        System.out.println("to delete account, enter id: ");
        id = idScanner.nextLong();
        if (id != 0) {
            accountController.deleteFromAccountRepo(id);
        }
    }

    public Account getAccountById() throws NoSuchElementException{
        System.out.println("to get account by id, enter id: ");
        id = idScanner.nextLong();
        if (id != 0) {
            account = accountController.getByIdFromAccountRepo(id);
            if (account != null) {
                return account;
            } else {
                throw new NoSuchElementException();
            }
        }
        return null;
    }

    public List<Account> getAll() {
        accountList = accountController.getAll();
        return accountList;
    }
}
