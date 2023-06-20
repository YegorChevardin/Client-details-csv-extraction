package com.test.task.yegorchevardin.service.exceptions;

/**
 * Exception for case if there was an error while reading file
 * @author yegorchevardin
 * @version 0.0.1
 */
public class FileReadException extends RuntimeException {
    public FileReadException(String message) {
        super(message);
    }

    public FileReadException(String message, Exception e) {
        super(message, e);
    }
}
