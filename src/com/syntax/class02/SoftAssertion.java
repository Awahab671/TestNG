package com.syntax.class02;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
    @Test
    public void softAssertionValidation() {
        String expected = "Batch 10 is one of the best";
        String actual = "Batch 10 is one of the batches";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expected, actual);
        System.out.println("My code after first assertion.");

        softAssert.assertTrue(false);
        System.out.println("My code after second assertion.");

        softAssert.assertFalse(true);
        System.out.println("My code after third assertion.");

        softAssert.assertFalse(false);
        System.out.println("My code after fourth assertion.");

        String newExpected = "This is last assertion.";
        String newActual = "This is last assertion";
        softAssert.assertEquals(newExpected, newActual);
        softAssert.assertAll();  // This method is to collect all the assertion information.
        // This method should be the last statement of our .
    }
}
