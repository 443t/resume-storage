package com.urise.webapp.exception;

/**
 * Created by vp on 19.03.17.
 */
public class StorageException extends RuntimeException {
    private final String uuid;

    public StorageException(String message, String uuid) {
        super(message);
        this.uuid=uuid;

    }

    public StorageException(String message, String uuid, Exception e) {
        super(message, e);
        this.uuid=uuid;
    }

    public String getUuid()
    {
        return uuid;
    }
}
