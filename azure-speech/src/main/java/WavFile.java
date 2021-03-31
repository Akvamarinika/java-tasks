import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WavFile {
    private static final int INT_SIZE = 4;
    private byte[] dataWav;
    private AudioFormat audioFormat;
    private AudioInputStream audioInputStream;
    private long framesCount;
    private long wavLength;

    WavFile(File file) throws IOException, UnsupportedAudioFileException {
        if (!file.exists()){
            throw new FileNotFoundException(file.getAbsolutePath());
        }
        audioInputStream = AudioSystem.getAudioInputStream(file);
        audioFormat = audioInputStream.getFormat();
        framesCount = audioInputStream.getFrameLength();
        wavLength = framesCount * audioFormat.getSampleSizeInBits() * audioFormat.getChannels()/8;
        dataWav = new byte[(int) wavLength];
        audioInputStream.read(dataWav);
    }

    private AudioFormat getAudioFormat(){
        return audioFormat;
    }

    private long getFramesCount(){
        return framesCount;
    }

    public long getWavLength() {
        return wavLength;
    }

    public double getDurationTime(){
        return getFramesCount() / getAudioFormat().getFrameRate();
    }

    public double getDurationSymbol(int countSymbolsInFile){
        return getDurationTime() / countSymbolsInFile;
    }
}
