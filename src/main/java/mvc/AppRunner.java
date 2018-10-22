package mvc;

import mvc.model.Account;
import mvc.model.Developer;
import mvc.model.Skill;
import mvc.repository.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Max Hluhov on 14.10.2018.
 */
public class AppRunner {
    public static void main(String[] args) throws IOException {
        DeveloperRepository developerRepository = new JavaIODeveloperRepositoryImpl();
        SkillRepository skillRepository = new JavaIOSkillRepositoryImpl();
        List<Skill> skillList;
        AccountRepository accountRepository = new JavaIOAccountRepositoryImpl();
        Account account = accountRepository.getById(2L);
        skillList = new LinkedList<>();
        skillList.add(skillRepository.getById(4l));
        skillList.add(skillRepository.getById(5l));
        skillList.add(skillRepository.getById(6l));
        developerRepository.save(new Developer(1999987L,
                "Iv", "La", "Front-end", skillList, account));
        }
}
