public class Timer implements Runnable{
    private boolean isGuessedNumber;
    Timer(boolean isGuessedNumber){
        this.isGuessedNumber = isGuessedNumber;
    }

    public void setGuessedNumber(boolean isGuessedNumber) {
        this.isGuessedNumber = isGuessedNumber;
    }

    @Override
    public void run(){
        int counter = 10000;
        try {
            while (!isGuessedNumber){
                counter++;
                Thread.sleep(1000);
                System.out.println(counter);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
