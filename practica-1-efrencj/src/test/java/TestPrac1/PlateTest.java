package TestPrac1;

import org.junit.jupiter.api.Test;
import prac1.Plate;

import static org.junit.jupiter.api.Assertions.*;

class PlateTest {

    @Test
    void compareTo() {
        Plate testPlateByAreaCode = new Plate(6, "0234", "ARD");
        Plate testPlateByAreaCodeCompared = new Plate(4, "0234", "ARD");

        Plate testPlateByPrefix = new Plate(4, "3234", "ACD");
        Plate testPlateByPrefixCompared = new Plate(4, "2234", "PRQ");

        Plate testPlateBySufix = new Plate(4, "0000", "PCD");
        Plate testPlateBySufixCompared = new Plate(4, "0000", "ORQ");

        assertEquals(1, testPlateByAreaCode.compareTo(testPlateByAreaCodeCompared));
        assertEquals(1, testPlateByPrefix.compareTo(testPlateByPrefixCompared));
        assertEquals(1, testPlateBySufix.compareTo(testPlateBySufixCompared));
    }

    @Test
    void testEquals() {
        Plate testPlateEquals = new Plate(5, "0234", "ACD");
        Plate tesPlateEqualsCompared = new Plate(5, "0234", "ACD");

        assertTrue(testPlateEquals.equals(tesPlateEqualsCompared));
    }
}
