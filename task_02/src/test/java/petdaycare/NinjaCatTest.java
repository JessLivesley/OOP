package petdaycare;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit tests for the NinjaCat class
 */
class NinjaCatTest {
    private NinjaCat ninjaCat;

    @BeforeEach
    void setUp() {
        // Create a NinjaCat object before each test
        ninjaCat = new NinjaCat("Shadow", 3, 200.0, 9);
    }

    @Test
    void testConstructor() {
        assertEquals("Shadow", ninjaCat.getName());
        assertEquals(3, ninjaCat.getAge());
        assertEquals(200.0, ninjaCat.getBaseFee());
        assertEquals(9, ninjaCat.getStealthLevel());
    }

    @Test
    void testCalculateDailyCost() {
        // Expected: 200 - (9 * 10) = 200 - 90 = 110
        assertEquals(110.0, ninjaCat.calculateDailyCost(), 0.01);
    }

    @Test
    void testCalculateDailyCostWithDifferentStealth() {
        NinjaCat loudCat = new NinjaCat("Whiskers", 2, 150.0, 3);
        // Expected: 150 - (3 * 10) = 150 - 30 = 120
        assertEquals(120.0, loudCat.calculateDailyCost(), 0.01);
    }

    @Test
    void testInheritanceFromPet() {
        // NinjaCat should be an instance of Pet
        assertTrue(ninjaCat instanceof Pet);
    }
}
