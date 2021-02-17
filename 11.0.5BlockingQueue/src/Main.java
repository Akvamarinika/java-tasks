//import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue();
        //BlockingQueue<Runnable> blockingQ = new LinkedBlockingQueue<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int counter = 0;
                while (true){
                   System.out.println(counter);
                   counter++;
                   Thread thread = new Thread(blockingQueue.take());
                   thread.start();
                }
            }
        }).start();



        for (int i = 0; i<10; i++){
            final int finalI = i;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            blockingQueue.add(new Runnable() {
                @Override
                public void run() {
                    System.out.println("*** " + finalI);
                }
            });
        }
    }
}
