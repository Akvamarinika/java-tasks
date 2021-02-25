public class CarLinkedList implements CarListMethods {
    Node first = null;
    Node last = null;
    int size = 0;

    private void checkIndex(int index){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
    }

    private Node getNode(int index){
        checkIndex(index);
        Node node = first;
        for (int i = 0; i < size; i++){
            node = node.next;
        }
        return node;
    }

    @Override
    public Car get(int index) {
        return getNode(index).value;
    }

    @Override
    public void add(Car car) {
        if(first == null){
            first = new Node(null, car, null);
            last = first;
        } else {
            Node prevTmpElem = last;
            last = new Node(prevTmpElem, car, null);
            prevTmpElem.next = last;
        }
        size++;

    }

    @Override
    public void add(Car car, int index) {
        checkIndex(index);
        if (index == size){
            add(car);
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
    }

    @Override
    public boolean remove(Car car) {
        Node node = first;
        for (int i = 0; i < size; i++){
            if (node.value.equals(car)) {
                removeAt(i);
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


}
