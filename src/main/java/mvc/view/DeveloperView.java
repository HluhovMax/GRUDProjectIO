package mvc.view;

import mvc.controller.DeveloperController;
import mvc.model.Account;
import mvc.model.Developer;
import mvc.model.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Max Hluhov on 23.10.2018.
 */
public class DeveloperView {
    private Long id;
    private String name;
    private String lastName;
    private String specialty;
    private List<Skill> skillList;
    private List<Developer> developerList;
    private DeveloperController developerController;
    private Scanner numScanner;
    private Scanner stringScanner;
    private Developer developer;
    private Skill skill;
    private Account account;
    private SkillView skillView;
    private AccountView accountView;

    public DeveloperView() {
        skillList = new ArrayList<>();
        developerList = new ArrayList<>();
        developerController = new DeveloperController();
        numScanner = new Scanner(System.in);
        stringScanner = new Scanner(System.in);
        developer = new Developer();
        skill = new Skill();
        skillView = new SkillView();
        accountView = new AccountView();
        account = new Account();
    }

    public void saveDeveloper() {
        System.out.println("to save developer, enter id," +
                " name, lastName, specialty, skills, account: ");
        id = numScanner.nextLong();
        name = stringScanner.nextLine();
        lastName = stringScanner.nextLine();
        specialty = stringScanner.nextLine();
        System.out.println("how many skills do you want to add: ");
        int num = numScanner.nextInt();
        switch (num) {
            case 1:
                skill = skillView.getSkillById();
                skillList.add(skill);
                break;
            case 2:
                for (int i = 0; i < 2; i++) {
                    skill = skillView.getSkillById();
                    skillList.add(skill);
                }
                break;
            case 3:
                for (int i = 0; i < 3; i++) {
                    skill = skillView.getSkillById();
                    skillList.add(skill);
                }
                break;
            case 4:
                for (int i = 0; i < 4; i++) {
                    skill = skillView.getSkillById();
                    skillList.add(skill);
                }
                break;
            case 5:
                for (int i = 0; i < 5; i++) {
                    skill = skillView.getSkillById();
                    skillList.add(skill);
                }
                break;
            default:
                System.out.println("Error!");
                break;
        }
        account = accountView.getAccountById();
        if ((id != 0) && (name != null) && (lastName != null) &&
                (specialty != null) &&
                (skillList != null) &&
                (account != null)) {
            developer.setId(id);
            developer.setName(name);
            developer.setSurName(lastName);
            developer.setSpecialty(specialty);
            developer.setSkills(skillList);
            developer.setAccount(account);
        }
        if (developer != null) {
            developerController.saveToDeveloperRepo(developer);
        }
    }

    public void updateDeveloper() {// при использовании метода update,
    // в файл пишутся не только id скилов, но и полные сведения о них.
        System.out.println("to update developer, enter id & newInfo: ");
        id = numScanner.nextLong();
        name = stringScanner.nextLine();
        lastName = stringScanner.nextLine();
        specialty = stringScanner.nextLine();
        System.out.println("how many skills do you want to add: ");
        int num = numScanner.nextInt();
        switch (num) {
            case 1:
                skill = skillView.getSkillById();
                skillList.add(skill);
                break;
            case 2:
                for (int i = 0; i < 2; i++) {
                    skill = skillView.getSkillById();
                    skillList.add(skill);
                }
                break;
            case 3:
                for (int i = 0; i < 3; i++) {
                    skill = skillView.getSkillById();
                    skillList.add(skill);
                }
                break;
            case 4:
                for (int i = 0; i < 4; i++) {
                    skill = skillView.getSkillById();
                    skillList.add(skill);
                }
                break;
            case 5:
                for (int i = 0; i < 5; i++) {
                    skill = skillView.getSkillById();
                    skillList.add(skill);
                }
                break;
            default:
                System.out.println("Error!");
                break;
        }
        account = accountView.getAccountById();
        if ((id != 0) && (name != null) && (lastName != null) &&
                (specialty != null) &&
                (skillList != null) &&
                (account != null)) {
            developer.setId(id);
            developer.setName(name);
            developer.setSurName(lastName);
            developer.setSpecialty(specialty);
            developer.setSkills(skillList);
            developer.setAccount(account);
        }
        if (developer!=null) {
            developerController.updateToDeveloperRepo(developer);
        }
    }

    public void deleteDeveloper() {
        System.out.println("to delete developer, enter id: ");
        id = numScanner.nextLong();
        if (id != 0) {
            developerController.deleteFromDeveloperRepo(id);
        }
    }

    public Developer getDeveloperById() {
        System.out.println("to get developer by id, enter id: ");
        id = numScanner.nextLong();
        if (id != 0) {
            developer = developerController.getByIdFromDeveloperRepo(id);
            return developer;
        }
        return null;
    }

    public List<Developer> getAll() {
        developerList = developerController.getAll();
        return developerList;
    }
}
