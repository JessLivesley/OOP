package petdaycare;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit tests for the Dragon class
 */
class DragonTest {
    private Dragon dragon;

    @BeforeEach
    void setUp() {
        // Create a Dragon object before each test
        dragon = new Dragon("Smaug", 150, 200.0, 8);
    }

    @Test
    void testConstructor() {
        assertEquals("Smaug", dragon.getName());
        assertEquals(150, dragon.getAge());
        assertEquals(200.0, dragon.getBaseFee());
        assertEquals(8, dragon.getFireBreathIntensity());
    }

    @Test
    void testCalculateDailyCost() {
        // Expected: 200 + (8 * 50) = 200 + 400 = 600
        assertEquals(600.0, dragon.calculateDailyCost(), 0.01);
    }

    @Test
    void testCalculateDailyCostWithDifferentIntensity() {
        Dragon smallDragon = new Dragon("Tiny", 5, 100.0, 3);
        // Expected: 100 + (3 * 50) = 100 + 150 = 250
        assertEquals(250.0, smallDragon.calculateDailyCost(), 0.01);
    }

    @Test
    void testInheritanceFromPet() {
        // Dragon should be an instance of Pet
        assertTrue(dragon instanceof Pet);
    }
}
