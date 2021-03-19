import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    private final static int CORES_AMOUNT = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        String srcFolder = "H:\\src";
        String dstFolder = "H:\\dst";

        File srcDir = new File(srcFolder);
        long start = System.currentTimeMillis();
        File[] files = srcDir.listFiles();

        if (files != null) {
            int lenForThread = files.length / CORES_AMOUNT;

            File[] files1 = new File[lenForThread];
            System.arraycopy(files, 0, files1, 0, lenForThread);
            File[] files2 = new File[lenForThread];
            System.arraycopy(files, lenForThread, files2, 0, lenForThread);
            File[] files3 = new File[lenForThread];
            System.arraycopy(files, lenForThread * 2, files3, 0, lenForThread);
            File[] files4 = new File[files.length - (lenForThread * 3)];
            System.arraycopy(files, lenForThread * 3, files4, 0, files.length - (lenForThread * 3));

            ResizerImg resizerImg1 = new ResizerImg(files1, dstFolder, start);
            new Thread(resizerImg1).start();

            ResizerImg resizerImg2 = new ResizerImg(files2, dstFolder, start);
            new Thread(resizerImg2).start();

            ResizerImg resizerImg3 = new ResizerImg(files3, dstFolder, start);
            new Thread(resizerImg3).start();

            ResizerImg resizerImg4 = new ResizerImg(files4, dstFolder, start);
            new Thread(resizerImg4).start();


        }
    }
}
