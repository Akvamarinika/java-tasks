
import java.util.Arrays;
import java.util.Iterator;

public class CarArrayList<T> implements CarListMethods<T>{
    private Object[] carLst = new Object[10];
    private int size = 0;

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) carLst[index];
    }

    @Override
    public boolean add(T car) {
        listEnlargement();
        carLst[size] = car;
        size++;
        return true;
    }

    @Override
    public boolean add(T car, int index) {
        checkIndex(index);
        listEnlargement();
        if (size - index >= 0){
            System.arraycopy(carLst, index, carLst, index+1, size - index);
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(T car) {
        for (int i = 0; i < size; i++){
            if (car.equals(carLst[i])){
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        if (size-index >= 0) {
            System.arraycopy(carLst, index, carLst, index-1, size-index);
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        carLst = new Object[10];
        size = 0;
    }

    private void checkIndex(int index){
        if(index >= size){
            throw new IndexOutOfBoundsException();
        }
    }

    private void listEnlargement(){
        if (size >= carLst.length){
            carLst = Arrays.copyOf(carLst, carLst.length * 2);
        }
    }

    @Override
    public String toString() {
        String space;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.size(); i++){
            space = i > 9 ? " " : "  ";
            builder.append(i);
            builder.append(space);
            builder.append(carLst[i]);
        }
        return String.valueOf(builder);
    }

    @Override
    public boolean contains(T car) {
        for (int i = 0; i < size; i++){
            if (carLst[i].equals(car)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size ;
            }

            @Override
            public T next() {
                return (T) carLst[index++];
            }
        };
    }
}
