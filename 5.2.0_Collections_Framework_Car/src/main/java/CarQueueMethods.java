public interface CarQueueMethods<T> extends CollectionMethods<T>{
    boolean add(T car);
    T peek();
    T poll();
}
