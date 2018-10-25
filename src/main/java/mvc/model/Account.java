package mvc.model;

/**
 * Created by Max Hluhov on 19.10.2018.
 */
public class Account extends BaseEntity{
    private Long id;
    private String data;

    public Account() {
    }

    public Account(Long id, String data) {
        this.id = id;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return id
                + ","
                + data
                + '/';
    }
}
