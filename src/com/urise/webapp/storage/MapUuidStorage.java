package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

/**
 * Created by vp on 28.03.17.
 */
public class MapUuidStorage extends AbstractStorage<String> {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    public void clear() {
        map.clear();

    }

//    @Override
//    public List<Resume> getAllSorted() {
//        return Collections.emptyList();
//    }

    @Override
    public int size() {

        return map.size();
    }

    @Override
    protected Resume doGet(String uuid) {
        return map.get( uuid);
    }



    @Override
    protected void doDelete(String uuid) {
        map.remove( uuid);
    }

    @Override
    protected void doSave(Resume r, String uuid) {
        map.put( uuid, r);
    }

    @Override
    protected void doUpdate(Resume r, String uuid) {
        map.put( uuid, r);

    }

    @Override
    protected boolean isExist(String uuid) {
        return map.containsKey( uuid);
    }

    @Override
    protected List<Resume> doCopyAll() {
        return new ArrayList<>(map.values());
    }

}