package com.urise.webapp.exception;

/**
 * Created by vp on 19.03.17.
 */
public class ExistStorageException extends StorageException {
    private final String uuid;

    public ExistStorageException(String uuid) {

        super("Resume " + uuid + " already exist",uuid);
        this.uuid = uuid;
    }
}
