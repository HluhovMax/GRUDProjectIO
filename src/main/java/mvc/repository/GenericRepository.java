package mvc.repository;

import java.io.IOException;
import java.util.List;

/**
 * Created by Max Hluhov on 25.10.2018.
 */
public interface GenericRepository<T, ID> {
    public void save(T t) throws IOException;

    public T getById(ID id)throws IOException;

    public void update(T t)throws IOException;

    public List<T> getAll()throws IOException;

    public void delete(ID id)throws IOException;
}
