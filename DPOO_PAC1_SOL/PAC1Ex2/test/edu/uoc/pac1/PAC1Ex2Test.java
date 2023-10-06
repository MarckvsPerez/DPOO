package edu.uoc.pac1;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PAC1Ex2Test {

    private ByteArrayOutputStream outContent;
    private final PrintStream originalOut = System.out;


    @BeforeEach
    public void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testDivsSum(){
        assertEquals(1,PAC1Ex2.divsSum(2));
        assertEquals(1,PAC1Ex2.divsSum(3));
        assertEquals(3,PAC1Ex2.divsSum(4));
        assertEquals(6,PAC1Ex2.divsSum(6));
        assertEquals(8,PAC1Ex2.divsSum(10));
        assertEquals(1,PAC1Ex2.divsSum(11));
        assertEquals(16,PAC1Ex2.divsSum(12));
        assertEquals(1,PAC1Ex2.divsSum(13));
        assertEquals(10,PAC1Ex2.divsSum(14));
        assertEquals(9,PAC1Ex2.divsSum(15));
        assertEquals(49,PAC1Ex2.divsSum(75));
        assertEquals(-1,PAC1Ex2.divsSum(-13));
        assertEquals(-1,PAC1Ex2.divsSum(-75));
        assertEquals(-1,PAC1Ex2.divsSum(0));
    }

    @Test
    void testPerfectNumbers() {
        assertTrue(PAC1Ex2.isPerfect(6));
        assertTrue(PAC1Ex2.isPerfect(28));
        assertTrue(PAC1Ex2.isPerfect(496));
        assertTrue(PAC1Ex2.isPerfect(8128));

        //ERRORS
        assertFalse(PAC1Ex2.isPerfect(26));
        assertFalse(PAC1Ex2.isPerfect(800));
        assertFalse(PAC1Ex2.isPerfect(323));
        assertFalse(PAC1Ex2.isPerfect(987));
        assertFalse(PAC1Ex2.isPerfect(765));
    }

    @Test
    void testIsAbundant() {
        assertTrue(PAC1Ex2.isAbundant(12));
        assertTrue(PAC1Ex2.isAbundant(18));
        assertTrue(PAC1Ex2.isAbundant(20));
        assertTrue(PAC1Ex2.isAbundant(24));

        assertFalse(PAC1Ex2.isAbundant(13));
        assertFalse(PAC1Ex2.isAbundant(49));
        assertFalse(PAC1Ex2.isAbundant(55));
        assertFalse(PAC1Ex2.isAbundant(73));
        assertFalse(PAC1Ex2.isAbundant(77));
        assertFalse(PAC1Ex2.isAbundant(103));
    }

    @Test
    void testIsDeficient() {
        assertTrue(PAC1Ex2.isDeficient(1));
        assertTrue(PAC1Ex2.isDeficient(5));
        assertTrue(PAC1Ex2.isDeficient(7));
        assertTrue(PAC1Ex2.isDeficient(11));

        assertFalse(PAC1Ex2.isDeficient(12));
        assertFalse(PAC1Ex2.isDeficient(6));
        assertFalse(PAC1Ex2.isDeficient(18));
    }

    @Test
    void testCategorize() {
        int[] numbers = {12, 24, 8128, 18};

        PAC1Ex2.categorize(numbers);

        assertEquals("There are: 1 perfect numbers." + System.lineSeparator() +
                        "There are: 3 abundant numbers." + System.lineSeparator() +
                        "There are: 0 deficient numbers."
                , outContent.toString().trim());
    }


    @Test
    void testCategorize2() {
        int[] numbers = {1, 2, 3, 7, 11, 12, 21, 24, 30, 40, 42, 48, 54, 56, 60, 8128, 18};

        PAC1Ex2.categorize(numbers);

        assertEquals("There are: 1 perfect numbers." + System.lineSeparator() +
                        "There are: 10 abundant numbers." + System.lineSeparator() +
                        "There are: 6 deficient numbers."
                , outContent.toString().trim());
    }


    @Test
    void testCategorize3() {
        int[] numbers = {1, 2, 3, 6, 7, 11, 12, 21, 24, 28, 30, 40, 496, 8128, 33550336};

        PAC1Ex2.categorize(numbers);

        assertEquals("There are: 5 perfect numbers." + System.lineSeparator() +
                        "There are: 4 abundant numbers." + System.lineSeparator() +
                        "There are: 6 deficient numbers."
                , outContent.toString().trim());
    }
}
