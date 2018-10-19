package mvc;

import mvc.model.Skill;
import mvc.repository.JavaIOSkillRepositoryImpl;

import java.io.IOException;

/**
 * Created by Max Hluhov on 19.10.2018.
 */
public class MainTest {
    public static void main(String[] args) throws IOException {
        Skill skill = new Skill(3L, "maven");
        JavaIOSkillRepositoryImpl r = new JavaIOSkillRepositoryImpl();
        r.getAll();
    }
}
