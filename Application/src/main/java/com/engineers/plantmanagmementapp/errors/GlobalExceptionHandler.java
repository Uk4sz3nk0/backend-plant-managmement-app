package com.engineers.plantmanagmementapp.errors;

import com.engineers.plantmanagmementapp.errors.users.RoleNotExistsException;
import com.engineers.plantmanagmementapp.errors.users.UserExistsException;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<String> handleUserExistsException(final UserExistsException e) {
        log.error(e.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getLocalizedMessage());
    }

    @ExceptionHandler(RoleNotExistsException.class)
    public ResponseEntity<String> handleRoleNotExistsException(final RoleNotExistsException e) {
        log.error(e.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getLocalizedMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<String> handleBadCredentials(final BadCredentialsException e) {
        log.error(e.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getLocalizedMessage());
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<String> handleJwtExpired(final ExpiredJwtException e) {
        log.error(e.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(e.getLocalizedMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleError(final RuntimeException e) {
        log.error(e.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
    }
}
