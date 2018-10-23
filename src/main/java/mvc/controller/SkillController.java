package mvc.controller;

import mvc.model.Skill;
import mvc.repository.JavaIOSkillRepositoryImpl;
import mvc.repository.SkillRepository;
import mvc.view.SkillViewer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max Hluhov on 23.10.2018.
 */
public class SkillController {
    private SkillRepository skillRepository;
    private SkillViewer skillViewer;
    private Skill skill;
    private List<Skill> skillList;

    public SkillController() {
        skillList = new ArrayList<>();
        skillRepository = new JavaIOSkillRepositoryImpl();
        skill = new Skill();
    }

    public SkillController(SkillViewer skillViewer) {
        skillRepository = new JavaIOSkillRepositoryImpl();
        this.skillViewer = skillViewer;
        skill = new Skill();
    }

    public void saveToSkillRepo() {
        Long id = Long.valueOf(skillViewer.getId());
        String name = skillViewer.getName();
        skill.setId(id);
        skill.setName(name);
        try {
            skillRepository.save(skill);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateToSkillRepo() {
        Long id = Long.valueOf(skillViewer.getId());
        String name = skillViewer.getName();
        skill.setId(id);
        skill.setName(name);
        try {
            skillRepository.update(skill);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteFromSkillRepo() {
        Long id = Long.valueOf(skillViewer.getId());
        try {
            skillRepository.delete(id);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Skill getByIdFromSkillRepo() {
        Long id = Long.valueOf(skillViewer.getId());
        try {
            skill = skillRepository.getById(id);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        String name = skill.getName().substring(0,
                skill.getName().length() - 1);
        skill.setName(name);
        return skill;
    }

    public List<Skill> getAll() {
        try {
            skillList = skillRepository.getAll();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<Skill> skills = new ArrayList<>();
        for (Skill s : skillList) {
            String string = s.getName().substring(0,
                    s.getName().length() - 1);
            s.setName(string);
            skills.add(s);
        }
        skillList = skills;
        return skillList;
    }
}
