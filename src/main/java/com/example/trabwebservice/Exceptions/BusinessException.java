package com.example.trabwebservice.Exceptions;

import jakarta.xml.ws.WebFault;

@WebFault
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
