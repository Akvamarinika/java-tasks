public class Main {
    public static void main(String[] args) {
        Shop shop1 = new Shop();
        new Thread(new Consumer(shop1)).start();
        new Thread(new Supplier(shop1)).start();
    }
}
