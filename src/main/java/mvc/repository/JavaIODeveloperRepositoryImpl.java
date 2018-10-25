package mvc.repository;

import mvc.model.Account;
import mvc.model.Developer;
import mvc.model.Skill;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Max Hluhov on 19.10.2018.
 */
public class JavaIODeveloperRepositoryImpl implements DeveloperRepository {
    private SkillRepository skillRepository;
    private AccountRepository accountRepository;
    public JavaIODeveloperRepositoryImpl() {
        skillRepository = new JavaIOSkillRepositoryImpl();
        accountRepository = new JavaIOAccountRepositoryImpl();
    }

    private File file = new File("src\\main\\resources\\files\\developers.txt");

    /**
     * method for saving Developer entity to file
     * @param developer
     * @throws IOException
     */
    @Override
    public void save(Developer developer) throws IOException {
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
        String developerID = String.valueOf(developer.getId());
        String developerName = developer.getName();
        String developerLastN = developer.getSurName();
        String developerSpecialty = developer.getSpecialty();
        List<String> developerSkillIdList = new ArrayList<>();
        List<Skill> skillList = developer.getSkills();
        for (Skill skill : skillList) {
            developerSkillIdList.add(String.valueOf(skill.getId()));
        }
        StringBuilder sb = new StringBuilder();
        for (String s : developerSkillIdList) {
            sb.append(s + ';');
        }
        String developerSkillID = sb.toString();
        developerSkillID = '{' + developerSkillID + '}';
        Account account = developer.getAccount();
        String developerAccountID = String.valueOf(account.getId());
        String writeDeveloperObjectToFile = developerID + ',' + developerName +
                ',' + developerLastN + ',' + developerSpecialty + ',' +
                developerSkillID + ',' + developerAccountID + '/';
        items.add(writeDeveloperObjectToFile);
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(writeDeveloperObjectToFile + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method for deleting Developer entity from file
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

    /**
     *  method for updating Developer entity in the file
     * @param developer
     * @throws IOException
     */
    @Override
    public void update(Developer developer) throws IOException {
        String fileToString;
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((fileToString = reader.readLine()) != null) {
                fileToString = fileToString.trim();
                if ((fileToString.length()) != 0) {
                    list.add(fileToString);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        String developerID = String.valueOf(developer.getId());
        String developerName = developer.getName();
        String developerLastN = developer.getSurName();
        String developerSpecialty = developer.getSpecialty();
        List<String> developerSkillIdList = new ArrayList<>();
        List<Skill> skillList = developer.getSkills();
        for (Skill skill : skillList) {
            developerSkillIdList.add(String.valueOf(skill.getId()));
        }
        StringBuilder sb = new StringBuilder();
        for (String s : developerSkillIdList) {
            sb.append(s + ';');
        }
        String developerSkillID = sb.toString();
        developerSkillID = '{' + developerSkillID + '}';
        Account account = developer.getAccount();
        String developerAccountID = String.valueOf(account.getId());
        String writeDeveloperObjectToFile = developerID + ',' + developerName +
                ',' + developerLastN + ',' + developerSpecialty + ',' +
                developerSkillID + ',' + developerAccountID + '/';
        String[] listToArray = list.toArray(new String[list.size()]);
        for (int i = 0; i < listToArray.length; i++) {
            String record[] = listToArray[i].split(",");
            Long recordId = Long.valueOf(record[0]);
            if (recordId.equals(developer.getId())) {
                listToArray[i] = writeDeveloperObjectToFile;
            }
        }
        list = new ArrayList<>(Arrays.asList(listToArray));
        try (FileWriter writer = new FileWriter(file)) {
            for (String s : list) {
                writer.write(s + "\n");
            }
        }
    }

    /**
     * method to get all Developer entities from file
     * @return
     * @throws IOException
     */
    @Override
    public List<Developer> getAll() throws IOException {
        Developer developer;
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
        List<Developer> developerList = new ArrayList<>();
        for (String devLine : items) {
            devLine = devLine.trim();
            String[] split = devLine.split(",");
            Long id = Long.valueOf(split[0]);
            String name = split[1];
            String surName = split[2];
            String specialty = split[3];
            split[4] = split[4].substring(1, split[4].length() - 1);
            String[] arr = split[4].split(";");
            List<Skill> skillList = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                Long skillID = Long.valueOf(arr[i]);
                Skill skill = skillRepository.getById(skillID);
                String s = skill.getName().substring(0, skill.getName()
                        .length() - 1);
                skill.setName(s);
                skillList.add(skill);
            }
            split[5] = split[5].substring(0, split[5].length() - 1);
            Long accountID = Long.valueOf(split[5]);
            Account account = accountRepository.getById(accountID);
            String s = account.getData().substring(0, account.getData()
                    .length() - 1);
            account.setData(s);
            developer = new Developer(id, name, surName, specialty,
                    skillList, account);
            developerList.add(developer);
        }
        return developerList;
    }

    /**
     * method for getting by id Developer entity from file
     * @param id
     * @return
     * @throws IOException
     */
    @Override
    public Developer getById(Long id) throws IOException {
        Developer developer;
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
        List<Skill> skillList = new ArrayList<>();
        for (String lineOfdevelopers : items) {
            lineOfdevelopers = lineOfdevelopers.trim();
            String[] mass = lineOfdevelopers.split(",");
            Long idi = Long.valueOf(mass[0]);
            if (id.equals(idi)) {
                String name = mass[1];
                String surName = mass[2];
                String specialty = mass[3];
                mass[4] = mass[4].substring(1, mass[4].length() - 1);
                String[] arr = mass[4].split(";");
                for (int i = 0; i < arr.length; i++) {
                    Long skillID = Long.valueOf(arr[i]);
                    Skill skill = skillRepository.getById(skillID);
                    String s = skill.getName().substring(0, skill.getName()
                            .length() - 1);
                    skill.setName(s);
                    skillList.add(skill);
                }
                mass[5] = mass[5].substring(0, mass[5].length() - 1);
                Long accountID = Long.valueOf(mass[5]);
                Account account = accountRepository.getById(accountID);
                String s = account.getData().substring(0, account.getData()
                        .length() - 1);
                account.setData(s);
                developer = new Developer(id, name, surName, specialty,
                        skillList, account);
                return developer;
            }
        }
        return null;
    }
}
