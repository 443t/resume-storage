import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.stream;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    protected static final int STORAGE_LIMIT = 10000;
    Resume[] storage = new Resume[STORAGE_LIMIT];
    int size = 0;


    void clear() {
        storage = new Resume[STORAGE_LIMIT];
    }

    void save(Resume r) {

        if (get(r.toString()) != null) {
            System.out.println("Sorry, it can't be save because Resume with uuid = " + r.toString() + " already exist!");
        } else if (isOverflow()) {
            System.out.println("Sorry, no more space in Array");
        } else {

            {
                storage[size++] = r;

            }
        }
    }


    Resume get(String uuid) {
        Resume m = null;
        for (Resume r : storage) {
            if (r != null && r.toString().equals(uuid)) {
                m = r;
                return m;
            }
        }
        return null;
    }

    Resume[] clean(Resume[] v) {
        List<Resume> list = new ArrayList<Resume>(Arrays.asList(v));
        list.removeAll(Collections.singleton(null));
        return list.toArray(new Resume[list.size()]);
    }

    void delete(String uuid) {

        for (int i = 0; i < size; i++) {
            if (storage[i] != null && storage[i].toString().equals(uuid)) {
                storage[i] = null;

                clean(storage);
                size--;

                System.out.print(size());

            }
        }


    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        Resume[] tmp = new Resume[STORAGE_LIMIT];
        return tmp = stream(storage)
                .filter(s -> (s != null))
                .toArray(Resume[]::new);

    }

    protected boolean isOverflow() {
        if (size >= (STORAGE_LIMIT - 1))
            return true;
        else
            return false;
    }


    int size() {
        return size;
    }
}
