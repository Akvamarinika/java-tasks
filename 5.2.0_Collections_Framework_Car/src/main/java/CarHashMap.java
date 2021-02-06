import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarHashMap implements CarMap {
    private static final double LOAD_FACTOR = 0.75;
    private static final int INITIAL_CAPACITY = 16;
    Entry[] entriesKV = new Entry[INITIAL_CAPACITY];
    int size = 0;

    private void increaseArray(){
        Entry[] entriesNew = new Entry[entriesKV.length * 2];
        for (Entry entry : entriesKV){
            Entry linkedEntry = entry;
            while (linkedEntry != null){
                put(linkedEntry.key, linkedEntry.value, entriesNew);
                linkedEntry = linkedEntry.next;
            }
        }
        entriesKV = entriesNew;
    }

    private int getPosition(CarOwner carOwner, int lengthArray){
        return Math.abs((carOwner.hashCode() % lengthArray));
    }

    private boolean put(CarOwner key, Car value, Entry[] entriesArray){
        int position = getPosition(key, entriesArray.length);
        Entry entryOnPosition = entriesArray[position];
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
    public void put(CarOwner key, Car value) {
        if (size >= (entriesKV.length * LOAD_FACTOR)){
            increaseArray();
        }

        boolean put = put(key, value, entriesKV);
        if (put){
            size++;
        }


    }

    @Override
    public Car get(CarOwner key) {
        int position = getPosition(key, entriesKV.length);
        Entry entryOnPosition = entriesKV[position];
        while (entryOnPosition != null) {
            if (entryOnPosition.key.equals(key)){
                return entryOnPosition.value;
            }
            entryOnPosition = entryOnPosition.next;
        }
        return null;
    }

    @Override
    public Set<CarOwner> keySet() {
        Set<CarOwner> keys = new HashSet<>();
        for (Entry entry : entriesKV){
            Entry linkedEntry = entry;

            while (linkedEntry != null){
                keys.add(linkedEntry.key);
                linkedEntry = linkedEntry.next;
            }
        }
        return keys;
    }

    @Override
    public List<Car> values() {
        List<Car> values = new ArrayList<>();
        for (Entry entry : entriesKV){
            Entry linkedEntry = entry;

            while (linkedEntry != null){
                values.add(linkedEntry.value);
                linkedEntry = linkedEntry.next;
            }
        }
        return values;
    }

    @Override
    public boolean remove(CarOwner key) {
        int position = getPosition(key, entriesKV.length);

        Entry entryOnPositionFirst = entriesKV[position];
        Entry entryOnPositionSecond = entriesKV[position].next;
        if (entryOnPositionFirst != null && entryOnPositionFirst.key.equals(key)){
            entriesKV[position] = entryOnPositionSecond;
            size--;
            return true;
        }

        while (entryOnPositionSecond != null) {
            if (entryOnPositionSecond.key.equals(key)) {
                entryOnPositionFirst.next = entryOnPositionSecond.next;
                size--;
                return true;
            } else {
                entryOnPositionFirst = entryOnPositionSecond;
                entryOnPositionSecond = entryOnPositionSecond.next;
            }

        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        entriesKV = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    static class Entry{
        private final CarOwner key;
        private Car value;
        private Entry next;
        Entry(CarOwner key, Car value, Entry next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
