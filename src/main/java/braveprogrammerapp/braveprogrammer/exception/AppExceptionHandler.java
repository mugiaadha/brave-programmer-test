package braveprogrammerapp.braveprogrammer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(value = {AppException.class})
    public ResponseEntity<Object> handleAppException(AppException e) {
        AppExceptionData appException = new AppExceptionData(HttpStatus.BAD_REQUEST, e.getMessage());
        return new ResponseEntity<>(appException, HttpStatus.BAD_REQUEST);
    }
}
