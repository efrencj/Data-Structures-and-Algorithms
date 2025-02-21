package TestPrac4.ex1;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static prac4.ex1.Indexer.*;

public class IndexerTest {

    @Test
    public void testSimple() throws IOException {
        Map<String, SortedSet<Integer>> index = createIndex(new File("Simple"));
        System.out.println(prettyStringIndex(index));

        assertEquals(3, index.size());
        assertTrue(index.containsKey("ESTAS"));
        assertEquals(new TreeSet<>(Arrays.asList(1, 2)), index.get("ESTAS"));
        assertTrue(index.containsKey("HELLO"));
        assertEquals(new TreeSet<>(Arrays.asList(3, 8)), index.get("HELLO"));
        assertTrue(index.containsKey("SIMPLE"));
        assertEquals(new TreeSet<>(Arrays.asList(5, 6, 7)), index.get("SIMPLE"));
    }

    @Test
    public void testSimplePrettyString() throws IOException {
        var expectedResult = "ESTAS: [1, 2]\n" +
                "HELLO: [3, 8]\n" +
                "SIMPLE: [5, 6, 7]\n";

        assertEquals(expectedResult, prettyStringIndex(createIndex(new File("Simple"))));
    }

    @Test
    public void testTurismeAfrica() throws IOException {
        Map<String, SortedSet<Integer>> index = createIndex(new File("TurismeAfrica"));

        //assertEquals(27, index.size());

        assertTrue(index.containsKey("ADDIS"));
        assertEquals(new TreeSet<>(Arrays.asList(6)), index.get("ADDIS"));

        assertTrue(index.containsKey("ÀFRICA"));
        assertEquals(new TreeSet<>(Arrays.asList(1, 11)), index.get("ÀFRICA"));

        assertTrue(index.containsKey("AMÈRICA"));
        assertEquals(new TreeSet<>(Arrays.asList(26)), index.get("AMÈRICA"));

        assertTrue(index.containsKey("CARIB"));
        assertEquals(new TreeSet<>(Arrays.asList(27)), index.get("CARIB"));

        assertTrue(index.containsKey("CONGO"));
        assertEquals(new TreeSet<>(Arrays.asList(18, 20)), index.get("CONGO"));

        assertTrue(index.containsKey("CONTINENT"));
        assertEquals(new TreeSet<>(Arrays.asList(1, 21)), index.get("CONTINENT"));

        assertTrue(index.containsKey("CREIXEMENT"));
        assertEquals(new TreeSet<>(Arrays.asList(1, 4)), index.get("CREIXEMENT"));

        assertTrue(index.containsKey("ETIÒPIA"));
        assertEquals(new TreeSet<>(Arrays.asList(4, 6)), index.get("ETIÒPIA"));

        assertTrue(index.containsKey("EUROPA"));
        assertEquals(new TreeSet<>(Arrays.asList(2, 25)), index.get("EUROPA"));

        assertTrue(index.containsKey("EUROPEUS"));
        assertEquals(new TreeSet<>(Arrays.asList(5)), index.get("EUROPEUS"));

        assertTrue(index.containsKey("INFRAESTRUCTURES"));
        assertEquals(new TreeSet<>(Arrays.asList(12)), index.get("INFRAESTRUCTURES"));

        assertTrue(index.containsKey("LALIBELA"));
        assertEquals(new TreeSet<>(Arrays.asList(6, 8)), index.get("LALIBELA"));

        assertTrue(index.containsKey("MASSIFICACIÓ"));
        assertEquals(new TreeSet<>(Arrays.asList(3)), index.get("MASSIFICACIÓ"));

        assertTrue(index.containsKey("MEDITERRÀNIA"));
        assertEquals(new TreeSet<>(Arrays.asList(21)), index.get("MEDITERRÀNIA"));

        assertTrue(index.containsKey("NAMÍBIA"));
        assertEquals(new TreeSet<>(Arrays.asList(12)), index.get("NAMÍBIA"));

        assertTrue(index.containsKey("NEOLÍTIC"));
        assertEquals(new TreeSet<>(Arrays.asList(10)), index.get("NEOLÍTIC"));

        assertTrue(index.containsKey("OPERADOR"));
        assertEquals(new TreeSet<>(Arrays.asList(5)), index.get("OPERADOR"));

        assertTrue(index.containsKey("PATRIMONI"));
        assertEquals(new TreeSet<>(Arrays.asList(7)), index.get("PATRIMONI"));

        assertTrue(index.containsKey("POLÍTICA"));
        assertEquals(new TreeSet<>(Arrays.asList(19)), index.get("POLÍTICA"));

        assertTrue(index.containsKey("POTENCIAL"));
        assertEquals(new TreeSet<>(Arrays.asList(1, 4, 11, 26, 27)), index.get("POTENCIAL"));

        assertTrue(index.containsKey("QUALITAT"));
        assertEquals(new TreeSet<>(Arrays.asList(15)), index.get("QUALITAT"));

        assertTrue(index.containsKey("SUDÀFRICA"));
        assertEquals(new TreeSet<>(Arrays.asList(12)), index.get("SUDÀFRICA"));

        assertTrue(index.containsKey("TURISME"));
        assertEquals(new TreeSet<>(Arrays.asList(21)), index.get("TURISME"));

        assertTrue(index.containsKey("UGANDA"));
        assertEquals(new TreeSet<>(Arrays.asList(15)), index.get("UGANDA"));

        assertTrue(index.containsKey("UNESCO"));
        assertEquals(new TreeSet<>(Arrays.asList(7)), index.get("UNESCO"));

        assertTrue(index.containsKey("VIOLÈNCIA"));
        assertEquals(new TreeSet<>(Arrays.asList(19)), index.get("VIOLÈNCIA"));

        assertTrue(index.containsKey("VIRUNGA"));
        assertEquals(new TreeSet<>(Arrays.asList(17)), index.get("VIRUNGA"));
    }

    @Test
    public void testTurismeAfricaPrettyString() throws IOException {
        var expectedResult = "ADDIS: [6]\n" +
                "ÀFRICA: [1, 11]\n" +
                "AMÈRICA: [26]\n" +
                "CARIB: [27]\n" +
                "CONGO: [18, 20]\n" +
                "CONTINENT: [1, 21]\n" +
                "CREIXEMENT: [1, 4]\n" +
                "ETIÒPIA: [4, 6]\n" +
                "EUROPA: [2, 25]\n" +
                "EUROPEUS: [5]\n" +
                "INFRAESTRUCTURES: [12]\n" +
                "LALIBELA: [6, 8]\n" +
                "MASSIFICACIÓ: [3]\n" +
                "MEDITERRÀNIA: [21]\n" +
                "NAMÍBIA: [12]\n" +
                "NEOLÍTIC: [10]\n" +
                "OPERADOR: [5]\n" +
                "PATRIMONI: [7]\n" +
                "POLÍTICA: [19]\n" +
                "POTENCIAL: [1, 4, 11, 26, 27]\n" +
                "QUALITAT: [15]\n" +
                "SUDÀFRICA: [12]\n" +
                "TURISME: [21]\n" +
                "UGANDA: [15]\n" +
                "UNESCO: [7]\n" +
                "VIOLÈNCIA: [19]\n" +
                "VIRUNGA: [17]\n";

        assertEquals(expectedResult, prettyStringIndex(createIndex(new File("TurismeAfrica"))));
    }
}
