package mvc;

import mvc.model.Skill;
import mvc.repository.JavaIOSkillRepositoryImpl;

import java.io.IOException;

/**
 * Created by Max Hluhov on 14.10.2018.
 */
public class AppRunner {
    public static void main(String[] args) throws IOException {
        Skill java = new Skill("1)", "java");
        Skill sql = new Skill("2)", "sql");
        Skill cpp = new Skill("3)", "c++");
        Skill javaScript = new Skill("4)", "javaScript");

        JavaIOSkillRepositoryImpl r = new JavaIOSkillRepositoryImpl();
        r.save(java);
        r.save(sql);
        r.save(cpp);
        r.save(javaScript);
    }
}
