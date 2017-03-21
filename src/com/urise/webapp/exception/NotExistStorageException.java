package com.urise.webapp.exception;

/**
 * Created by vp on 19.03.17.
 */
public class NotExistStorageException extends StorageException {

    public NotExistStorageException(String uuid) {
        super("Resume " + uuid + " not exist",uuid);
    }
}
