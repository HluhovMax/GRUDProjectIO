package mvc.repository;

import mvc.model.Skill;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max Hluhov on 14.10.2018.
 */
public class JavaIOSkillRepositoryImpl implements SkillRepository {
    private File file = new File("src\\main\\resources\\files\\skills.txt");
    @Override
    public void save(Skill skill) throws IOException {
        String skills = Long.toString(skill.getID())+","
                + skill.getName() + "/";
        ArrayList<String> arr = readLines(file);
        arr.add(skills);
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(skills+"\n");
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }
    }

    private ArrayList<String> readLines(File filename) throws IOException {
        Path filepath = filename.toPath();
        ArrayList<String> strList = (ArrayList<String>) Files.readAllLines(filepath);
        return strList;
    }


    public Skill removeById(Long id) {
        Skill skill;
        String fileTostring;
        String[] arr;
        List<String> items = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((fileTostring = reader.readLine()) != null) {
                fileTostring = fileTostring.trim();
                if ((fileTostring.length()) != 0) {
                    items.add(fileTostring);
                }
            }
            arr = items.toArray(new String[items.size()]);
            for (int i = 0; i < arr.length; i++) {
                String[] recordLine = arr[i].split(",");
                Long idi = Long.valueOf(recordLine[0]);
                String name = String.valueOf(recordLine[1]);
                if (id.equals(idi)) {
                    skill = new Skill(idi, name);
                    return skill;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }
}
