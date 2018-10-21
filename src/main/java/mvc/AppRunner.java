package mvc;

import mvc.model.Skill;
import mvc.repository.JavaIOSkillRepositoryImpl;

import java.io.IOException;
import java.util.List;

/**
 * Created by Max Hluhov on 14.10.2018.
 */
public class AppRunner {
    public static void main(String[] args) throws IOException {
        JavaIOSkillRepositoryImpl skillR = new JavaIOSkillRepositoryImpl();
        List<Skill> list = skillR.getAll();
        list.remove(1);
        System.out.println(list);
    }
}
