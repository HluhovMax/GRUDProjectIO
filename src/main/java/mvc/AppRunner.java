package mvc;

import mvc.repository.JavaIOSkillRepositoryImpl;

import java.io.IOException;

/**
 * 1.java/2.css/3.html/4.c++/
 * Created by Max Hluhov on 14.10.2018.
 */
public class AppRunner {
    public static void main(String[] args) throws IOException {
        JavaIOSkillRepositoryImpl r = new JavaIOSkillRepositoryImpl();
        r.delete("2.css/");
    }
}
