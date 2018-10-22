package mvc.repository;

import mvc.model.Skill;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Max Hluhov on 14.10.2018.
 */
public class JavaIOSkillRepositoryImpl implements SkillRepository {

    private File file = new File("src\\main\\resources\\files\\skills.txt");

    @Override
    public void save(Skill skill) throws IOException {
        String fileTostring;
        List<String> items = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((fileTostring = reader.readLine()) != null) {
                fileTostring = fileTostring.trim();
                if ((fileTostring.length()) != 0) {
                    items.add(fileTostring);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        String skillId = String.valueOf(skill.getId());
        String skillName = skill.getName();
        String skillToSave = skillId + "," + skillName + "/";
        items.add(skillToSave);
        try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(skillToSave + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Skill getById(Long id) {
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
        } catch (IOException e) {
            System.out.println(e);
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
        return null;
    }

    public void update(Skill skill) {
        String fileToString;
        String arr[];
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((fileToString = reader.readLine()) != null) {
                fileToString = fileToString.trim();
                if ((fileToString.length()) != 0) {
                    list.add(fileToString);
                }
            }
            arr = list.toArray(new String[list.size()]);
            for (int i = 0; i < arr.length; i++) {
                String record[] = arr[i].split(",");
                Long recordId = Long.valueOf(record[0]);
                if (skill.getId().equals(recordId)) {
                    record[1] = skill.getName() + '/';
                    arr[i] = Arrays.toString(record);
                    arr[i] = arr[i].substring(1, arr[i].length() - 1);
                }
                arr[i] = arr[i].replaceAll("\\s+", "");
            }
            list = new ArrayList<>(Arrays.asList(arr));
            try (FileWriter writer = new FileWriter(file)) {
                for (String s : list) {
                    writer.write(s + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Skill> getAll() throws IOException {
        String fileTostring;
        List<String> items = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((fileTostring = reader.readLine()) != null) {
                fileTostring = fileTostring.trim();
                if ((fileTostring.length()) != 0) {
                    items.add(fileTostring);
                }
            }
        }
        List<Skill> skillList = new ArrayList<>();
        for (String line : items) {
            String[] mass = line.split(",");
            Long id = Long.valueOf(mass[0]);
            String name = mass[1];
            skillList.add(new Skill(id, name));
        }
        return skillList;
    }

    @Override
    public void delete(Long id) throws IOException {
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
                if (id.equals(idi)) {
                    recordLine[0] = "";
                    recordLine[1] = "";
                    arr[i] = Arrays.toString(recordLine);
                    arr[i] = "removed";
                }//correct work
            }
            List<String> list = new ArrayList<>(Arrays.asList(arr));
            list.remove("removed");
            try (FileWriter writer = new FileWriter(file)) {
                for (String s : list) {
                    writer.write(s + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

