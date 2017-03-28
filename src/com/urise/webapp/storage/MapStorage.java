package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.HashMap;

/**
 * Created by vp on 28.03.17.
 */
public class MapStorage extends AbstractStorage {


    HashMap<String, Resume> storage = new HashMap<String, Resume>();


    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public void update(Resume r) {

        storage.put(r.getUuid(), r);

    }

    @Override
    public void save(Resume r) {
        if (!storage.containsValue(r))
        { storage.put(r.getUuid(), r); }
        else throw new ExistStorageException(r.getUuid());
    }

    @Override
    public Resume get(String uuid) {
        return storage.get(uuid);
    }

    @Override
    public void delete(String uuid) {
        storage.remove(uuid);

    }

    @Override
    public Resume[] getAll() {
        return (Resume[]) (storage.values()).toArray();

    }

    @Override
    public int size() {
        return storage.size();
    }
}
