package TestPrac1;

import org.junit.jupiter.api.*;
import prac1.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VehicleParkImplementationTest {
    static Plate[] unknown = {
            new Plate(1, "9999", "KGT"), //0
            new Plate(6, "3344", "PPT"), //0
            new Plate(4, "0489", "JKP"), //3
            new Plate(5, "5239", "BRO")  //5
    };

    static Plate[] plates = {
            new Plate(1, "0254", "AAC"), //0
            new Plate(2, "3325", "KBD"), //1
            new Plate(3, "1245", "WJI"), //2
            new Plate(4, "0488", "JKP"), //3
            new Plate(4, "8745", "AAC"), //4
            new Plate(5, "5239", "BRN"), //5
            new Plate(6, "9157", "UTH"), //6
            new Plate(1, "6478", "ALP"), //7
            new Plate(1, "0254", "ATC"), //8
            new Plate(3, "1215", "KMD"), //9
            new Plate(2, "0036", "ZBD"), //10
            new Plate(2, "0036", "KBD"), //11
    };

    static String[] owners = {
            "Joan", "Carles", "Joan", "Pere", "Maria", "Josep",
            "Carles", "Maria", "Marta", "Pere", "Joan", "Joan"
    };

    static PrivateVehicle[] privs = new PrivateVehicle[6];
    static CommercialVehicle[] comms = new CommercialVehicle[6];

    static ArrayList<Vehicle> allVehicles = new ArrayList<>();
    static VehiclePark vp = new VehicleParkImplementation();

    static Plate aPlate = new Plate(3, "8978", "RTY");

    @BeforeAll
    static void setUp() {
        for (int i = 0; i < 6; i++) {
            privs[i] = new PrivateVehicle(plates[i], 10, owners[i], 4, 4);
            allVehicles.add(privs[i]);
        }
        for (int i = 0; i < 6; i++) {
            comms[i] = new CommercialVehicle(plates[i + 6], 10, owners[i + 6], 750, false);
            allVehicles.add(comms[i]);
        }

        vp.enter(Arrays.asList(comms));
        Arrays.stream(privs).forEach(p -> vp.enter(p));
    }

    @Test
    void inPark() {
        assertFalse(vp.inPark(unknown[0]), "This plate should not be already in the park");
        assertFalse(vp.inPark(unknown[1]), "This plate should not be already in the park");
        assertFalse(vp.inPark(unknown[2]), "This plate should not be already in the park");
        assertFalse(vp.inPark(unknown[3]), "This plate should not be already in the park");

        assertTrue(vp.inPark(plates[0]), "This plate should be in the vehiclepark");
        assertTrue(vp.inPark(plates[1]), "This plate should be in the vehiclepark");
        assertTrue(vp.inPark(plates[2]), "This plate should be in the vehiclepark");
        assertTrue(vp.inPark(plates[3]), "This plate should be in the vehiclepark");
    }

    @Test
    void enter() {
        NullPointerException exceptionNull = assertThrows(NullPointerException.class, () -> {
            vp.enter((Vehicle) null);
        });
        AlreadyStoredException exceptionStored = assertThrows(AlreadyStoredException.class, () -> {
            vp.enter(new PrivateVehicle(plates[1], 10, owners[2], 4, 4));
        });

        assertEquals("Null parameter", exceptionNull.getMessage(), "Exception message should match");
        assertEquals("Already there", exceptionStored.getMessage(), "Exception message should match");
    }

    @Test
    void testEnter() {
        Collection<Object> colStored = new ArrayList<>();

        colStored.addAll(Arrays.asList(privs));
        colStored.addAll(Arrays.asList(comms));
        colStored.add(null);
        colStored.add(new PrivateVehicle(aPlate, 5, "Carla", 4, 4));

        int stored = vp.    enter(colStored);

        assertEquals(1, stored, "You added more or less than the required amount");
    }

    @Test
    void leave() {
        assertFalse(vp.leave(unknown[0]), "This plate was never added in Vehiclepark");
        assertFalse(vp.leave(unknown[1]), "This plate was never added in Vehiclepark");
        assertFalse(vp.leave(unknown[2]), "This plate was never added in Vehiclepark");
        assertFalse(vp.leave(unknown[3]), "This plate was never added in Vehiclepark");

        assertTrue(vp.leave(plates[0]), "This plate was added in Vehiclepark");
        assertTrue(vp.leave(plates[1]), "This plate was added in Vehiclepark");
        assertTrue(vp.leave(plates[2]), "This plate was added in Vehiclepark");
        assertTrue(vp.leave(plates[3]), "This plate was added in Vehiclepark");
    }

    @Test
    void testLeave() {
        assertEquals(4, vp.leave(owners[2]).length, "The removed vehicles should have the same owner name");
        assertEquals(0, vp.leave(owners[2]).length, "Vehicles already removed");

        //Retornem Vehicles
        vp.enter(new PrivateVehicle(plates[0], 10, owners[0], 4, 4));
        vp.enter(new PrivateVehicle(plates[2], 10, owners[2], 4, 4));
        vp.enter(new CommercialVehicle(plates[10], 10, owners[10], 750, false));
        vp.enter(new CommercialVehicle(plates[11], 10, owners[11], 750, false));
    }

    @Test
    void containsDangerousPayload() {
        assertFalse(vp.containsDangerousPayload(), "There should be no dangerous payload in Vehiclepark");
        comms[3].setDangerousPayload(true);
        assertTrue(vp.containsDangerousPayload(), "VehiclePark should be dangerous");
    }
}