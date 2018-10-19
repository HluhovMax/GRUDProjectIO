package mvc.model;

/**
 * Created by Max Hluhov on 19.10.2018.
 */
public class Account {
    private Long id;
    private Developer developer;

    public Account(Long id, Developer developer) {
        this.id = id;
        this.developer = developer;
    }

    public Long getId() {
        return id;
    }

    public Developer getDeveloper() {
        return developer;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", developer=" + developer +
                '}';
    }
}
