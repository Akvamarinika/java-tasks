public class MyRunnable implements Runnable {
    private float[] array;

    public MyRunnable(float[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i<array.length; i++ ){
            float f = (float) i;
            array[i] = (float)(array[i] * Math.sin(0.2f + f / 5) * Math.cos(0.2f + f / 5) * Math.cos(0.4f + f / 2));
        }
    }

}
