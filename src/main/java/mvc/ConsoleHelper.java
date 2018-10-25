package mvc;

import mvc.exception.NoSuchElementException;
import mvc.view.AccountView;
import mvc.view.DeveloperView;
import mvc.view.SkillView;

import java.util.Scanner;

/**
 * Created by Max Hluhov on 25.10.2018.
 */
public class ConsoleHelper {
    private SkillView skillView;
    private AccountView accountView;
    private DeveloperView developerView;
    private Scanner scanner;

    public ConsoleHelper() {
        skillView = new SkillView();
        accountView = new AccountView();
        developerView = new DeveloperView();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("enter: 1 for SkillView|" +
                " 2 for AccountView| 3 for DeveloperView.");
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                System.out.println("Welcome in SkillView," +
                        " enter: 1 for save| 2 for update|" +
                        " 3 for delete| 4 for getting by id| 5 for getting all");
                i = scanner.nextInt();
                switch (i) {
                    case 1:
                        skillView.saveSkill();
                        break;
                    case 2:
                        skillView.updateSkill();
                        break;
                    case 3:
                        skillView.deleteSkill();
                        break;
                    case 4:
                        try {
                            skillView.getSkillById();
                        } catch (NoSuchElementException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        skillView.getAll();
                        break;
                    default:
                        System.out.println("enter methods id from 1 to 5");
                        break;
                }
                break;
            case 2:
                System.out.println("Welcome in AccountView," +
                        " enter: 1 for save| 2 for update|" +
                        " 3 for delete| 4 for getting by id| 5 for getting all");
                i = scanner.nextInt();
                switch (i) {
                    case 1:
                        accountView.saveAccount();
                        break;
                    case 2:
                        accountView.updateAccount();
                        break;
                    case 3:
                        accountView.deleteAccount();
                        break;
                    case 4:
                        try {
                            accountView.getAccountById();
                        } catch (NoSuchElementException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        accountView.getAll();
                        break;
                    default:
                        System.out.println("enter methods id from 1 to 5");
                        break;
                }
                break;
            case 3:
                System.out.println("Welcome in DeveloperView," +
                        " enter: 1 for save| 2 for update|" +
                        " 3 for delete| 4 for getting by id| 5 for getting all");
                i = scanner.nextInt();
                switch (i) {
                    case 1:
                        developerView.saveDeveloper();
                        break;
                    case 2:
                        developerView.updateDeveloper();
                        break;
                    case 3:
                        developerView.deleteDeveloper();
                        break;
                    case 4:
                        try {
                            developerView.getDeveloperById();
                        } catch (NoSuchElementException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        developerView.getAll();
                        break;
                    default:
                        System.out.println("enter methods id from 1 to 5");
                        break;
                }
                break;
            default:
                System.out.println("enter from 1 to 3.");
                break;
        }
    }
}
