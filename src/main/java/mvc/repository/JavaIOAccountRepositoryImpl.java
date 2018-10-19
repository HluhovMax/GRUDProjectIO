package mvc.repository;

import mvc.model.Account;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

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
    public Account delete(Long id) throws IOException {
        return null;
    }

    @Override
    public void update(Account account) throws IOException {

    }

    @Override
    public void getAll() throws IOException {

    }

    @Override
    public Account getById(Long id) throws IOException {
        return null;
    }

    private ArrayList<String> readLines(File filename) throws IOException {
        Path filepath = filename.toPath();
        ArrayList<String> strList = (ArrayList<String>) Files.readAllLines(filepath);
        return strList;
    }
}
