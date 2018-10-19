package mvc.repository;

import mvc.model.Developer;
import mvc.model.Skill;

import java.io.IOException;

/**
 * Created by Max Hluhov on 19.10.2018.
 */
public interface DeveloperRepository {
    public void save(Developer developer) throws IOException;

    public Skill delete(Long id) throws IOException;

    public void update(Developer developer) throws IOException;

    public void getAll() throws IOException;
}
