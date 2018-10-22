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
 * Created by Max Hluhov on 14.10.2018.
 */
public class AppRunner {
    public static void main(String[] args) throws IOException {
        JavaIOSkillRepositoryImpl skillRepository = new JavaIOSkillRepositoryImpl();

        Skill firstSkill = skillRepository.getById(1l);
        Skill secondSkill = skillRepository.getById(2l);
        Skill thirdSkill = skillRepository.getById(3l);
        List<Skill> skillList = new ArrayList<>();
        skillList.add(firstSkill);
        skillList.add(secondSkill);
        skillList.add(thirdSkill);
        JavaIOAccountRepositoryImpl accountRepository = new JavaIOAccountRepositoryImpl();
        Account account = accountRepository.getById(1L);
        Developer developer = new Developer(1001L, "Name", "SurName",
                "Java Developer", skillList, account);
        JavaIODeveloperRepositoryImpl developerRepository = new JavaIODeveloperRepositoryImpl();
        List<Developer> developerList = developerRepository.getAll();
        for (Developer d : developerList) {
            System.out.println(d.toString());
        }
        //System.out.println(developerRepository.getById(1001L));
        /*
        JavaIOSkillRepositoryImpl skillRepository = new JavaIOSkillRepositoryImpl();
        skillRepository.update(new Skill(3L, "NoSQL"));
        JavaIOAccountRepositoryImpl accountRepository = new JavaIOAccountRepositoryImpl();
        accountRepository.save(new Account(1L, "data.txt"));
        */

    }
}
