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

    /**
     * method for saving Skill entity to file
     * @param skill
     * @throws IOException
     */
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

    /**
     * method for getting by id Skill entity from file
     * @param id
     * @return
     */
    public Skill getById(Long id) {
        Skill skill;
        String fileTostring;
        String[] arrayOfItems;
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
        arrayOfItems = items.toArray(new String[items.size()]);
        for (int i = 0; i < arrayOfItems.length; i++) {
            String[] recordLine = arrayOfItems[i].split(",");
            Long idi = Long.valueOf(recordLine[0]);
            String name = String.valueOf(recordLine[1]);
            if (id.equals(idi)) {
                skill = new Skill(idi, name);
                return skill;
            }
        }
        return null;
    }

    /**
     * method for updating Skill entity in the file
     * @param skill
     */
    public void update(Skill skill) {
        String fileToString;
        String arrayOfItems[];
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((fileToString = reader.readLine()) != null) {
                fileToString = fileToString.trim();
                if ((fileToString.length()) != 0) {
                    list.add(fileToString);
                }
            }
            arrayOfItems = list.toArray(new String[list.size()]);
            for (int i = 0; i < arrayOfItems.length; i++) {
                String record[] = arrayOfItems[i].split(",");
                Long recordId = Long.valueOf(record[0]);
                if (skill.getId().equals(recordId)) {
                    record[1] = skill.getName() + '/';
                    arrayOfItems[i] = Arrays.toString(record);
                    arrayOfItems[i] = arrayOfItems[i].substring(1, arrayOfItems[i].length() - 1);
                }
                arrayOfItems[i] = arrayOfItems[i].replaceAll("\\s+", "");
            }
            list = new ArrayList<>(Arrays.asList(arrayOfItems));
            try (FileWriter writer = new FileWriter(file)) {
                for (String s : list) {
                    writer.write(s + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to get all Skill entities from file
     * @return
     * @throws IOException
     */
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
            String[] split = line.split(",");
            Long id = Long.valueOf(split[0]);
            String name = split[1];
            skillList.add(new Skill(id, name));
        }
        return skillList;
    }

    /**
     * method for deleting Skill entity from file
     * @param id
     * @throws IOException
     */
    @Override
    public void delete(Long id) throws IOException {
        String fileTostring;
        String[] arrayOfItems;
        List<String> items = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((fileTostring = reader.readLine()) != null) {
                fileTostring = fileTostring.trim();
                if ((fileTostring.length()) != 0) {
                    items.add(fileTostring);
                }
            }
            arrayOfItems = items.toArray(new String[items.size()]);
            for (int i = 0; i < arrayOfItems.length; i++) {
                String[] recordLine = arrayOfItems[i].split(",");
                Long idi = Long.valueOf(recordLine[0]);
                if (id.equals(idi)) {
                    recordLine[0] = "";
                    recordLine[1] = "";
                    arrayOfItems[i] = Arrays.toString(recordLine);
                    arrayOfItems[i] = "removed";
                }
            }
            List<String> list = new ArrayList<>(Arrays.asList(arrayOfItems));
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

