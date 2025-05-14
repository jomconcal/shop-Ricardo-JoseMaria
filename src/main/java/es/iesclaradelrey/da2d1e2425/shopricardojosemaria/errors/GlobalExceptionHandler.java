package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProblemDetail> productNotFound(ProductNotFoundException e) {
        ProblemDetail problem= ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED,e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problem);
    }

    @ExceptionHandler(InsufficientStock.class)
    public ResponseEntity<ProblemDetail> insufficientStock(InsufficientStock e) {
        ProblemDetail problem= ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT,e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(problem);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ProblemDetail> illegalArgument(IllegalArgumentException e) {
        ProblemDetail problem= ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problem);
    }

    @ExceptionHandler(WrongCredentialsException.class)
    public ResponseEntity<ProblemDetail> wrongCredentials(WrongCredentialsException e) {
        ProblemDetail problem= ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED,e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(problem);
    }

    @ExceptionHandler(UserNameAlreadyExistsException.class)
    public ResponseEntity<ProblemDetail> userNameAlreadyExists(UserNameAlreadyExistsException e) {
        ProblemDetail problem= ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT,e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(problem);
    }

    @ExceptionHandler(ItemNotBelongingToUserException.class)
    public ResponseEntity<ProblemDetail> itemNotBelongingToUser(ItemNotBelongingToUserException e) {
        ProblemDetail problem= ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT,e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(problem);
    }
}
