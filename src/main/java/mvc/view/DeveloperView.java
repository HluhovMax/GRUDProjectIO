package mvc.view;

import mvc.controller.DeveloperController;
import mvc.exception.NoSuchElementException;
import mvc.model.Account;
import mvc.model.Developer;
import mvc.model.Skill;
import mvc.repository.JavaIOSkillRepositoryImpl;
import mvc.repository.SkillRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Max Hluhov on 23.10.2018.
 */
public class DeveloperView {
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
        Long id;
        String name;
        String lastName;
        String specialty;
        List<Skill> skillList = new ArrayList<>();
        System.out.println("to save developer, enter id," +
                " name, lastName, specialty, skills, account: ");
        id = numScanner.nextLong();
        name = stringScanner.nextLine();
        lastName = stringScanner.nextLine();
        specialty = stringScanner.nextLine();
        System.out.println("which skills do you want to add: ");
        System.out.println(skillView.getAll());
        String skillString = stringScanner.nextLine();
        String[] skillStringArray = skillString.split(",");
        SkillRepository sr = new JavaIOSkillRepositoryImpl();
        for (String s : skillStringArray) {
            Long skillID = Long.valueOf(s);
            try {
                skill = sr.getById(skillID);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            skillList.add(skill);
        }
        try {
            account = accountView.getAccountById();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
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

    public void updateDeveloper() {
        Long id;
        String name;
        String lastName;
        String specialty;
        List<Skill> skillList = new ArrayList<>();
        System.out.println("to update developer, enter id & newInfo: ");
        id = numScanner.nextLong();
        name = stringScanner.nextLine();
        lastName = stringScanner.nextLine();
        specialty = stringScanner.nextLine();
        System.out.println("which skills do you want to add: ");
        System.out.println(skillView.getAll());
        String skillString = stringScanner.nextLine();
        String[] skillStringArray = skillString.split(",");
        SkillRepository sr = new JavaIOSkillRepositoryImpl();
        for (String s : skillStringArray) {
            Long skillID = Long.valueOf(s);
            try {
                skill = sr.getById(skillID);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            skillList.add(skill);
        }
        try {
            account = accountView.getAccountById();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
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
        Long id = numScanner.nextLong();
        if (id != 0) {
            developerController.deleteFromDeveloperRepo(id);
        }
    }

    public Developer getDeveloperById() throws NoSuchElementException {
        System.out.println("to get developer by id, enter id: ");
        Long id = numScanner.nextLong();
        if (id != 0) {
            developer = developerController.getByIdFromDeveloperRepo(id);
            if (developer != null) {
                return developer;
            } else {
                throw new NoSuchElementException("NO such developer!!!");
            }
        }
        return null;
    }

    public List<Developer> getAll() {
        developerList = developerController.getAll();
        return developerList;
    }
}
