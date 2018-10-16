package mvc.model;

import java.io.Serializable;

/**
 * Created by Max Hluhov on 14.10.2018.
 */
public class Skill implements Serializable{
    private Long ID;
    private String name;

    public Skill(Long ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "ID = " + ID +
                ", name = '" + name + '\'' +
                '}';
    }
}
