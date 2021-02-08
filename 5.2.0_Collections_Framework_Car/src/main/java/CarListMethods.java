public interface CarListMethods<T> extends CollectionMethods<T> {
    T get(int index);
    //boolean add(Car car);
    boolean add(T car, int index);
   // boolean remove(Car car);
    boolean removeAt(int index);
   // int size();
    //void clear();
}
