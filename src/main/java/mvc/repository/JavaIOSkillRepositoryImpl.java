package mvc.repository;

import mvc.model.Skill;

import java.io.*;

/**
 * Created by Max Hluhov on 14.10.2018.
 */
public class JavaIOSkillRepositoryImpl implements SkillRepository {
    @Override
    public void save(Skill skill) throws IOException {
        File file = new File("src\\main\\resources\\files\\skills.txt");
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(skill.getID());
            fw.write(skill.getName() + "\n");
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }
    }
}
