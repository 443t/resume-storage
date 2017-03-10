import static java.util.Arrays.stream;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int STORAGE_LIMIT = 10000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;


    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
    }

    public void update(Resume r) {
        if ((getIndex(r.uuid) > -1)) {
            storage[getIndex(r.uuid)].uuid = r.uuid;
        } else System.out.println("Resume doesn't exist.");

    }

    public void save(Resume r) {

        if ((getIndex(r.uuid) > -1)) {
            System.out.println("Sorry, it can't be save because Resume with uuid = " + r.toString() + " already exist!");
        } else if (isOverflow()) {
            System.out.println("Storage is full");
        } else {
            storage[size++] = r;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            return storage[index];
        } else {
            System.out.println("Resume with uuid = " + uuid + " doesn't exist.");
            return null;
        }
    }


    public int getIndex(String uid) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uid)) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            int tmp = size - 1;
            storage[index] = storage[tmp];
            storage[tmp] = null;
            size--;
        } else System.out.println("Resume with uuid = " + uuid + " doesn't exist.");
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {

        Resume[] r = new Resume[STORAGE_LIMIT];
        return r = stream(storage)
                .filter(s -> (s != null))
                .toArray(Resume[]::new);

    }

    protected boolean isOverflow() {
        return size >= (STORAGE_LIMIT - 1);
    }


    public int size() {
        return size;
    }
}
