
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MaskTest {

    @Test
    public void calculatingSubnetMaskT1() {
        assertEquals("255.255.255.0", Mask.calculatingSubnetMask(24));
    }

    @Test
    public void calculatingSubnetMaskT2() {
        assertEquals("255.255.255.252", Mask.calculatingSubnetMask(30));
    }

    @Test
    public void calculatingSubnetMaskT3() {
        assertEquals("0.0.0.0", Mask.calculatingSubnetMask(0));
    }

    @Test
    public void calculatingSubnetMaskT4() {
        assertEquals("248.0.0.0", Mask.calculatingSubnetMask(5));
    }

    @Test
    public void calculatingSubnetMaskT5() {
        assertEquals("255.254.0.0", Mask.calculatingSubnetMask(15));
    }

    @Test
    public void calculatingSubnetMaskT6() {
        assertEquals("255.255.255.255", Mask.calculatingSubnetMask(32));
    }
}