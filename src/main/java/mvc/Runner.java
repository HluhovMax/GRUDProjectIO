package mvc;

import mvc.model.Skill;
import mvc.repository.JavaIOSkillRepositoryImpl;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Max Hluhov on 15.10.2018.
 */
public class Runner {
    public static void run() throws IOException {
        System.out.println("Enter 1: for OneTimeAdding | 2: for manyTimeAdding | 3: for delete | 4: for update");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        switch (i) {
            case 1:
                oneTimeAddingSkill();
                break;
            case 2:
                System.out.println("How many skills?: ");
                int k = sc.nextInt();
                howManySkillsDoYouWantToAdd(k);
                break;
            case 3:
                remove();
                break;
            case 4:
                upToDate();
                break;
            default:
                System.out.println("Another time");
                break;
        }
    }
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
        r.delete(id);
        System.out.println("Entered skill has been deleted.");
    }

    public static void upToDate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id: ");
        Long id = sc.nextLong();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = s.nextLine();
        Skill skill = new Skill(id, name);
        JavaIOSkillRepositoryImpl r = new JavaIOSkillRepositoryImpl();
        r.update(skill);
    }

}
