package mvc;

import mvc.model.Skill;
import mvc.repository.JavaIOSkillRepositoryImpl;

import java.io.IOException;

/**
 * Created by Max Hluhov on 14.10.2018.
 */
public class AppRunner {
    public static void main(String[] args) throws IOException {
        Skill java = new Skill(1l, "java");
        Skill sql = new Skill(2l, "sql");
        Skill cpp = new Skill(3l, "c++");
        Skill javaScript = new Skill(4l, "javaScript");git

        JavaIOSkillRepositoryImpl r = new JavaIOSkillRepositoryImpl();
        r.save(java);
        r.save(sql);
        r.save(cpp);
        r.save(javaScript);
    }
}
