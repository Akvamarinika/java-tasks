import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3, new ThreadFactory() {
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                return thread;
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                try {
                    for (int i=0; i < 10000; i++ ){
                            Thread.sleep(500);
                            System.out.print(".");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

       Future<String> futureName = executorService.submit(new Callable<String>() {
           @Override
           public String call() throws Exception {
               Thread.sleep(5000);
               return "John";
           }
       });

       Future<Integer> futureAge = executorService.submit(new Callable<Integer>() {
           @Override
           public Integer call() throws Exception {
               Thread.sleep(5000);
               return 20;
           }
       });

        try {
            String name = futureName.get();
            int age = futureAge.get();
            System.out.println("\nName: " + name + " Age: " + age);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
