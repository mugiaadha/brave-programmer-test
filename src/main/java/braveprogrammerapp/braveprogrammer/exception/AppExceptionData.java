package braveprogrammerapp.braveprogrammer.exception;


import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class AppExceptionData {
    private final HttpStatus httpStatus;
    private final String message;
}
