package mvc.repository;

import mvc.model.Account;

import java.io.IOException;
import java.util.List;

/**
 * Created by Max Hluhov on 19.10.2018.
 */
public interface AccountRepository extends GenericRepository<Account, Long>{
    public void save(Account account) throws IOException;

    public void delete(Long id) throws IOException;

    public void update(Account account) throws IOException;

    public List<Account> getAll() throws IOException;

    public Account getById(Long id) throws IOException;
}
