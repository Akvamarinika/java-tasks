public class Shop {
    private int countProduct = 0;

    public synchronized void buyProduct(){
        try {
            while (countProduct < 1){
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countProduct--;
        System.out.println("Покупатель купил продукт. Остаток: " + countProduct);
        this.notify();
    }

    public synchronized void makeProduct(){
        try {
            while (countProduct >= 5){
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countProduct++;
        System.out.println("Поставщик изготовил продукт. В наличии: " + countProduct);
        this.notify();

    }
}
