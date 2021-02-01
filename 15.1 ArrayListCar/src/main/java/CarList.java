import java.util.Arrays;

public class CarList implements CarListMethods {
    private Car[] carLst = new Car[10];
    private int size = 0;

    @Override
    public Car get(int index) {
        checkIndex(index);
        return carLst[index];
    }

    @Override
    public void add(Car car) {
        listEnlargement();
        carLst[size] = car;
        size++;
    }

    @Override
    public void add(Car car, int index) {
        checkIndex(index);
        listEnlargement();
        if (size - index >= 0){
            System.arraycopy(carLst, index, carLst, index+1, size - index);
        }
        /*for (int i = size; i > index; i--){
            carLst[i] = carLst[i-1];
        }
        carLst[index] = car;*/
        size++;
    }

    @Override
    public boolean remove(Car car) {
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
        /*for (int i = index; i < size; i++ ){
            carLst[i] = carLst[i+1];
        }*/
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Car[] carLst = new Car[10];
        size = 0;
    }

    private void checkIndex(int index){
        if(index >= size){
            throw new IndexOutOfBoundsException();
        }
    }

    private void listEnlargement(){
        if (size >= carLst.length){
            //Car[] tmp = new Car[carLst.length * 2];

            carLst = Arrays.copyOf(carLst, carLst.length * 2);
          /*  for (int idx = 0; idx < size; idx++){
                tmp[idx] = carLst[idx];
            }
            carLst = tmp;*/
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
}
