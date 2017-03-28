package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;

/**
 * Created by vp on 26.03.17.
 */
public class ListStorage extends AbstractStorage {

    ArrayList<Resume> storage = new ArrayList();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public void update(Resume r) {

        int index = getIndex(r.getUuid());
        storage.set(index, r);

    }

    @Override
    public void save(Resume r) {
        storage.add(r);
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage.get(index);
        } else return null;
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            storage.remove(index);
        }
    }

    @Override
    public Resume[] getAll() {
        return (Resume[]) storage.toArray();
    }

    @Override
    public int size() {
        return storage.size();
    }

    public int getIndex(String uuid) {
        int index = -1;
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                index = i;
            }
        }
        return index;
    }
}
