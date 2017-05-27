package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.io.*;
import java.util.List;
import java.util.Objects;

/**
 * Created by vp on 24.05.17.
 */
public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private File directory;
    
    protected AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory must not be null");
        if(!directory.isDirectory())
        {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if(!directory.canRead()||!directory.canWrite())
        {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory=directory;
        
    }


    @Override
    public void clear() {
        directory.delete();
        
    }

    @Override
    public int size() {
        return (int) directory.length();
    }

    @Override
    protected Resume doGet(File file) {
        return null;
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected void doDelete(File file) {
        file.delete();

    }

    @Override
    protected void doSave(Resume r, File file) {
        try {
            file.createNewFile();
            doWrite(r, file);

        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }


    protected void doWrite(Resume r, File file) {

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file.getAbsolutePath()), "utf-8"))) {
            writer.write(r.toString());
        }
        catch (IOException e) {
            throw new StorageException("No file found Error", file.getName(), e);
        }
    }

    @Override
    protected void doUpdate(Resume r, File file)
    {
        doWrite(r, file);
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected List<Resume> doCopyAll() {
        return null;
    }
}
