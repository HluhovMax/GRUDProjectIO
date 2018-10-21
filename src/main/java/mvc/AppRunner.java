package mvc;

import mvc.repository.JavaIODeveloperRepositoryImpl;

import java.io.IOException;

/**
 * Created by Max Hluhov on 14.10.2018.
 */
public class AppRunner {
    public static void main(String[] args) throws IOException {
        JavaIODeveloperRepositoryImpl devR = new JavaIODeveloperRepositoryImpl();
//        List<Skill> skillList = new ArrayList<>();
//        skillList.add(new Skill(1L, "java"));
//        skillList.add(new Skill(2L, "sql"));
//        skillList.add(new Skill(3L, "maven"));
//        devR.save(new Developer(1L, "Ivan", "Ivanov", "javaDev",
//                skillList, new Account(1L, "data.txt")));
        devR.save(devR.getById(2L));
    }
}
