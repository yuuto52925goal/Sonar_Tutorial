package edu.byu.cs.sonar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class MainTest {


    @Test
    void testMain() {
        String[] args = {"readMe1.txt", "readMe2.txt", "readMe3.txt", "5"};

        assertDoesNotThrow(() -> Main.main(args));

    }

    @Test
    void testMainWithOneWord() {
        String[] args = {"readMe1.txt", "readMe2.txt", "readMe3.txt", "1"};
        assertDoesNotThrow(() -> Main.main(args));
    }

    @Test
    void testMainWithInvalidFile() {
        String[] args = {"invalid.txt", "invalid.txt", "invalid.txt", "1"};
        assertDoesNotThrow(() -> Main.main(args),
                "Should handle FileNotFoundException gracefully");
    }
}