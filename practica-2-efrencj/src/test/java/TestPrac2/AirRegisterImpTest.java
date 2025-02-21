package TestPrac2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pr2.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


class AirRegisterImpTest {

    static Company[] companies = {
            new Company("AIR MEATBALL","Canada"),
            new Company("AEROPLOF","Russia"),
            new Company("LIMPBIRD","North Korea"),
            new Company("FEATHERLESS","Spain")
    };

    static Company [] unknownCompanies = {
            new Company("FLY HIGH","North Korea"),
            new Company("AIR xMEATBALL","Canada"),
            new Company("LIMPBRD","North Korea"),
            new Company("FEATHERLES","Spain")
    };

    static TreeSet[] sets = new TreeSet[companies.length];

    static Aircraft[] aircrafts = {
            new Aircraft("Flying Saucer", 1999, AircraftType.TWO_ENG, "arc", "0001"),
            new Aircraft("Fat goose", 2005, AircraftType.FOUR_ENG, "arc", "0002"),
            new Aircraft("Stella ", 2010, AircraftType.FOUR_ENG, "zet", "0001"),
            new Aircraft("Sky Queen", 1980, AircraftType.SEV_BLADE_PROP, "kad", "0001"),
            new Aircraft("Robin & Batman", 2000, AircraftType.ONE_BLADE_PROP, "kad", "0005"),
            new Aircraft("Pink heavens", 1997, AircraftType.ONE_ENG, "kad", "0009"),
            new Aircraft("Dizzy wizzy", 2012, AircraftType.ONE_BLADE_PROP, "kad", "0022"),
            new Aircraft("Rainbow candy", 2008, AircraftType.TWO_ENG, "arc", "00021"),
            new Aircraft("Squared light", 2010, AircraftType.FOUR_ENG, "arc", "0033"),
            new Aircraft("Desiree", 2007, AircraftType.TWO_ENG, "zet", "00011"),
            new Aircraft("Candy crush", 2013, AircraftType.TWO_ENG, "zet", "00015"),
            new Aircraft("Pop Corn Wings", 1996, AircraftType.ONE_BLADE_PROP, "arc", "00045"),
            new Aircraft("Flying Kiss", 2001, AircraftType.ONE_BLADE_PROP, "arc", "00046"),
            new Aircraft("Flying French Kiss", 2009, AircraftType.ONE_ENG, "kad", "00046"),
            new Aircraft("Enola Guay", 1977, AircraftType.SEV_BLADE_PROP, "kad", "0099"),
    };

    static AircraftID[] unknownIDs = {
            new AircraftID("arc", "0000"),
            new AircraftID("arc", "0003"),
            new AircraftID("zed", "0001"),
            new AircraftID("zet", "1000"),
            new AircraftID("KAs", "0001"),
            new AircraftID("kad", "0300")
    };

    static TreeMap<Company, TreeSet<Aircraft>> all = new TreeMap<Company, TreeSet<Aircraft>>();


    static AirRegisterImp registre = new AirRegisterImp();


    @BeforeAll
    static void setUp() {
        for (int i=0; i<companies.length; i++) {
            sets[i] = new TreeSet<Aircraft>();
        }

        for (int i=0; i<aircrafts.length; i++) {
            sets[i%companies.length].add(aircrafts[i]);
        }

        for (int i=0; i<companies.length; i++) {
            all.put(companies[i], sets[i]);
        }
    }

    @Test
    @Order(1)
    void addCompany() {
        for (int i=0; i<companies.length; i++)
            assertTrue(registre.addCompany(companies[i]), "These companies should be added");

        for (int i=0; i<companies.length; i++)
            assertFalse(registre.addCompany(companies[i]), "addCompany. We should not add companies that are already in the register");
    }

    @Test
    void registerAircraft() {

        UnknownCompanyException exceptionUnknownComp = assertThrows(UnknownCompanyException.class, () ->
            registre.registerAircraft(unknownCompanies[0], aircrafts[0])
        );

        assertEquals("Company does not exist", exceptionUnknownComp.getMessage(), "Exception message should match");

        for (Company company : all.keySet()) {
            for (Aircraft aircraft : all.get(company))
                assertTrue(registre.registerAircraft(company, aircraft), "We expect to add the Aircrafts to the companies");
        }

        DifferentCompanyException exceptionDifferent = assertThrows(DifferentCompanyException.class, () -> {
            registre.registerAircraft(companies[1], aircrafts[0]);
        });

        assertEquals("Aircraft already belongs to another comapany", exceptionDifferent.getMessage(), "Exception message should match");

        for (Company company : all.keySet()) {
            for (Aircraft aircraft : all.get(company))
                assertFalse(registre.registerAircraft(company, aircraft), "We can't add the Aircrafts to the same companies twice");
        }

    }

    @Test
    void findCompany() {

        for (Company realCompany : all.keySet()) {
            for (Aircraft aircraft : all.get(realCompany)) {
                Company company = registre.findCompany(new AircraftID(aircraft.getId().getAlpha(), aircraft.getId().getBeta()));
                assertEquals(realCompany, company,"findCompany should return the company of the registered Aircraft");
            }
        }
        for (AircraftID id : unknownIDs) {
            assertNull(registre.findCompany(id), "findCompany should not find a company with a plane not registered");
        }

    }

    @Test
    void registeredAircrafts() {

        for (Company company : all.keySet()) {
            TreeSet<Aircraft> realSet = all.get(company);
            SortedSet<Aircraft> returned = registre.registeredAircrafts(company);

            assertEquals(realSet, returned, "registeredAircrafts should find the Aircrafts registered to the company");

            Aircraft [] obs = realSet.toArray(new Aircraft[0]);
            Arrays.sort(obs, (a,b)->a.getYear()-b.getYear());

            assertArrayEquals(obs, returned.toArray(), "Result should be correctly ordered");
        }

        assertNull(registre.registeredAircrafts(unknownCompanies[0]), "registeredAircrafts should not find an Aircraft" );

    }

    @Test
    void findCompanyByType() {

        TreeSet<Company> expected = new TreeSet<Company>();
        TreeSet<Aircraft> itsAircrafts;
        SortedSet<Company> result = null;

        for (AircraftType type : AircraftType.values()) {
            expected.clear();
            for (Company owner : companies) {
                itsAircrafts = all.get(owner);
                for (Aircraft a : itsAircrafts) {
                    if (a.getType()==type) {
                        expected.add(owner);
                    }
                }
            }
            result = registre.findCompanyByType(type);

            assertEquals(expected, result, "findCompanyByType should find the same amount of Companies as the ones found in expected ");
            assertArrayEquals(expected.toArray(), result.toArray(), "Result should be correctly ordered");

        }

    }
}