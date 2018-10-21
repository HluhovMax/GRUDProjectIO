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
