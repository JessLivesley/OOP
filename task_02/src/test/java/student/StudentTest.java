package student;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Student.Student;

/**
 * Test suite for Challenge 1: Student Grade Tracker
 * Tests both functionality and marking rubric criteria
 * 
 * MARKING RUBRIC (5 points):
 * 1. All fields private (1 pt)
 * 2. Proper getters implemented (1 pt)
 * 3. Validation in setGrade() (1 pt)
 * 4. Read-only fields (no setters for id/name) (1 pt)
 * 5. Auto-update of isPassing (1 pt)
 */
@DisplayName("Challenge 1: Encapsulation Tests")
public class StudentTest {
    
    private Student student;
    
    @BeforeEach
    public void setUp() {
        student = new Student("S001", "Alice", 75);
    }
    
    // ============================================
    // RUBRIC CRITERION 1: All fields are private (1 pt)
    // ============================================
    
    @Test
    @DisplayName("Criterion 1: All fields are private")
    public void testAllFieldsArePrivate() {
        Field[] fields = Student.class.getDeclaredFields();
        assertTrue(fields.length > 0, "Student class should have fields");
        
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), 
                "Field '" + field.getName() + "' should be private");
        }
        System.out.println("✓ PASS: All fields are private");
    }
    
    // ============================================
    // RUBRIC CRITERION 2: Proper getters implemented (1 pt)
    // ============================================
    
    @Test
    @DisplayName("Criterion 2: All required getters exist")
    public void testGettersExist() {
        assertDoesNotThrow(() -> Student.class.getMethod("getName"));
        assertDoesNotThrow(() -> Student.class.getMethod("getStudentId"));
        assertDoesNotThrow(() -> Student.class.getMethod("getGrade"));
        assertDoesNotThrow(() -> Student.class.getMethod("isPassing"));
        System.out.println("✓ PASS: All required getters exist");
    }
    
    @Test
    @DisplayName("Criterion 2: Getters return correct values")
    public void testGettersReturnCorrectValues() {
        assertEquals("S001", student.getStudentId());
        assertEquals("Alice", student.getName());
        assertEquals(75, student.getGrade());
        assertTrue(student.isPassing());
        System.out.println("✓ PASS: Getters return correct values");
    }
    
    // ============================================
    // RUBRIC CRITERION 3: Validation in setGrade() (1 pt)
    // ============================================
    
    @Test
    @DisplayName("Criterion 3: setGrade accepts valid values (0-100)")
    public void testSetGradeAcceptsValidValues() {
        student.setGrade(85);
        assertEquals(85, student.getGrade());
        
        student.setGrade(0);
        assertEquals(0, student.getGrade());
        
        student.setGrade(100);
        assertEquals(100, student.getGrade());
        
        System.out.println("✓ PASS: setGrade accepts valid values (0-100)");
    }
    
    @Test
    @DisplayName("Criterion 3: setGrade rejects invalid values")
    public void testSetGradeRejectsInvalidValues() {
        int originalGrade = student.getGrade();
        
        // Test negative value
        student.setGrade(-10);
        assertEquals(originalGrade, student.getGrade(), 
            "Grade should not change when invalid value is provided");
        
        // Test value over 100
        student.setGrade(150);
        assertEquals(originalGrade, student.getGrade(), 
            "Grade should not change when invalid value is provided");
        
        System.out.println("✓ PASS: setGrade rejects invalid values");
    }
    
    @Test
    @DisplayName("Criterion 3: setGrade displays error message")
    public void testSetGradeShowsErrorMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        student.setGrade(150);
        String output = outContent.toString();
        
        assertTrue(output.toLowerCase().contains("error") || 
                   output.toLowerCase().contains("invalid") ||
                   output.toLowerCase().contains("must be"),
            "Should display error message for invalid grade");
        
        System.setOut(System.out);
        System.out.println("✓ PASS: setGrade displays error message");
    }
    
    // ============================================
    // RUBRIC CRITERION 4: Read-only fields (1 pt)
    // ============================================
    
    @Test
    @DisplayName("Criterion 4: No setter for studentId (read-only)")
    public void testNoSetterForStudentId() {
        try {
            Student.class.getMethod("setStudentId", String.class);
            fail("setStudentId() method should not exist - studentId should be read-only");
        } catch (NoSuchMethodException e) {
            System.out.println("✓ PASS: No setter for studentId (read-only)");
        }
    }
    
    @Test
    @DisplayName("Criterion 4: No setter for name (read-only)")
    public void testNoSetterForName() {
        try {
            Student.class.getMethod("setName", String.class);
            fail("setName() method should not exist - name should be read-only");
        } catch (NoSuchMethodException e) {
            System.out.println("✓ PASS: No setter for name (read-only)");
        }
    }
    
    // ============================================
    // RUBRIC CRITERION 5: Auto-update of isPassing (1 pt)
    // ============================================
    
    @Test
    @DisplayName("Criterion 5: isPassing auto-updates when grade changes")
    public void testIsPassingAutoUpdatesWhenGradeChanges() {
        // Test passing grade
        student.setGrade(75);
        assertTrue(student.isPassing(), "Student should be passing with grade 75");
        
        // Test failing grade
        student.setGrade(45);
        assertFalse(student.isPassing(), "Student should not be passing with grade 45");
        
        // Test boundary - exactly 50
        student.setGrade(50);
        assertTrue(student.isPassing(), "Student should be passing with grade 50");
        
        // Test boundary - just below 50
        student.setGrade(49);
        assertFalse(student.isPassing(), "Student should not be passing with grade 49");
        
        System.out.println("✓ PASS: isPassing auto-updates when grade changes");
    }
    
    @Test
    @DisplayName("Criterion 5: isPassing set correctly in constructor")
    public void testIsPassingSetCorrectlyInConstructor() {
        Student passingStudent = new Student("S002", "Bob", 60);
        assertTrue(passingStudent.isPassing(), "Should be passing with grade 60");
        
        Student failingStudent = new Student("S003", "Charlie", 40);
        assertFalse(failingStudent.isPassing(), "Should not be passing with grade 40");
        
        System.out.println("✓ PASS: isPassing set correctly in constructor");
    }
    
    // ============================================
    // SUMMARY TEST - Calculates final score
    // ============================================
    
    @Test
    @DisplayName("SUMMARY: Calculate Encapsulation Score")
    public void testEncapsulationScore() {
        int score = 0;
        
        // Criterion 1: All fields private
        Field[] fields = Student.class.getDeclaredFields();
        boolean allPrivate = true;
        for (Field field : fields) {
            if (!Modifier.isPrivate(field.getModifiers())) {
                allPrivate = false;
                break;
            }
        }
        if (allPrivate && fields.length > 0) score++;
        
        // Criterion 2: Proper getters
        try {
            Student.class.getMethod("getName");
            Student.class.getMethod("getStudentId");
            Student.class.getMethod("getGrade");
            Student.class.getMethod("isPassing");
            score++;
        } catch (NoSuchMethodException e) { }
        
        // Criterion 3: Validation in setGrade
        int before = student.getGrade();
        student.setGrade(-10);
        if (student.getGrade() == before) score++;
        
        // Criterion 4: Read-only fields
        try {
            Student.class.getMethod("setStudentId", String.class);
        } catch (NoSuchMethodException e) {
            try {
                Student.class.getMethod("setName", String.class);
            } catch (NoSuchMethodException e2) {
                score++;
            }
        }
        
        // Criterion 5: Auto-update isPassing
        student.setGrade(60);
        boolean passing60 = student.isPassing();
        student.setGrade(40);
        boolean passing40 = student.isPassing();
        if (passing60 && !passing40) score++;
        
        System.out.println("\n========================================");
        System.out.println("CHALLENGE 1 - ENCAPSULATION SCORE: " + score + "/5");
        System.out.println("========================================");
        
        assertTrue(score >= 3, "Should score at least 3/5 for a passing grade");
    }
}
