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
        int index = getIndex(r.getUuid());
        if (index > -1) {
            storage[index].setUuid(r.getUuid());
        } else System.out.println("Resume doesn't exist.");

    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index > 0) {
            System.out.println("Sorry, it can't be save because Resume with uuid = " + r.toString() + " already exist!");
        } else if (isOverflow()) {
            System.out.println("Storage is full");
        } else {
            insertElement(r, index);
            size++;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0)
        {
            System.out.println("Resume with uuid = " + uuid + " doesn't exist.");
        }
        else {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        }
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume r, int index);

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