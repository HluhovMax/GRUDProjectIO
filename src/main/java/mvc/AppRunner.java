package mvc;

import mvc.model.Account;
import mvc.model.Developer;
import mvc.model.Skill;
import mvc.repository.JavaIOAccountRepositoryImpl;
import mvc.repository.JavaIODeveloperRepositoryImpl;
import mvc.repository.JavaIOSkillRepositoryImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 1.java/2.css/3.html/4.c++/
 * Created by Max Hluhov on 14.10.2018.
 */
public class AppRunner {
    public static void main(String[] args) throws IOException {
        //Runner.run();
        JavaIOSkillRepositoryImpl r = new JavaIOSkillRepositoryImpl();
        List<Skill> skills = new ArrayList<>();
        skills.add(r.getById(1l));
        skills.add(r.getById(2l));
        skills.add(r.getById(3l));
        Developer developer = new Developer();
        developer.setName("Ivan");
        developer.setSurName("Ivanov");
        developer.setId(1l);
        developer.setSkills(skills);
        JavaIODeveloperRepositoryImpl devR = new JavaIODeveloperRepositoryImpl();
        //devR.save(developer);
        Developer developer1 = new Developer(2l, "Petro","Sydorov", skills);
        Account account = new Account(1l, developer);
        Account account2 = new Account(2l, developer1);
        JavaIOAccountRepositoryImpl accountRepository = new JavaIOAccountRepositoryImpl();
        accountRepository.save(account);
        accountRepository.save(account2);
    }
}
