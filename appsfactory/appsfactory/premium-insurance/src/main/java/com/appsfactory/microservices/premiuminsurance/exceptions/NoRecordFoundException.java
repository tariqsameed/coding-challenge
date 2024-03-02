package com.appsfactory.microservices.premiuminsurance.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoRecordFoundException extends RuntimeException{

    public NoRecordFoundException() {
        super();
    }

    public NoRecordFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public NoRecordFoundException(String message) {
        super(message);
    }
    public NoRecordFoundException(Throwable cause) {
        super(cause);
    }

}
