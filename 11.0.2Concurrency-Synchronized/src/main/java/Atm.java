public class Atm {

    private int balance = 100_000;
    private final Object monitor = new Object();

    public int getBalance() {
        return balance;
    }

    public void withdrawMoney(String name, int amount){
        synchronized (monitor) {
            System.out.println(name + " подошел к банкомату");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (balance >= amount) {
                balance -= amount;
                System.out.println(name + " вывел " + amount + " руб. В банкомате осталось " + balance + " руб.");
            } else {
                System.out.println("В банкомате недостаточно денег для " + name);
            }
        }
    }
}
