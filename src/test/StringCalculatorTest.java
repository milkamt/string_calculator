package test;

import main.StringCalculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void addNumbers() {
        assertEquals(28,stringCalculator.getSum("1,2,3,4,5,6,7"));
    }

    @Test
    void nullInput() {
        assertEquals(0,stringCalculator.getSum(null));
    }

    @Test
    void blankInput() {
        assertEquals(0, stringCalculator.getSum(""));
    }

    @Test
    void differentDelimiters() {
        assertEquals(28,stringCalculator.getSum("1,2,3 4,5\n6 7"));
    }

    @Test
    void negativeNumber() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> stringCalculator.getSum("1,2,-5"));

        String expectedMessage = "Not supporting negative numbers.";
        String actualMessage = exception.getMessage();

        assertTrue(expectedMessage.contains(actualMessage));
    }

    @Test
    void ignoresNumGreaterThan100() {
        assertEquals(10, stringCalculator.getSum("1 2 150 3 4"));
    }

}