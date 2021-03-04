import java.util.concurrent.*;

public class Main {
    private static final int COUNT_CARS = 10;
    private static final Semaphore semaphoreTunnel = new Semaphore(3);
    private static final CountDownLatch countDownLatch = new CountDownLatch(10);
    private static final Phaser phaser = new Phaser(10);
    private static final ExecutorService executorService = Executors.newFixedThreadPool(COUNT_CARS);
    public static void main(String[] args) {
        String winner = "";
        long bestTime = Long.MAX_VALUE;
        //CountDownLatch mainDownLatch = new CountDownLatch(10);
        ConcurrentHashMap<String,Long> nameTime = new ConcurrentHashMap<>();

        for (int i = 0; i<COUNT_CARS; i++){
            Runnable runnable = () -> {
                String name = Thread.currentThread().getName();

                preparation(name);

                long timeStart = System.currentTimeMillis();
                usualRoad(name);
                tunnel(name);
                usualRoad(name);

                nameTime.put(name, System.currentTimeMillis() - timeStart);
                // mainDownLatch.countDown();
                phaser.arriveAndAwaitAdvance();
            };

            executorService.execute(runnable);
        }


        phaser.awaitAdvance(phaser.getPhase());
        executorService.shutdown();


        try {
            // mainDownLatch.await();
            for (String key : nameTime.keySet()){
                System.out.println(key + ": " + nameTime.get(key));
                if (bestTime > nameTime.get(key)){
                    bestTime = nameTime.get(key);
                    winner = key;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("WIN " + winner + ": " + bestTime);
    }

    public static void rndTimeSleep(){
        long millis = (long) (Math.random() * 5000 + 1000);
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void preparation(String name){
        System.out.println(name + ": preparation started.");
        rndTimeSleep();
        System.out.println(name + ": preparation finished.");
        countDownLatch.countDown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void usualRoad(String name){
        System.out.println(name + ": usual road started.");
        rndTimeSleep();
        System.out.println(name + ": usual road finished.");
    }

    public static void tunnel(String name){
        try {
            semaphoreTunnel.acquire();
            System.out.println(name + ": tunnel started.");
            rndTimeSleep();
            System.out.println(name + ": tunnel finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphoreTunnel.release();
        }
    }


}
