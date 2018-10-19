package mvc.repository;

import mvc.model.Developer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Created by Max Hluhov on 19.10.2018.
 */
public class JavaIODeveloperRepositoryImpl implements DeveloperRepository {

    private File file = new File("src\\main\\resources\\files\\developers.txt");

    @Override
    public void save(Developer developer) throws IOException {
        String devLine = developer.toString();
        ArrayList<String> list = readLines(file);
        list.add(devLine);
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(devLine + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Developer delete(Long id) throws IOException {
        return null;
    }

    @Override
    public void update(Developer developer) throws IOException {

    }

    @Override
    public void getAll() throws IOException {

    }

    @Override
    public Developer getById(Long id) throws IOException {
        return null;
    }

    private ArrayList<String> readLines(File filename) throws IOException {
        Path filepath = filename.toPath();
        ArrayList<String> strList = (ArrayList<String>) Files.readAllLines(filepath);
        return strList;
    }
}
