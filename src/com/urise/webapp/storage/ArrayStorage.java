package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            int tmp = size - 1;
            storage[index] = storage[tmp];
            storage[tmp] = null;
            size--;
        } else System.out.println("Resume with uuid = " + uuid + " doesn't exist.");
    }

    public void save(Resume r) {

        if ((getIndex(r.getUuid()) > -1)) {
            System.out.println("Sorry, it can't be save because Resume with uuid = " + r.toString() + " already exist!");
        } else if (isOverflow()) {
            System.out.println("Storage is full");
        } else {
            storage[size++] = r;
        }
    }

    protected int getIndex(String uuid) {

        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;

    }

}
