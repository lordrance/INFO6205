import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Bag<T> {
    private List<T> items;

    public Bag() {
        items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);
    }

    public void clear() {
        items.clear();
    }

    public boolean contains(T item) {
        return items.contains(item);
    }

    public T grab() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Cannot grab from an empty bag.");
        }
        Random rand = new Random();
        return items.get(rand.nextInt(items.size()));
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public boolean remove(T item) {
        return items.remove(item);
    }

    public int size() {
        return items.size();
    }
    public Object[] toArray() {
        return items.toArray();
    }

    public String toString() {
        return items.toString();
    }
}
