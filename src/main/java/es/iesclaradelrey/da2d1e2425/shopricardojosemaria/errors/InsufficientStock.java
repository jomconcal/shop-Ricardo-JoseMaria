package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors;

public class InsufficientStock extends RuntimeException {
    public InsufficientStock(String message) {
        super(message);
    }
}
