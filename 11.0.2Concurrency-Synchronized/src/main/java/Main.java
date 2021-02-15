public class Main {
    public static void main(String[] args) {
        Atm atm = new Atm();

        Thread client1 = new Thread(new Runnable(){
            private String name = "Ivan";
            public String getName() {
                return name;
            }

            @Override
            public void run() {
                    atm.withdrawMoney(this.getName(), 50000);

            }
        });

        Thread client2 = new Thread(new Runnable() {
            private String name = "Kate";
            public String getName() {
                return name;
            }
            @Override
            public void run() {
                /*try {
                    client1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                  atm.withdrawMoney(this.getName(), 80000);

            }
        });

        Thread client3 = new Thread(new Runnable() {
            private String name = "Alex";
            public String getName() {
                return name;
            }
            @Override
            public void run() {
                /*try {
                    client1.join();
                    client2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                    atm.withdrawMoney(this.getName(), 50000);
            }
        });

        client1.start();
        client2.start();
        client3.start();

    }
}
