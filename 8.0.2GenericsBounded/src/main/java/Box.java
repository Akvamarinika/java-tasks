import java.util.List;

public class Box<T extends Number & Comparable<T> >{
    T[] array;
    Box(T... args){
        this.array = args;
    }

    public T[] getArray() {
        return array;
    }

    public double avg(){
        double result = 0;
        for (T elem : array){
            result += ((Number) elem).doubleValue();
        }
        return result / array.length;
    }

    public int compare(Box<?> other){
        return (int) (this.avg() - other.avg());
    }

    public static <E> List<E> transfer(List<E> lst, List<E> dst){
        dst.addAll(lst);
        lst.clear();
        return dst;
    }

    public static <E> void copy(List<? extends E> lst, List<? super E> dst){
        for (E product : lst){
            dst.add(product);
        }
        lst.clear();
    }


}
