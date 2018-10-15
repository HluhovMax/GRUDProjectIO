package mvc.repository;

import mvc.model.Skill;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Created by Max Hluhov on 14.10.2018.
 */
public class JavaIOSkillRepositoryImpl implements SkillRepository {
    private File file = new File("src\\main\\resources\\files\\skills.txt");
    @Override
    public void save(Skill skill) throws IOException {
        String skills = Long.toString(skill.getID())
                + "." + skill.getName() + "/";
        ArrayList<String> arr = readLines(file);
        arr.add(skills);
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(skills);
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }
    }

    private ArrayList<String> readLines(File filename) throws IOException {
        Path filepath = filename.toPath();
        ArrayList<String> strList = (ArrayList<String>) Files.readAllLines(filepath);
        return strList;
    }

    public boolean delete(String remove) {

        return true;
    }
}
