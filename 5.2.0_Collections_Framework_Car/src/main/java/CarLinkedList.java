import java.util.Iterator;

public class CarLinkedList<T> implements CarListMethods<T>, CarQueueMethods<T>{
    private Node first = null;
    private Node last = null;
    private int size = 0;

    private void checkIndex(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }

    private Node getNode(int index){
        checkIndex(index);
        Node node = first;
        for (int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }

    @Override
    public T get(int index) {
        return getNode(index).value;
    }

    @Override
    public boolean add(T car) {
        if(first == null){
            first = new Node(null, car, null);
            last = first;
        } else {
            Node prevTmpElem = last;
            last = new Node(prevTmpElem, car, null);
            prevTmpElem.next = last;
        }
        size++;
        return true;

    }

    @Override
    public boolean add(T car, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size){
           return add(car);
        } else {
            Node nodeNext = getNode(index);
            Node nodePrevious = getNode(index).previous;
            Node nodeNew = new Node(nodePrevious, car, nodeNext);
            nodeNext.previous = nodeNew;

            if (nodePrevious == null){
                first = nodeNew;
            } else{
                nodePrevious.next = nodeNew;
            }
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(T car) {
        int index = findIndex(car);
        if (index != -1){
            return  removeAt(index);
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        Node nodeDel = getNode(index);
        Node nodePrevious = nodeDel.previous;
        Node nodeNext = nodeDel.next;
        if (nodePrevious == null){
            first = nodeNext;
        } else {
            nodePrevious.next = nodeNext;
        }

        if (nodeNext == null){
            last = nodePrevious;
        } else {
            nodeNext.previous = nodePrevious;
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
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public String toString() {
        String space;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.size(); i++){
            space = i > 9 ? " " : "  ";
            builder.append(i);
            builder.append(space);
            builder.append(get(i));
        }
        return String.valueOf(builder);
    }

    @Override
    public boolean contains(T car) {
        return findIndex(car) != -1;
    }

    private int findIndex(T car){
        Node node = first;
        for (int i = 0; i < size; i++){
            if (node.value.equals(car)){
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node node = first;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                T car =  node.value;
                node = node.next;
                return car;
            }
        };
    }

    @Override
    public T peek() {
        return size != 0 ? get(0) : null;
    }

    @Override
    public T poll() {
        T car = get(0);
        removeAt(0);
        return car;
    }

    class Node{
        Node previous;
        T value;
        Node next;

        Node(Node previous, T value, Node next){
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}

