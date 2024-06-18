package com.milhas.core.commons.infra;

import com.milhas.core.commons.dto.ErrorMessageDTO;
import com.milhas.core.commons.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<ErrorMessageDTO> userNotFoundHandler(UserNotFoundException ex){
        ErrorMessageDTO responseError = new ErrorMessageDTO("001", "User not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseError);
    }
}
