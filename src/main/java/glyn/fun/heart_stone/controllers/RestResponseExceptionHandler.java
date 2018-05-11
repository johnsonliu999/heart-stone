package glyn.fun.heart_stone.controllers;

import glyn.fun.heart_stone.exceptions.UnirestException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({UnirestException.class})
    public ResponseEntity<Object> handleUnirestException(Exception e, WebRequest request) {
        return new ResponseEntity<Object>("Unirest Exception", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
