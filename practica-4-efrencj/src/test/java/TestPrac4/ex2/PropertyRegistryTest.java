package TestPrac4.ex2;

import org.junit.jupiter.api.Test;
import prac4.ex2.Owner;
import prac4.ex2.PropertyRegistry;
import prac4.ex2.Residence;

import java.io.*;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class PropertyRegistryTest {
    @Test
    public void testInfrastructureInitialization() throws NoSuchFieldException, IllegalAccessException {
        PropertyRegistry registry = new PropertyRegistry();

        // Get the private field using reflection
        Field infrastructureField = PropertyRegistry.class.getDeclaredField("infrastructure");
        infrastructureField.setAccessible(true); // Set the field to be accessible

        Map infrastructure = (Map) infrastructureField.get(registry);
        assertEquals(0, infrastructure.size());
    }

    @Test
    public void testInfrastructureData() throws NoSuchFieldException, IllegalAccessException {
        PropertyRegistry registry = new PropertyRegistry();

        // Get the private field using reflection
        Field infrastructureField = PropertyRegistry.class.getDeclaredField("infrastructure");
        infrastructureField.setAccessible(true); // Set the field to be accessible

        Map<Residence, List<Owner>> data = new TreeMap<Residence, List<Owner>>(new Comparator<Residence>() {
            public int compare(Residence h1, Residence h2) {
                if (h1.getSurfaceArea() > h2.getSurfaceArea()) return 1;
                else if (h1.getSurfaceArea() < h2.getSurfaceArea()) return -1;
                else return 0;
            }
        });

        Residence r = new Residence("Street 1", 1, 40.0);
        List<Owner> ol = new ArrayList<>();
        ol.add(new Owner("John Doe", 1, true)); // Add an Owner object
        ol.add(new Owner("Jane Smith", 2, false)); // Add another Owner object
        data.put(r, ol);

        // Set the infrastructure field using reflection and test the data introduced
        infrastructureField.set(registry, data);

        TreeMap<Residence, List<Owner>> infrastructure = (TreeMap<Residence, List<Owner>>) infrastructureField.get(registry);

        assertTrue(infrastructure.containsKey(r));
        assertEquals("Street 1", infrastructure.firstKey().getAddress());
        assertEquals(1, infrastructure.firstKey().getRooms());
        assertEquals(40.0, infrastructure.firstKey().getSurfaceArea());

        assertEquals("John Doe", infrastructure.firstEntry().getValue().get(0).getName());
        assertEquals(1, infrastructure.firstEntry().getValue().get(0).getId());
        assertEquals(true, infrastructure.firstEntry().getValue().get(0).isIndividualProperty());

        assertEquals("Jane Smith", infrastructure.firstEntry().getValue().get(1).getName());
        assertEquals(2, infrastructure.firstEntry().getValue().get(1).getId());
        assertEquals(false, infrastructure.firstEntry().getValue().get(1).isIndividualProperty());
    }

    @Test
    public void testInfrastructureLoadBinaryData() throws NoSuchFieldException, IllegalAccessException, IOException {
        PropertyRegistry registry = new PropertyRegistry();
        registry.loadFromBinFile(new File("RegPropietat.bin"));

        Residence r1 = new Residence("Ronda dels enamorats s/n", 2, 55.0);
        Residence r2 = new Residence("Carrer del mar 33, Badalona", 3, 72.5);
        Owner o1 = new Owner("Agropecuaria del Vallès", 787777, false);
        Owner o2 = new Owner("Fermí Fonoll Fuster", 78789789, true);
        Residence r3 = new Residence("Carrer del Bon Repòs 104 Igualada", 4, 99.2);
        Owner o3 = new Owner("Carles Cunill Cumalat", 14589634, true);
        Owner o4 = new Owner("Habivuit SL", 85633, false);
        Residence r4 = new Residence("Avinguda de les vinyes 77, Sant Feliu del Llobregat", 4, 102.3);
        Owner o5 = new Owner("Carme Cabrera Canela", 74123654,true);
        Residence r5 = new Residence("Carrer de l'Esglèsia 1, Dosrius", 5, 124.1);
        Owner o6 = new Owner("Alicia Armenteres Amorós", 65471233, true);
        Owner o7 = new Owner("Bibiana Bonig Bonveí", 458523369, true);
        Owner o8 = new Owner("Eduard Espriu Estornell", 78778965, true);
        Owner o9 = new Owner("Mariona Mercadé Marfà", 78964123, true);

        // Get the private field using reflection
        Field infrastructureField = PropertyRegistry.class.getDeclaredField("infrastructure");
        infrastructureField.setAccessible(true); // Set the field to be accessible

        TreeMap<Residence, List<Owner>> infrastructure = (TreeMap<Residence, List<Owner>>) infrastructureField.get(registry);

        assertTrue(infrastructure.containsKey(r1));
        assertEquals(0, infrastructure.get(r1).size());

        assertTrue(infrastructure.containsKey(r2));
        assertEquals(2, infrastructure.get(r2).size());
        assertTrue(infrastructure.get(r2).contains(o1));
        assertTrue(infrastructure.get(r2).contains(o2));

        assertTrue(infrastructure.containsKey(r3));
        assertEquals(2, infrastructure.get(r3).size());
        assertTrue(infrastructure.get(r3).contains(o3));
        assertTrue(infrastructure.get(r3).contains(o4));

        assertTrue(infrastructure.containsKey(r4));
        assertEquals(1, infrastructure.get(r4).size());
        assertTrue(infrastructure.get(r4).contains(o5));

        assertTrue(infrastructure.containsKey(r5));
        assertEquals(5, infrastructure.get(r5).size());
        assertTrue(infrastructure.get(r5).contains(o1));
        assertTrue(infrastructure.get(r5).contains(o6));
        assertTrue(infrastructure.get(r5).contains(o7));
        assertTrue(infrastructure.get(r5).contains(o8));
        assertTrue(infrastructure.get(r5).contains(o9));
    }

    public static boolean areFilesEqual(File file1, File file2) throws IOException {
        FileInputStream fis1 = new FileInputStream(file1);
        FileInputStream fis2 = new FileInputStream(file2);

        byte[] buffer1 = new byte[(int) file1.length()];
        byte[] buffer2 = new byte[(int) file2.length()];

        fis1.read(buffer1);
        fis2.read(buffer2);

        // Close the streams
        fis1.close();
        fis2.close();

        return Arrays.equals(buffer1, buffer2);
    }

    @Test
    public void testInfrastructureDumpTextFile() throws IOException, NoSuchAlgorithmException {
        PropertyRegistry registry = new PropertyRegistry();
        registry.loadFromBinFile(new File("RegPropietat.bin"));

        registry.dumpToTextFile(new File("Output.txt"));

        assertTrue(!areFilesEqual(new File("CorrectOutputEx2B.txt"), new File("Output.txt")));
    }
}
