package lab8;

import javaHomeWork.lab2.Lab2;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametrizedCalcTest {

    @Parameters({"expected", "num"})
    @Test
    public void testGetDayOfWeek(String expected, int num) {
        String dayOfWeek = Lab2.getDayOfWeek(num);
        Assert.assertEquals(expected, dayOfWeek);
    }
}
