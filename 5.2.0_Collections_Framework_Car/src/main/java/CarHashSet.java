public class CarHashSet implements CarSetMethods {
    private int size = 0;
    public static final int INIT_CAPACITY = 16;
    Entry[] entriesArr = new Entry[INIT_CAPACITY];

    public int getPositionElem(Car car){
        return Math.abs(car.hashCode() % entriesArr.length);
    }

    @Override
    public boolean add(Car car) {
        int position = getPositionElem(car);
        if (entriesArr[position] == null){
            entriesArr[position] = new Entry(car, null);
            size++;
            return true;
        } else {
            Entry itemOnPosition = entriesArr[position];
            while (true) {
                if (itemOnPosition.element.equals(car)){
                    return false;
                } else if (itemOnPosition.next == null){
                    itemOnPosition.next = new Entry(car, null);
                    size++;
                    return true;
                } else {
                    itemOnPosition = itemOnPosition.next;
                }
            }
        }
    }

    @Override
    public boolean remove(Car car) {
        int position = getPositionElem(car);
        if (entriesArr[position] == null){
            return false;
        }

        Entry firstElemOnPosition = entriesArr[position];
        Entry secondElemOnPosition = entriesArr[position].next;

        while (secondElemOnPosition != null) {
            if (firstElemOnPosition.element.equals(car)){
                entriesArr[position] = secondElemOnPosition;
                size--;
                return true;
            }

            if (secondElemOnPosition.element.equals(car)){
                entriesArr[position].next = secondElemOnPosition.next;
                size--;
                return true;
            } else {
                firstElemOnPosition = secondElemOnPosition;
                secondElemOnPosition = secondElemOnPosition.next;
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
        Entry[] entriesArr = new Entry[INIT_CAPACITY];
        size = 0;

    }

   static class Entry{
       private Car element;
       private Entry next;

       public Entry(Car car, Entry entry){
           this.element = car;
           this.next = entry;
       }
    }
}
