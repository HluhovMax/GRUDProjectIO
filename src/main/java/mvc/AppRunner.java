package mvc;

import mvc.model.Account;
import mvc.repository.JavaIOAccountRepositoryImpl;

import java.io.IOException;

/**
 * Created by Max Hluhov on 14.10.2018.
 */
public class AppRunner {
    public static void main(String[] args) throws IOException {
        JavaIOAccountRepositoryImpl accR = new JavaIOAccountRepositoryImpl();
        for (int i = 0; i < 4; i++) {
            accR.save(new Account(2L, "changed"));
        }
    }
}
