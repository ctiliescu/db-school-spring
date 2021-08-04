package com.db.shopify.config;

import com.db.shopify.auth.model.AuthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({AuthException.class})
    public ResponseEntity<String> handlePaymentRefuseException(AuthException exception) {

        return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
    }
}
