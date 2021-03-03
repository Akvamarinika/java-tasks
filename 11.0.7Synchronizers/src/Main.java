import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        String winner = "";
        long bestTime = Long.MAX_VALUE;
        CountDownLatch mainDownLatch = new CountDownLatch(10);
        ConcurrentHashMap<String,Long> nameTime = new ConcurrentHashMap<>();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i<10; i++){
            new Thread(() -> {
                long millis = (long) (Math.random() * 5000 + 1000);
                String name = Thread.currentThread().getName();
                long timeStart = System.currentTimeMillis();
                try {
                    System.out.println(name + ": preparation started.");
                    Thread.sleep(millis);
                    System.out.println(name + ": preparation finished.");
                    countDownLatch.countDown();
                    countDownLatch.await();

                    System.out.println(name + ": usual road started.");
                    Thread.sleep(millis);
                    System.out.println(name + ": usual road finished.");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    semaphore.acquire();
                    System.out.println(name + ": tunnel started.");
                    Thread.sleep(millis);
                    System.out.println(name + ": tunnel finished.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }

                try {
                    System.out.println(name + ": usual_2 road started.");
                    Thread.sleep(millis);
                    System.out.println(name + ": usual_2 road finished.");
                    nameTime.put(name, System.currentTimeMillis() - timeStart);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainDownLatch.countDown();
            }).start();
        }

        try {
            mainDownLatch.await();
            for (String key : nameTime.keySet()){
                System.out.println(key + ": " + nameTime.get(key));
                if (bestTime > nameTime.get(key)){
                    bestTime = nameTime.get(key);
                    winner = key;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("WIN " + winner + ": " + bestTime);
    }
}
