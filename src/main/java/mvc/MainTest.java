package mvc;

import mvc.repository.JavaIOSkillRepositoryImpl;

import java.io.IOException;

/**
 * Created by Max Hluhov on 19.10.2018.
 */
public class MainTest {
    public static void main(String[] args) throws IOException {
        JavaIOSkillRepositoryImpl r = new JavaIOSkillRepositoryImpl();
        r.delete(2L);
    }
}
