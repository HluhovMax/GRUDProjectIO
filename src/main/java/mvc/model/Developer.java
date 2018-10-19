package mvc.model;

import java.util.List;

/**
 * Created by Max Hluhov on 19.10.2018.
 */
public class Developer {
    private Long id;
    private String name;
    private String surName;
    private List<Skill> skills;

    public Developer() {
    }

    public Developer(Long id, String name, String surName, List<Skill> skills) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return id +", "+ name +" "+ surName +" "+ skills;
    }
}
