package mvc.repository;

import mvc.model.Skill;

import java.io.*;

/**
 * Created by Max Hluhov on 14.10.2018.
 */
public class JavaIOSkillRepositoryImpl implements SkillRepository {
    @Override
    public void save(Skill skill) throws IOException {
        String id = Long.toString(skill.getID());
        String name = skill.getName();
        String skills = id + name;
        File file = new File("src\\main\\resources\\files\\skills.txt");
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(skills + "\n");
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }
    }
}
