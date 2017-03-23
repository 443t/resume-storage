package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by vp on 21.03.17.
 */
public abstract class AbstractArrayStorageTest {
    protected Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";


    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));

    }

    @Test
    public void testSize() throws Exception {
        Assert.assertEquals(3, storage.size());

    }

    @Test
    public void testGet() throws Exception {
        assertNotNull(UUID_2, storage.get(UUID_2).getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");

    }

    @Test(expected = ExistStorageException.class)
    public void getExist() throws Exception {
        storage.save(new Resume(UUID_2));

    }

    @Test
    public void testUpdate() throws Exception {
        storage.update(storage.get(UUID_2));


    }

    @Test(expected = ExistStorageException.class)
    public void testSave() throws Exception {
        storage.save(new Resume(UUID_4));
        Assert.assertEquals(4, storage.size());
        storage.save(new Resume(UUID_4));

    }

    @Test(expected = NotExistStorageException.class)
    public void testDelete() throws Exception {
        storage.delete(UUID_1);
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void testClear() throws Exception {
        storage.clear();
        Assert.assertEquals(0, storage.size());
        storage.get(UUID_1);
    }

    @Test
    public void getAll() throws Exception {
        assertNotNull("should not be null", storage.getAll());

    }

}