public class Main {
    private static boolean isGuessedNumber = false;
    public static void main(String[] args){

        int randNumber = (int) (Math.random() * 1000000000);
        System.out.println(randNumber);
        Timer timer = new Timer(isGuessedNumber);
        Runnable objRunnable = new Runnable() {
            @Override
            public void run() {
                int number = -1;
                while (randNumber != number){
                    number = (int) (Math.random() *  1000000000);
                }

                if (randNumber == number) {
                    System.out.println(String.format("Find number == %d", number));
                    isGuessedNumber = true;
                    timer.setGuessedNumber(isGuessedNumber);
                }

            }
        };


        Thread thread1 = new Thread(objRunnable);
        Thread thread2 = new Thread(timer);
        Thread thread3 = new Thread( new Runnable() {
            @Override
            public void run() {
                int counter = 0;
                try {
                    while (!isGuessedNumber) {
                        counter++;
                        Thread.sleep(1000);
                        System.out.println(counter);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
