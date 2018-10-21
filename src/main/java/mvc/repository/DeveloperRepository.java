package mvc.repository;

import mvc.model.Developer;

import java.io.IOException;
import java.util.List;

/**
 * Created by Max Hluhov on 19.10.2018.
 */
public interface DeveloperRepository {
    public void save(Developer developer) throws IOException;

    public void delete(Long id) throws IOException;

    public void update(Developer developer) throws IOException;

    public List<Developer> getAll() throws IOException;

    public Developer getById(Long id) throws IOException;
}
