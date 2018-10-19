package mvc.repository;

import mvc.model.Developer;

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
                String name = String.valueOf(recordLine[1]);
                if (id.equals(idi)) {
                    recordLine[0] = "";
                    recordLine[1] = "";
                }//correct work
                arr[i] = Arrays.toString(recordLine);
            }
            try (FileWriter wr = new FileWriter(file)) {
                wr.write("");
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i].substring(1, arr[i].length() - 1);
                try (FileWriter writer = new FileWriter(file, true)) {
                    writer.write(arr[i] + "\n");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }catch(IOException e){
            System.out.println(e);
        }
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
