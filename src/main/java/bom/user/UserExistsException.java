package bom.user;

public class UserExistsException extends RuntimeException {

    public UserExistsException(String message) {
        super(message);
    }
}
