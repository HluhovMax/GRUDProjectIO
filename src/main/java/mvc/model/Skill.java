package mvc.model;

import java.io.Serializable;

/**
 * Created by Max Hluhov on 14.10.2018.
 */
public class Skill implements Serializable{
    private String ID;
    private String name;

    public Skill(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }
}
