public class FlashDrive extends Product {
    int capacity;

    public FlashDrive(String name, int quantity, double price, int capacity) {
        super(name, quantity, price);
        this.capacity = capacity;
    }
}
