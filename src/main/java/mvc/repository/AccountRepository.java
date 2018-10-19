package mvc.repository;

import mvc.model.Account;

import java.io.IOException;

/**
 * Created by Max Hluhov on 19.10.2018.
 */
public interface AccountRepository {
    public void save(Account account) throws IOException;

    public Account delete(Long id) throws IOException;

    public void update(Account account) throws IOException;

    public void getAll() throws IOException;

    public Account getById(Long id) throws IOException;
}
