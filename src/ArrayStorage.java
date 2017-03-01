import static java.util.Arrays.stream;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    protected static final int STORAGE_LIMIT = 10000;
    Resume[] storage = new Resume[STORAGE_LIMIT];
    int size = 0;


    void clear() {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {

        if ((getIndex(r.uuid) > -1)) {
            System.out.println("Sorry, it can't be save because Resume with uuid = " + r.toString() + " already exist!");
        } else if (isOverflow()) {
            System.out.println("Sorry, no more space in Array");
        } else {
            storage[size++] = r;
        }
    }

    Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            return storage[index];
        } else return null;
    }


    int getIndex(String uid) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid == uid) {
                index = i;
                return index;
            }
        }
        return index;
    }

    void delete(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            int tmp = size - 1;
            storage[index] = storage[tmp];
            storage[tmp] = null;
            size--;
        } else System.out.println("Nothing to delete.");
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
