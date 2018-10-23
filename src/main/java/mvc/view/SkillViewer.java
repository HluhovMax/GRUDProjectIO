package mvc.view;

import mvc.controller.SkillController;
import mvc.model.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Max Hluhov on 23.10.2018.
 */
public class SkillViewer {
    private Long id;
    private String name;
    private Scanner idScanner;
    private Scanner nameScanner;
    private List<Skill> skillList;
    private SkillController controller;

    public SkillViewer(SkillController controller) {
        idScanner = new Scanner(System.in);
        nameScanner = new Scanner(System.in);
        skillList = new ArrayList<>();
        this.controller = controller;
    }

    public SkillViewer() {
        idScanner = new Scanner(System.in);
        nameScanner = new Scanner(System.in);
        skillList = new ArrayList<>();
    }

    public  void saveSkill() {
        System.out.println("to save skill, enter id & name: ");
        id = idScanner.nextLong();
        name = nameScanner.nextLine();
    }

    public void updateSkill() {
        System.out.println("to update skill, enter id & new name: ");
        id = idScanner.nextLong();
        name = nameScanner.nextLine();
    }

    public void deleteSkill() {
        System.out.println("to delete skill, enter id: ");
        id = idScanner.nextLong();
    }

    public void getSkillById() {
        System.out.println("to get skill by id, enter id: ");
        id = idScanner.nextLong();
    }

    public List<Skill> getAll() {
        skillList = controller.getAll();
        return skillList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
