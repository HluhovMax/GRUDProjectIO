package mvc.repository;

import mvc.model.Skill;

import java.io.IOException;

/**
 * Created by Max Hluhov on 14.10.2018.
 */
public interface SkillRepository {
    public void save(Skill skill) throws IOException;

    public Skill getById(Long id) throws IOException;

    public void update(Skill skill) throws IOException;

    public void getAll() throws IOException;

    public void  delete(Long id) throws IOException;
}
