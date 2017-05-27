package com.urise.webapp.storage;


import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.ContactType;
import com.urise.webapp.model.Resume;
import com.urise.webapp.model.Section;
import com.urise.webapp.model.SectionType;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by vp on 21.03.17.
 */
public abstract class AbstractStorageTest {
    protected Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final Resume RESUME_1;
    private static final Resume RESUME_2;
    private static final Resume RESUME_3;
    private static final Resume RESUME_4;

    static{
        RESUME_1 = new Resume(UUID_1, "John Snow");
        RESUME_2 = new Resume(UUID_2, "Rob Robinson");
        RESUME_3 = new Resume(UUID_3, "Djohn Djohnsom");
        RESUME_4 = new Resume(UUID_4, "Mike Tyson");
    }

    @Before

    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
        Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
        Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);
        contacts.put(ContactType.PHONE,"+7(916)000 0000");
        contacts.put(ContactType.MAIL, "xxx@xx.ru");
        contacts.put(ContactType.SKYPE, "Mr Zlo");
        sections.put(SectionType.ACHIEVEMENTS, new Section() {
        });

        RESUME_1.addContact(contacts);
        RESUME_2.addContact(contacts);
        RESUME_3.addContact(contacts);


    }

    @Test
    public void testSize() throws Exception {
        assertEquals(3, storage.size());

    }

    @Test
    public void testGet() throws Exception {
        assertEquals(UUID_2, storage.get(UUID_2).getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }


    @Test(expected = ExistStorageException.class)
    public void getExist() throws Exception {
        storage.save(new Resume(UUID_2, "Rob Robinson" ));
    }

    @Test
    public void testUpdate() throws Exception {
        Resume newResume = new Resume(UUID_1, "John Snow");
        storage.update(newResume);
        assertTrue(newResume == storage.get(UUID_1));
    }

    @Test
    public void testSave() throws Exception {
        storage.save(new Resume(UUID_4, "Mike Tyson"));
        assertEquals(4, storage.size());
     
    }

    @Test
    public void testDelete() throws Exception {
        storage.delete(UUID_2);
        Resume[] resumesExpected = {storage.get(UUID_1), storage.get(UUID_3)};
        List<Resume> resumesActual = storage.getAllSorted();
        assertArrayEquals(resumesExpected, resumesActual.toArray());
    }

    @Test
    public void testClear() throws Exception {
        storage.clear();
        assertEquals(0, storage.size());

    }

    @Test
    public void getAllSorted() throws Exception {
        List<Resume> list = storage.getAllSorted();
        assertEquals(3, list.size());
        assertEquals(list, Arrays.asList(RESUME_1, RESUME_2, RESUME_3));
        

    }

}