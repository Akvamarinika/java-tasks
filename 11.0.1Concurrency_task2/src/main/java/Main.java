import java.util.Arrays;

public class Main {
    public static final int SIZE = 20_000_000;
    private static float[] array = new float[SIZE];
    private static float[] arrayForStreams = new float[SIZE];
    private static long timeStart;
    private static long timeEnd;

    public static void main(String[] args){
        withoutConcurrency();
        withConcurrency();

       print(arrayForStreams);

    }

    public static void withoutConcurrency(){
        one(array);
        timeStart = System.currentTimeMillis();
        for (int i = 0; i<SIZE; i++ ){
            float f = (float) i;
            array[i] = (float)(array[i] * Math.sin(0.2f + f / 5) * Math.cos(0.2f + f / 5) * Math.cos(0.4f + f / 2));
        }
        timeEnd = System.currentTimeMillis();
        System.out.println("withoutConcurrency: " + (timeEnd - timeStart) + " ms");
    }

    public static void withConcurrency(){
        one(array);
        timeStart = System.currentTimeMillis();
        float[] arrayLeft = new float[array.length / 2];
        float[] arrayRight = new float[array.length - (array.length / 2)];
        one(arrayLeft);
        one(arrayRight);
        MyRunnable runnable = new MyRunnable(arrayLeft);
        MyRunnable runnable2 = new MyRunnable(arrayRight);
        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(runnable2);
        thread.start();
        thread2.start();
        try{
            thread.join();
            thread2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.arraycopy(arrayLeft,0,arrayForStreams,0,arrayLeft.length);
        System.arraycopy(arrayRight,0,arrayForStreams,arrayLeft.length,arrayRight.length);
        timeEnd = System.currentTimeMillis();
        System.out.println("withConcurrency: " + (timeEnd - timeStart) + " ms");
    }

    public static void one(float[] arr){
        Arrays.fill(arr, 1f);
    }

    public static void print(float[] arr){
        for (int i = 0; i<50; i++ ){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
