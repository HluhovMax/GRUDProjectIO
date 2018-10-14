package mvc.repository;

import mvc.model.Skill;

import java.io.*;

/**
 * Created by Max Hluhov on 14.10.2018.
 */
public class JavaIOSkillRepositoryImpl implements SkillRepository {
    @Override
    public void save(Skill skill) throws IOException {
        String ID = skill.getID();
        String name = skill.getName();
        byte[] buff = name.getBytes();
        byte[] idBuff = ID.getBytes();
        File file = new File("src\\main\\resources\\files\\skills.txt");
        try (FileOutputStream outputStream =
                     new FileOutputStream(file)) {
            outputStream.write(idBuff);
            outputStream.write(buff);
            File file1 = new File("src\\main\\resources\\files\\fileSaver.txt");
            FileOutputStream fos =
                         new FileOutputStream(file1);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(file);

        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }
    }
}
