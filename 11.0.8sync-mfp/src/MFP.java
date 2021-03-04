import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MFP {
    static final Lock lock = new ReentrantLock();

    public void print(int userIdx, int pages){
        lock.lock();
        try {
            for (int i = 1; i<=pages; i++){
                System.out.println("User " + userIdx + ": Отпечатано " + i + " стр.");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public synchronized void scan(int userIdx, int pages){
        for (int i = 1; i<=pages; i++){
            System.out.println("User " + userIdx + ": Отсканировано " + i + " стр.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
