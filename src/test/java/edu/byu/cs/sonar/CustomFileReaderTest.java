package edu.byu.cs.sonar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class CustomFileReaderTest {

    private CustomFileReader sut;

    @BeforeEach
    void setUp() {
        sut = new CustomFileReader("readMe1.txt");
    }

    @Test
    void testHowManyWordsInFile() throws FileNotFoundException {
        assertEquals(4, sut.howManyWordsInFile(), "There should be 4 words in readMe1.txt");
    }

    @Test
    void testReturnThatWord() throws FileNotFoundException {
        assertEquals("I", sut.returnThatWord(1), "The first word should be I in readMe1.txt");
    }

    @Test
    void testFindNewWord() throws FileNotFoundException {
        sut.findNewWord("C");
        assertEquals("Computer ", sut.getNewSentence(), "Computer should be found when C queried");
    }

    @Test
    void testGetNewSentence() {
        assertEquals("", sut.getNewSentence(), "New sentence should be empty initially");
    }

    @Test
    void setNewSentence() {
        String betterSentence = "New Sentence.";
        sut.setNewSentence(betterSentence);
        assertEquals(betterSentence, sut.getNewSentence());
    }

    @Test
    void testEqualsWithSameObject() {
        assertEquals(sut, sut, "Same object should be equal to itself");
    }

    @Test
    void testEqualsWithEqualObject() {
        CustomFileReader sut2 = new CustomFileReader("readMe1.txt");
        assertEquals(sut, sut2, "Two readers with same file should be equal");
    }

    @Test
    void testEqualsWithNull() {
        assertNotEquals(null, sut, "Reader should not be equal to null");
    }

    @Test
    void testEqualsWithDifferentClass() {
        assertNotEquals("not a reader", sut, "Reader should not be equal to a String");
    }

    @Test
    void testEqualsWithDifferentFile() {
        CustomFileReader sut2 = new CustomFileReader("readMe2.txt");
        assertNotEquals(sut, sut2, "Readers with different files should not be equal");
    }

    @Test
    void testEqualsWithDifferentSentence() {
        CustomFileReader sut2 = new CustomFileReader("readMe1.txt");
        sut2.setNewSentence("Different sentence");
        assertNotEquals(sut, sut2, "Readers with different sentences should not be equal");
    }

    @Test
    void testToString() {
        assertEquals(" 0", sut.toString(), "toString should return empty sentence and 0 count");
    }

    @Test
    void testReturnThatWordSecondWord() throws FileNotFoundException {
        assertEquals("love", sut.returnThatWord(2), "The second word should be 'love' in readMe1.txt");
    }

    @Test
    void testFindMultipleNewWords() throws FileNotFoundException {
        sut.findNewWord("C");
        sut.findNewWord("C");
        assertTrue(sut.getNewSentence().split(" ").length >= 2,
                "Should have at least 2 words in sentence");
    }
}