package mvc.repository;

import mvc.model.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Max Hluhov on 19.10.2018.
 */
public class JavaIOAccountRepositoryImpl implements AccountRepository {

    private File file = new File("src\\main\\resources\\files\\accounts.txt");

    /**
     * method for saving Account entity to file
     * @param account
     * @throws IOException
     */
    @Override
    public void save(Account account) throws IOException {
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
        String accountID = String.valueOf(account.getId());
        String accountData = account.getData();
        String accountToSave = accountID + "," + accountData + "/";
        items.add(accountToSave);
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(accountToSave + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method for deleting Account entity from file
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
     * method for updating Account entity in the file
     * @param account
     * @throws IOException
     */
    @Override
    public void update(Account account) throws IOException {
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
                if (account.getId().equals(recordId)) {
                    record[1] = account.getData() + '/';// update point
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
     * method to get all Account entities from file
     * @return
     * @throws IOException
     */
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
            s = s.trim();
            String[] mass = s.split(",");
            Long id = Long.valueOf(mass[0]);
            String data = mass[1];
            StringBuilder sb = new StringBuilder(data);
            sb.deleteCharAt(data.length() - 1);
            data = sb.toString();
            list.add(new Account(id, data));
        }
        return list;
    }

    /**
     * method for getting by id Account entity from file
     * @param id
     * @return
     * @throws IOException
     */
    @Override
    public Account getById(Long id) throws IOException {
        Account account;
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
}
