package mvc.repository;

import mvc.model.Account;
import mvc.model.Developer;
import mvc.model.Skill;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Max Hluhov on 19.10.2018.
 */
public class JavaIODeveloperRepositoryImpl implements DeveloperRepository {

    private File file = new File("src\\main\\resources\\files\\developers.txt");

    @Override
    public void save(Developer developer) throws IOException {
        String skil = developer.toString();
        ArrayList<String> arr = readLines(file);
        arr.add(skil);
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(skil + "\n");
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }
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

    @Override
    public void update(Developer developer) throws IOException {
        Long id = developer.getId();
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
                if (id.equals(recordId)) {
                    arr[i] = developer.toString();
                }
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
    public List<Developer> getAll() throws IOException {
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
        List<Skill> skillList = new ArrayList<>();
        for (String devLine : items) {
            devLine = devLine.trim();
            String[] mass = devLine.split(",");
            Long id = Long.valueOf(mass[0]);
            String name = mass[1];
            String surName = mass[2];
            String specialty = mass[3];
            mass[4] = mass[4].substring(2, mass[4].length() - 1);
            String[] arr = mass[4].split(";");
            for (int i = 0; i < arr.length; i++) {
                String[] array = arr[i].split("-");
                Long idi = Long.valueOf(array[0]);
                skillList.add(new Skill(idi, array[1]));
            }
            Account account = new Account(0L, "");
            mass[5] = mass[5].trim();
            String[] a = mass[5].split("-");
            for (int i = 0; i < a.length; i++) {
                Long idi = Long.valueOf(a[0]);
                account = new Account(idi, a[1]);
            }
            developerList.add(new Developer(id, name, surName, specialty, skillList, account));
        }
        return developerList;
    }

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
        for (String devLine : items) {
            devLine = devLine.trim();
            String[] mass = devLine.split(",");
            Long idi = Long.valueOf(mass[0]);
            if (id.equals(idi)) {
                String name = mass[1];
                String surName = mass[2];
                String specialty = mass[3];
                mass[4] = mass[4].substring(2, mass[4].length() - 1);
                String[] arr = mass[4].split(";");
                for (int i = 0; i < arr.length; i++) {
                    String[] array = arr[i].split("-");
                    Long skId = Long.valueOf(array[0]);
                    StringBuilder sb = new StringBuilder(array[1]);
                    sb.deleteCharAt(array[1].length() - 1);
                    array[1] = sb.toString();
                    skillList.add(new Skill(skId, array[1]));
                }
                Account account;
                mass[5] = mass[5].trim();
                String[] a = mass[5].split("-");
                Long accId = Long.valueOf(a[0]);
                StringBuilder sb = new StringBuilder(a[1]);
                sb.deleteCharAt(a[1].length() - 1);
                a[1] = sb.toString();
                account = new Account(accId, a[1]);
                developer = new Developer(id, name, surName, specialty, skillList, account);
                return developer;
            }
        }
        return null;
    }

    private ArrayList<String> readLines(File filename) throws IOException {
        Path filepath = filename.toPath();
        ArrayList<String> strList = (ArrayList<String>) Files.readAllLines(filepath);
        return strList;
    }
}
