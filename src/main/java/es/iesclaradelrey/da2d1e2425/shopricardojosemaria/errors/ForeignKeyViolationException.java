package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors;

public class ForeignKeyViolationException extends RuntimeException {
    public ForeignKeyViolationException(String thisCategoryIsNotEmpty) {
        super(thisCategoryIsNotEmpty);
    }
}
