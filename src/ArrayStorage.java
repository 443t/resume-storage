import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int curr = 0;

    void clear() {
        storage = new Resume[10000];
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                return;
            }
        }
    }

    Resume get(String uuid) {
        Resume m = null;
        for(Resume r: storage)  {
            if (r != null && r.toString().equals(uuid)) {
                m = r;
            }
        }
        return m;
    }

    void delete(String uuid) {

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && storage[i].toString().equals(uuid)) {
                storage[i] = null;


            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        Resume[] tmp = new Resume[10000];
        return tmp = Arrays.stream(storage)
                .filter(s -> (s != null))
                .toArray(Resume[]::new);

    }

    int size() {
        return storage.length;
    }
}
