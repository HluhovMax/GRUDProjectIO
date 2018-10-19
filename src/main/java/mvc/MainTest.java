package mvc;

import mvc.model.Account;
import mvc.model.Developer;
import mvc.model.Skill;
import mvc.repository.JavaIODeveloperRepositoryImpl;
import mvc.repository.JavaIOSkillRepositoryImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max Hluhov on 19.10.2018.
 */
public class MainTest {
    public static void main(String[] args) throws IOException {
        JavaIODeveloperRepositoryImpl devR = new JavaIODeveloperRepositoryImpl();
        JavaIOSkillRepositoryImpl skR = new JavaIOSkillRepositoryImpl();
        List<Skill> skillSet = new ArrayList<>();
        skillSet.add(skR.getById(1L));
        skillSet.add(skR.getById(2L));
        skillSet.add(skR.getById(3L));
        skillSet.add(skR.getById(4L));
        skillSet.add(skR.getById(5L));

        devR.update(new Developer(1002L, "Ivan", "Ivanov", "javaDev"
                , skillSet, new Account(1002L, "someData.txt")));
    }
}
