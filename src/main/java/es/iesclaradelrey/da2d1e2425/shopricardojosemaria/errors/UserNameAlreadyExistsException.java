package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors;

public class UserNameAlreadyExistsException extends RuntimeException {
    public UserNameAlreadyExistsException(String email) {
        super(email);
    }
}
