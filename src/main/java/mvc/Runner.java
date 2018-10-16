package mvc;

import mvc.model.Skill;
import mvc.repository.JavaIOSkillRepositoryImpl;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Max Hluhov on 15.10.2018.
 */
public class Runner {
    public static void oneTimeAddingSkill() throws IOException {
        System.out.println("Enter id: ");
        Scanner sc = new Scanner(System.in);
        long id = sc.nextLong();
        System.out.println("Enter skill: ");
        Scanner skillScanner = new Scanner(System.in);
        String name = skillScanner.nextLine();
        Skill skill = new Skill(id, name);
        JavaIOSkillRepositoryImpl r = new JavaIOSkillRepositoryImpl();
        r.save(skill);
    }

    public static void howManySkillsDoYouWantToAdd(int n) throws IOException {
        for (int i = 0; i < n; i++) {
            oneTimeAddingSkill();
        }
    }

    public static void remove() throws IOException {
        System.out.println("Enter 'id' to remove skill: ");
        Scanner sc = new Scanner(System.in);
        Long id = sc.nextLong();
        JavaIOSkillRepositoryImpl r = new JavaIOSkillRepositoryImpl();
        r.removeById(id);
        System.out.println("Entered skill has been deleted.");
    }


}
