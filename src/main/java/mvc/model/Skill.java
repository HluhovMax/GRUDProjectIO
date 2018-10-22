package mvc.model;

/**
 * Created by Max Hluhov on 14.10.2018.
 */
public class Skill {
    private Long id;
    private String name;

    public Skill() {
    }

    public Skill(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id
                + ","
                + name
                + '/';
    }
}
