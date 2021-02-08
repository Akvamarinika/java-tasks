public class Box<T1, T2, T3> {
    private T1 name;
    private T2 weight;
    private T3 height;

    Box(T1 name, T2 weight, T3 height){
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    public T1 getName() {
        return name;
    }

    public T2 getWeight() {
        return weight;
    }

    public T3 getHeight() {
        return height;
    }

}
