package com.milhas.core.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorMessageDTO {
    private String code;
    private String message;

}
