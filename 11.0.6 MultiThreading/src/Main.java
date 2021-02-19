import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    private static final Object monitor = new Object();
    private static BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {


        new Thread(() -> {
            synchronized (monitor){
                for (int i = 0; i < 5; i++){
                    System.out.println("A");
                }
            }
        });

        new Thread(() -> {
            synchronized (monitor){
                for (int i = 0; i < 5; i++){
                    System.out.println("B");
                }
            }

        });

        new Thread(() -> {
            synchronized (monitor){
                for (int i = 0; i < 5; i++){
                    System.out.println("C");
                }
            }
        });


    }

   /* public static void addThread(){
        synchronized (monitor){
            if (blockingQueue.isEmpty())
        }
    }*/
}
