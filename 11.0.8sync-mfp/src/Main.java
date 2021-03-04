public class Main {
    public static void main(String[] args) {
        MFP mfp = new MFP();

        for (int user = 0; user<10; user++){
            final int userIdx = user;
            new Thread(() -> {
                mfp.scan(userIdx, 5);
                mfp.print(userIdx, 3);
            }).start();
        }
    }
}
