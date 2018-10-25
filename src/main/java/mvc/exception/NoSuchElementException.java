package mvc.exception;

/**
 * Created by Max Hluhov on 25.10.2018.
 */
public class NoSuchElementException extends Exception {
    public NoSuchElementException() {
        super();
    }

    public NoSuchElementException(String msg) {
        super(msg);
    }

    public NoSuchElementException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public NoSuchElementException(Throwable cause) {
        super(cause);
    }
}
