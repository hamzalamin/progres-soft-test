package com.progressoft.progressofttest.Exception;

public class DuplicateIdException extends RuntimeException {
    public DuplicateIdException(Object id) {
        super("this id : " + id + " Already exist");
    }
}
