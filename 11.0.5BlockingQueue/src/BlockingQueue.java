import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    private final Queue<Runnable> queue = new LinkedList<>();
    private final Object monitor = new Object();

    public void add(Runnable runnable){
        synchronized (monitor) {
            queue.add(runnable);
            monitor.notify();
        }
    }

    public Runnable take(){
        synchronized (monitor) {
            if (queue.isEmpty()) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return queue.poll();
        }
    }
}
