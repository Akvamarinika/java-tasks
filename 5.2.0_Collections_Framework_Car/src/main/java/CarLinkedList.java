public class CarLinkedList implements CarListMethods{
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
    public Car get(int index) {
        return getNode(index).value;
    }

    @Override
    public boolean add(Car car) {
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
    public boolean add(Car car, int index) {
        checkIndex(index);
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
    public boolean remove(Car car) {
        Node node = first;
        for (int i = 0; i < size; i++){
            if (node.value.equals(car)) {
                return removeAt(i);
            }
            node = node.next;
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

    static class Node{
        Node previous;
        Car value;
        Node next;

        Node(Node previous, Car value, Node next){
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public boolean contains(Car car) {
        return false;
    }
}

