// Exercise 4
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class AaaCalculatorTest
{
    private Calculator calculator;
    @Before
    public void setUp()
    {
        System.out.println("[Setup] Initializing a fresh Calculator instance...");
        calculator = new Calculator();
    }
    @After
    public void tearDown()
    {
        System.out.println("[Teardown] Releasing Calculator resources...");
        calculator = null;
    }
    @Test
    public void testAddWithAaaPattern()
    {
        // Arrange
        int input1 = 20;
        int input2 = 10;
        int expectedResult = 30;
        // Act
        int actualResult = calculator.add(input1, input2);
        // Assert
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void testSubtractWithAaaPattern()
    {
        // Arrange
        int input1 = 20;
        int input2 = 10;
        int expectedResult = 10;
        // Act
        int actualResult = calculator.subtract(input1, input2);
        // Assert
        assertEquals(expectedResult, actualResult);
    }
}
