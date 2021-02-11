public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (char i = 'a'; i<'z'; i++){
            System.out.print(i);
        }
    }
}
