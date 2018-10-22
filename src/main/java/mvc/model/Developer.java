package mvc.model;

import java.util.List;

/**
 * Created by Max Hluhov on 19.10.2018.
 */
public class Developer {
    private Long id;
    private String name;
    private String surName;
    private String specialty;
    private List<Skill> skills;
    private Account account;

    public Developer() {
    }

    public Developer(Long id, String name, String surName,
                     String specialty, List<Skill> skills,
                     Account account) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.specialty = specialty;
        this.skills = skills;
        this.account = account;
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

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return id + ","
                + name + ','
                + surName + ','
                + specialty + ','
                + skills + ','
                + account;
    }
}
