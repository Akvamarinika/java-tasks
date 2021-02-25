import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mask {
    private static final int BIT = 8;
    private static List<Integer> mask;

    Mask(){
        mask = new ArrayList<>();
    }

    public static String calculatingSubnetMask(int numberOfBits) {
        int bitRemainder;
        int sumEmptyBites = 0;

        if (numberOfBits >= 0 && numberOfBits <= 32){

            while (numberOfBits > BIT){
                numberOfBits -= BIT;
                mask.add(255);
            }

            bitRemainder = BIT - numberOfBits - 1;
            while (bitRemainder != -1){
                sumEmptyBites += (int) Math.pow(2, bitRemainder);
                bitRemainder--;
            }
            mask.add(255 - sumEmptyBites);

            while (mask.size() < 4){
                mask.add(0);
            }

            return mask.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining("."));
        }
        return "Number of bits entered incorrectly!";
    }

}
