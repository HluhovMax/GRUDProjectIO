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
        String skil = developer .toString();
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
    public void getAll() throws IOException {
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
        if (items != null) {
            for (String s : items) {
                System.out.println(s);
            }
        } else System.out.println("File is empty!");
    }

    @Override
    public String getById(Long id) throws IOException {
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
                String line = arr[i].replaceFirst(",", ":");
                String[] recordLine = line.split(":");
                Long idi = Long.valueOf(recordLine[0]);
                if (id.equals(idi)) {
                    String dev = arr[i];
                    return dev;
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
