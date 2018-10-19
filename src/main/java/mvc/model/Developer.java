package mvc.model;

import java.util.Set;

/**
 * Created by Max Hluhov on 19.10.2018.
 */
public class Developer {
    private Long id;
    private String name;
    private String surName;
    private Set<Skill> skills;

    public Developer() {
    }

    public Developer(Long id, String name, String surName, Set<Skill> skills) {
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

    public Set<Skill> getSkills() {
        return skills;
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

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", id=" + id +
                ", skills=" + skills +
                '}';
    }
}
