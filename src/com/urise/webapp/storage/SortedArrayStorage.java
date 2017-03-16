package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Created by vp on 15.03.17.
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == size - 1) {
            storage[size - 1] = null;
            size--;

        } else if (index > -1) {
            for (int j = index; j < size; j++) {

                storage[j] = storage[j + 1];
            }

            size--;
        } else System.out.println("Resume with uuid = " + uuid + " doesn't exist.");
    }

    @Override
    public void save(Resume r) {

        if ((getIndex(r.getUuid()) > -1)) {
            System.out.println("Sorry, it can't be save because Resume with uuid = " + r.toString() + " already exist!");
        } else if (isOverflow()) {
            System.out.println("Storage is full");
        } else if (size > 0) {
            int i = 0;
            while (i < size && storage[i].hashCode() < r.hashCode()) {
                i++;
            }
            if (i < size + 1) {
                //you found a place to insert the score
                for (int j = size; j > i; j--) {
                    storage[j] = storage[j - 1];
                }
                storage[i] = r;
                size++;
            }
        } else if (size == 0) {
            storage[0] = r;
            size++;
        }

    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
