package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Created by vp on 15.03.17.
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
            size--;
        } else System.out.println("Resume with uuid = " + uuid + " doesn't exist.");
    }

    @Override
    public void save(Resume r) {

        if (isOverflow()) {
            System.out.println("Storage is full");
            return;
        }
        int j = getIndex(r.getUuid());
        if (j > 0) {
            System.out.println("Sorry, it can't be save because Resume with uuid = " + r.toString() + " already exist!");
        } else {
            // this is a new value to insert (not a duplicate).
            j = -j - 1;

            System.arraycopy(storage, j, storage, j + 1, size - j);
            storage[j] = r;
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
