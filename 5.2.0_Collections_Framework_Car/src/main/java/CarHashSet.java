import java.util.Iterator;

public class CarHashSet<T> implements CarSetMethods<T>{
    private int size = 0;
    public static final double LOAD_FACTOR = 0.75;
    public static final int INIT_CAPACITY = 16;
    Object[] entriesArr = new Object[INIT_CAPACITY];

    public int getPositionElem(T car, int lenArr){
        return Math.abs(car.hashCode() % lenArr);
    }

    @Override
    public boolean add(T car) {
        if (size >= (entriesArr.length * LOAD_FACTOR) ){
            increaseArray();
        }
        boolean isAdded = add(car, entriesArr);
        if (isAdded){
          size++;
        }
        return isAdded;
    }

    public boolean add(T car, Object[] currentArray) {
        int position = getPositionElem(car, currentArray.length);
        if (currentArray[position] == null){
            currentArray[position] = new Entry(car, null);
            //size++;
            return true;
        } else {
            Entry itemOnPosition = (Entry)currentArray[position];
            while (true) {
                if (itemOnPosition.element.equals(car)){
                    return false;
                } else if (itemOnPosition.next == null){
                    itemOnPosition.next = new Entry(car, null);
                    //size++;
                    return true;
                } else {
                    itemOnPosition = itemOnPosition.next;
                }
            }
        }
    }

    private void increaseArray(){
        Object[] newArray = new Object[entriesArr.length * 2];
        for (Object entry : entriesArr){
            Entry itemOnPosition = (Entry)entry;
            while (itemOnPosition != null){
                add(itemOnPosition.element, newArray);
                itemOnPosition = itemOnPosition.next;

            }
        }
        entriesArr = newArray;
    }

    @Override
    public boolean remove(T car) {
        int position = getPositionElem(car, entriesArr.length);
        if (entriesArr[position] == null){
            return false;
        }

        Entry firstElemOnPosition = (Entry)entriesArr[position];
        Entry secondElemOnPosition = ((Entry)entriesArr[position]).next;
        if (firstElemOnPosition.element.equals(car)){
            entriesArr[position] = secondElemOnPosition;
            size--;
            return true;
        }

        while (secondElemOnPosition != null) {
            if (secondElemOnPosition.element.equals(car)){
                firstElemOnPosition.next = secondElemOnPosition.next;
                size--;
                return true;
            } else {
                firstElemOnPosition = secondElemOnPosition;
                secondElemOnPosition = secondElemOnPosition.next;
            }
        }

        return false;
    }

  /*  public void print(){
        int i = 0;
        for (Entry entry : entriesArr){
            System.out.println(i + " " + entry);
            i++;
        }
    }*/



    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        entriesArr = new Object[INIT_CAPACITY];
        size = 0;

    }

    @Override
    public String toString() {
        int i = 0;
        StringBuilder builder = new StringBuilder(" ");
        for (Object entry1 : entriesArr){
            Entry entry = (Entry) entry1;
            if (entry != null){
                builder.append(++i);
                builder.append(" ");
                builder.append(entry.element);
                builder.append(" ");
                Entry itemNext = entry.next;
                while (itemNext != null){
                    builder.append(++i);
                    builder.append(" ");
                    builder.append(itemNext.element);
                    builder.append(" ");
                    itemNext = itemNext.next;
                }
            }
        }
        return String.valueOf(builder);
    }

    @Override
    public boolean contains(T car) {
        int position = getPositionElem(car, entriesArr.length);
        if (entriesArr[position] == null){
            return false;
        } else{
            Entry firstElemOnPosition = (Entry)entriesArr[position];
            Entry secondElemOnPosition = ((Entry)entriesArr[position]).next;
            if (firstElemOnPosition.element.equals(car)){
                return true;
            }
            while (secondElemOnPosition != null){
                if(secondElemOnPosition.element.equals(car)){
                    return true;
                } else {
                    secondElemOnPosition = secondElemOnPosition.next;
                }
            }

        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Entry entryItem;
            int countItem = 0;
            int indexArr = 0; // ищем заполненную ячейку массива

            @Override
            public boolean hasNext() {
                return countItem < size;
            }

            @Override
            public T next() {
                while (entriesArr[indexArr] == null){
                    indexArr++;
                }

                if (entryItem == null){
                    entryItem = (Entry)entriesArr[indexArr];
                }

                T car = entryItem.element;
                entryItem = entryItem.next;
                if (entryItem == null){
                    indexArr++;
                }

                countItem++;
                return car;
            }
        };
    }

     class Entry{
        private T element;
        private Entry next;

        public Entry(T car, Entry entry){
            this.element = car;
            this.next = entry;
        }
    }

}
