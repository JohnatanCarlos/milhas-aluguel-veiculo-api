package com.milhas.core.commons.enumerable;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum MessageError {
    NAME_IS_REQUIRED("MSG001", "error.name_required", HttpStatus.BAD_REQUEST),
    DOCUMENT_NUMBER("MSG002", "error.document_number_required", HttpStatus.BAD_REQUEST),
    DOCUMENT_TYPE("MSG003", "error.document_type_required", HttpStatus.BAD_REQUEST);

    private final String code;
    private final String message;
    private final HttpStatus statusCode;


    MessageError(String code, String message, HttpStatus statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }


}
