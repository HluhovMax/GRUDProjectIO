package mvc;

import mvc.model.Account;
import mvc.model.Developer;
import mvc.model.Skill;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 * 1.java/2.css/3.html/4.c++/
 * Created by Max Hluhov on 14.10.2018.
 */
public class AppRunner {
    public static void main(String[] args) throws IOException {
        //Runner.run();
        Set<Skill> skills = new TreeSet<>();
        skills.add(new Skill(1l, "java"));
        Developer developer = new Developer();
        developer.setName("Ivan");
        developer.setSurName("Ivanov");
        developer.setId(1l);
        developer.setSkills(skills);
        Account account = new Account(1l, developer);
        System.out.println(account.toString());
    }
}
