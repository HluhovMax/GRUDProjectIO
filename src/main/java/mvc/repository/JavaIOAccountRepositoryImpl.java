package mvc.repository;

import mvc.model.Account;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Max Hluhov on 19.10.2018.
 */
public class JavaIOAccountRepositoryImpl implements AccountRepository {

    private File file = new File("src\\main\\resources\\files\\accounts.txt");
    
    @Override
    public void save(Account account) throws IOException {
        String accountLine = account.toString();
        ArrayList<String> list = readLines(file);
        list.add(accountLine);
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(accountLine + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
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
    public void update(Account account) throws IOException {
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
                if (account.getId().equals(recordId)) {
                    record[1] = account.getData() + '/';// update point
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
    public List<Account> getAll() throws IOException {
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
        List<Account> list = new ArrayList<>();
        for (String s : items) {
            String[] mass = s.split(",");
            Long id = Long.valueOf(mass[0]);
            String data = mass[1];
            list.add(new Account(id, data));
        }
        return list;
    }

    @Override
    public Account getById(Long id) throws IOException {
        Account account;
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
                    account = new Account(idi, name);
                    return account;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    private ArrayList<String> readLines(File filename) throws IOException {
        Path filepath = filename.toPath();
        ArrayList<String> strList = (ArrayList<String>) Files.readAllLines(filepath);
        return strList;
    }
}
