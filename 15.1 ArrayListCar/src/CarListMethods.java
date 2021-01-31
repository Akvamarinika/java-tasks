public interface CarListMethods {
    public Car get(int index);
    public void add(Car car);
    public void add(Car car, int index);
    public boolean remove(Car car);
    boolean removeAt(int index);
    int size();
    void clear();
}
