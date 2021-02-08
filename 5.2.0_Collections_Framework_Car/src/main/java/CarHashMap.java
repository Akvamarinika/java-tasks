import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarHashMap<K, V> implements CarMap<K, V> {
    private static final double LOAD_FACTOR = 0.75;
    private static final int INITIAL_CAPACITY = 16;
    Object[] entriesKV = new Object[INITIAL_CAPACITY];
    int size = 0;

    private void increaseArray(){
        Object[] entriesNew = new Object[entriesKV.length * 2];
        for (Object entry : entriesKV){
            Entry linkedEntry = (Entry) entry;
            while (linkedEntry != null){
                put(linkedEntry.key, linkedEntry.value, entriesNew);
                linkedEntry = linkedEntry.next;
            }
        }
        entriesKV = entriesNew;
    }

    private int getPosition(K carOwner, int lengthArray){
        return Math.abs((carOwner.hashCode() % lengthArray));
    }

    private boolean put(K key, V value, Object[] entriesArray){
        int position = getPosition(key, entriesArray.length);
        Entry entryOnPosition = (Entry) entriesArray[position];
        if (entryOnPosition == null){
            entriesArray[position] = new Entry(key, value, null);
            // size++;
            return true;
        } else {

            while (true) {
                if (entryOnPosition.key.equals(key)){
                    entryOnPosition.value = value;
                    return false;
                }

                /*if(entryOnPosition.next != null && entryOnPosition.next.key.equals(key)){
                    entryOnPosition.next.value = value;
                    return false;}*/
                if(entryOnPosition.next == null){
                    entryOnPosition.next = new Entry(key, value, null);
                    //size++;
                    return true;
                }else {
                    entryOnPosition = entryOnPosition.next;
                }
            }
        }
    }

    @Override
    public void put(K key, V value) {
        if (size >= (entriesKV.length * LOAD_FACTOR)){
            increaseArray();
        }

        boolean put = put(key, value, entriesKV);
        if (put){
            size++;
        }


    }

    @Override
    public V get(K key) {
        int position = getPosition(key, entriesKV.length);
        Entry entryOnPosition = (Entry) entriesKV[position];
        while (entryOnPosition != null) {
            if (entryOnPosition.key.equals(key)){
                return entryOnPosition.value;
            }
            entryOnPosition = entryOnPosition.next;
        }
        return null;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (Object entry : entriesKV){
            Entry linkedEntry = (Entry) entry;

            while (linkedEntry != null){
                keys.add(linkedEntry.key);
                linkedEntry = linkedEntry.next;
            }
        }
        return keys;
    }

    @Override
    public List<V> values() {
        List<V> values = new ArrayList<>();
        for (Object entry : entriesKV){
            Entry linkedEntry = (Entry) entry;

            while (linkedEntry != null){
                values.add(linkedEntry.value);
                linkedEntry = linkedEntry.next;
            }
        }
        return values;
    }

    @Override
    public boolean remove(K key) {
        int position = getPosition(key, entriesKV.length);

        Entry entryOnPositionFirst = (Entry) entriesKV[position];
        if (entryOnPositionFirst != null && entryOnPositionFirst.key.equals(key)){
            entriesKV[position] = entryOnPositionFirst.next;
            size--;
            return true;
        }

        while (entryOnPositionFirst != null) {
            Entry entryOnPositionSecond =  entryOnPositionFirst.next;
            if (entryOnPositionSecond == null) {
                return false;
            }

            if (entryOnPositionSecond.key.equals(key)) {
                entryOnPositionFirst.next = entryOnPositionSecond.next;
                size--;
                return true;
            }
                entryOnPositionFirst = entryOnPositionFirst.next;
                //entryOnPositionSecond = entryOnPositionSecond.next;


        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        entriesKV = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    class Entry{
        private final K key;
        private V value;
        private Entry next;
        Entry(K key, V value, Entry next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
