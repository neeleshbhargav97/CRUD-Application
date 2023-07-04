package com.example.crud.crud.example.service.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus
public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String s) {
        super(s);
    }

    public ResourceNotFoundException(String s, Throwable th) {
        super(s, th);
    }
}
