package edu.oop;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BookTest {

    @Test
    void testConstructorSetsFields() {
        Book book = new Book("1984", "George Orwell", 328);
        assertEquals("1984", book.getTitle());
        assertEquals("George Orwell", book.getAuthor());
        assertEquals(328, book.getPages());
    }

    @Test
    void testDisplayDetailsOutputsCorrectText() {
        Book book = new Book("Pride and Prejudice", "Jane Austen", 432);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        book.displayDetails();

        String output = out.toString();
        assertTrue(output.contains("Title: Pride and Prejudice"));
        assertTrue(output.contains("Author: Jane Austen"));
        assertTrue(output.contains("Pages: 432"));
    }
}
