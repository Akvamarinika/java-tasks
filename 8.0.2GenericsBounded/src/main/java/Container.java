public class Container<T extends Product> {
    T item;

    public Container(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public static<T extends Product> void compare(T obj1, T obj2){

    }
}
