package petdaycare;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit tests for the Unicorn class
 */
class UnicornTest {
    private Unicorn unicorn;

    @BeforeEach
    void setUp() {
        // Create a Unicorn object before each test
        unicorn = new Unicorn("Sparkles", 7, 100.0, 5);
    }

    @Test
    void testConstructor() {
        assertEquals("Sparkles", unicorn.getName());
        assertEquals(7, unicorn.getAge());
        assertEquals(100.0, unicorn.getBaseFee());
        assertEquals(5, unicorn.getGlitterLevel());
    }

    @Test
    void testCalculateDailyCost() {
        // Expected: 100 + (5 * 30) = 100 + 150 = 250
        assertEquals(250.0, unicorn.calculateDailyCost(), 0.01);
    }

    @Test
    void testCalculateDailyCostWithDifferentGlitter() {
        Unicorn cleanUnicorn = new Unicorn("Crystal", 10, 80.0, 2);
        // Expected: 80 + (2 * 30) = 80 + 60 = 140
        assertEquals(140.0, cleanUnicorn.calculateDailyCost(), 0.01);
    }

    @Test
    void testInheritanceFromPet() {
        // Unicorn should be an instance of Pet
        assertTrue(unicorn instanceof Pet);
    }
}
