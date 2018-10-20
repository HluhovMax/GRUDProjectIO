package mvc;

import mvc.repository.JavaIODeveloperRepositoryImpl;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Max Hluhov on 19.10.2018.
 */
public class MainTest {
    public static void main(String[] args) throws IOException {
        JavaIODeveloperRepositoryImpl devR = new JavaIODeveloperRepositoryImpl();
        ArrayList<String> list = new ArrayList<>();
        list.add(devR.getById(1003L));
        list.add(devR.getById(1004L));

        for (String s : list) {
            System.out.println(s);
        }
    }
}
