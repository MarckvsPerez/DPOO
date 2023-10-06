package edu.uoc.pac1;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PAC1Ex3Test {

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
    public void testCalculateTieredPricing() {
        assertEquals(15.9, PAC1Ex3.calculateTieredPricing(365));
        assertEquals(30.78, PAC1Ex3.calculateTieredPricing(656));
        assertEquals(35.54, PAC1Ex3.calculateTieredPricing(996));
    }

    @Test
    public void testCalculateDiscount() {
        assertEquals(68.64, PAC1Ex3.calculateDiscount(70, 343.221));
        assertEquals(0.0, PAC1Ex3.calculateDiscount(0, 212.12));
        assertEquals(40.05, PAC1Ex3.calculateDiscount(7, 400.54));
    }

    @Test
    public void testCalculateAdditionalCharges() {
        assertEquals(0, PAC1Ex3.calculateAdditionalCharges(256));
        assertEquals(8.9, PAC1Ex3.calculateAdditionalCharges(445));
        assertEquals(10.46, PAC1Ex3.calculateAdditionalCharges(523));
    }


    @Test
    public void testCalculateTotalBill() {
        int[][] unitsPerDay = {
                {23, 158, 87, 32, 176, 53, 199},
                {72, 92, 117, 134, 44, 184, 7},
                {51, 119, 28, 163, 108, 14, 68},
                {135, 18, 166, 47, 184, 23, 199}
        };

        double actualBill = PAC1Ex3.calculateTotalBill(unitsPerDay);

        assertEquals(1423.59, actualBill);
    }


    @Test
    public void testCalculateTotalBillWithZeroUnits() {
        int[][] unitsPerDay = {{0, 0, 0, 0, 0, 0, 0}};
        double actualBill = PAC1Ex3.calculateTotalBill(unitsPerDay);

        assertEquals(34.84, actualBill);
    }

    @Test
    public void testCalculateTotalBillForSingleDay() {
        int[][] unitsPerDay = {{150}};

        double actualBill = PAC1Ex3.calculateTotalBill(unitsPerDay);

        assertEquals(45.62, actualBill);
    }

    @Test
    public void testCalculateTotalBillWithHighUsage() {
        int[][] unitsPerDay = {{1000, 1100, 1050, 950, 1200, 1150, 1000}};

        double actualBill = PAC1Ex3.calculateTotalBill(unitsPerDay);

        assertEquals(3788.99, actualBill);
    }


}
