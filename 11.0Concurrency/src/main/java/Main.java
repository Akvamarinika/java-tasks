public class Main {
    public static void main(String[] args){
        System.out.println("start");
        System.out.println("stream1: ");
        MyThread thread = new MyThread();
        thread.start();
        System.out.println("stream2: ");
        MyRunnable runnable = new MyRunnable();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        System.out.println("\nstream3: ");
        Thread thread2 = new Thread(new Runnable(){
            @Override
            public void run() {
                for (char i = 'A'; i<'Z'; i++){
                    System.out.print(i);
                }
            }
        });
        thread2.start();
        System.out.println("\nfinish");
    }
}
