package mvc.model;

/**
 * Created by Max Hluhov on 19.10.2018.
 */
public class Account {
    private Long id;
    private String data;

    public Account(Long id, String data) {
        this.id = id;
        this.data = data;
    }

    @Override
    public String toString() {
        return id
                + ", "
                + data
                + '/';
    }
}
