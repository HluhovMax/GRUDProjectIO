package mvc.repository;

import mvc.model.Account;
import mvc.model.Skill;

import java.io.IOException;

/**
 * Created by Max Hluhov on 19.10.2018.
 */
public interface AccountRepository {
    public void save(Account account) throws IOException;

    public Skill delete(Long id) throws IOException;

    public void update(Account account) throws IOException;

    public void getAll() throws IOException;
}
