package mvc.repository;

import mvc.model.Skill;

import java.io.IOException;
import java.util.List;

/**
 * Created by Max Hluhov on 14.10.2018.
 */
public interface SkillRepository extends GenericRepository<Skill, Long>{
    public void save(Skill skill) throws IOException;

    public Skill getById(Long id) throws IOException;

    public void update(Skill skill) throws IOException;

    public List<Skill> getAll() throws IOException;

    public void  delete(Long id) throws IOException;
}
