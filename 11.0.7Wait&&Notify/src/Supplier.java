public class Supplier implements Runnable{
   private Shop shop;

    public Supplier(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++) {
            shop.makeProduct();
        }
    }
}
