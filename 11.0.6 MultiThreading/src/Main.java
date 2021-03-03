
public class Main {
    private static final Object monitor = new Object();
    private static String next = "A";

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            synchronized (monitor) {
                try {
                    for (int i = 0; i < 5; i++) {
                        while (!next.equals("A")) {
                            monitor.wait();
                        }

                        System.out.print(next);
                        next = "B";
                        monitor.notifyAll();

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (monitor) {
                try {
                    for (int i = 0; i < 5; i++) {
                        while (!next.equals("B")) {
                            monitor.wait();
                        }

                        System.out.print(next);
                        next = "C";
                        monitor.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        });

        Thread thread3 = new Thread(() -> {
            synchronized (monitor) {
                try {
                    for (int i = 0; i < 5; i++) {
                        while (!next.equals("C")) {
                            monitor.wait();
                        }

                        System.out.print(next);
                        next = "A";
                        monitor.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        thread1.start();
        thread2.start();
        thread3.start();
    }
}
