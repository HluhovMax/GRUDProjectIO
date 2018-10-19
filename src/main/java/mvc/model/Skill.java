package mvc.model;

/**
 * Created by Max Hluhov on 14.10.2018.
 */
public class Skill {
    private Long id;
    private String name;

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

    @Override
    public String toString() {
        return id
                + ","
                + name
                + '/';
    }
}
