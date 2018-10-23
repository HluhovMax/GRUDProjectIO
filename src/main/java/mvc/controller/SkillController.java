package mvc.controller;

import mvc.model.Skill;
import mvc.repository.JavaIOSkillRepositoryImpl;
import mvc.repository.SkillRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max Hluhov on 23.10.2018.
 */
public class SkillController {
    private SkillRepository skillRepository;
    private Skill skill;
    private List<Skill> skillList;

    public SkillController() {
        skillList = new ArrayList<>();
        skillRepository = new JavaIOSkillRepositoryImpl();
        skill = new Skill();
    }

    public void saveToSkillRepo(Skill skill) {
        if (skill!=null) {
            try {
                skillRepository.save(skill);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void updateToSkillRepo(Skill skill) {
        if (skill!=null) {
            try {
                skillRepository.update(skill);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void deleteFromSkillRepo(Long id) {
        if (id!=0) {
            try {
                skillRepository.delete(id);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Skill getByIdFromSkillRepo(Long id) {
        if (id!=0) {
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
        return null;
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
