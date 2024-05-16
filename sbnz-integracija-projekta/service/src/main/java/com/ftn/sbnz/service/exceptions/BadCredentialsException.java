package com.ftn.sbnz.service.exceptions;

public class BadCredentialsException extends RuntimeException{
    private String message;

    public BadCredentialsException() {}

    public BadCredentialsException(String msg)
    {
        super(msg);
        this.message = msg;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
