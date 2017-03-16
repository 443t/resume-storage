package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            return storage[index];
        } else {
            System.out.println("Resume with uuid = " + uuid + " doesn't exist.");
            return null;
        }
    }

    public void update(Resume r) {
        if ((getIndex(r.getUuid()) > -1)) {
            storage[getIndex(r.getUuid())].setUuid(r.getUuid());
        } else System.out.println("Resume doesn't exist.");

    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume[] getAll() {

        return Arrays.copyOfRange(storage, 0, size);

    }

    protected boolean isOverflow() {
        return size >= (STORAGE_LIMIT - 1);
    }



    protected abstract int getIndex(String uuid);
}