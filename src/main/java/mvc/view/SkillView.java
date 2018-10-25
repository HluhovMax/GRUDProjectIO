package mvc.view;

import mvc.controller.SkillController;
import mvc.exception.NoSuchElementException;
import mvc.model.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Max Hluhov on 23.10.2018.
 */
public class SkillView {
    private Long id;
    private String name;
    private Scanner idScanner;
    private Scanner nameScanner;
    private List<Skill> skillList;
    private SkillController controller;
    private Skill skill;

    public SkillView() {
        idScanner = new Scanner(System.in);
        nameScanner = new Scanner(System.in);
        skillList = new ArrayList<>();
        skill = new Skill();
        controller = new SkillController();
    }

    public  void saveSkill() {
        System.out.println("to save skill, enter id & name: ");
        id = idScanner.nextLong();
        name = nameScanner.nextLine();
        if ((id != 0) && (name != null)) {
            skill.setId(id);
            skill.setName(name);
        }
        if (skill != null) {
            controller.saveToSkillRepo(skill);
        }
    }

    public void updateSkill() {
        System.out.println("to update skill, enter id & new name: ");
        id = idScanner.nextLong();
        name = nameScanner.nextLine();
        if ((id != 0) && (name != null)) {
            skill.setId(id);
            skill.setName(name);
        }
        if (skill != null) {
            controller.updateToSkillRepo(skill);
        }
    }

    public void deleteSkill() {
        System.out.println("to delete skill, enter id: ");
        id = idScanner.nextLong();
        if (id != 0) {
            controller.deleteFromSkillRepo(id);
        }
    }

    public Skill getSkillById() throws NoSuchElementException {
        System.out.println("to get skill by id, enter id: ");
        id = idScanner.nextLong();
        if (id != 0) {
            skill = controller.getByIdFromSkillRepo(id);
            if (skill != null) {
                return skill;
            } else {
                throw new NoSuchElementException();
            }
        }
        return null;
    }

    public List<Skill> getAll(){
        skillList = controller.getAll();
        return skillList;
    }
}
