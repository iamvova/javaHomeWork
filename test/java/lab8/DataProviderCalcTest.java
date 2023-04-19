package javaHomeWork.test.java.lab8;


import javaHomeWork.lab2.Lab2;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//Task 3. add Data provider for each test
public class DataProviderCalcTest {

    @DataProvider
    private Object[][] addProvider(){
        int n = 4;
        int m = 2;
        Object[][] res = new Object[n][m];
        res[0] = new Object[]{"Monday", Lab2.getDayOfWeek(1)};
        res[1] = new Object[]{"Tuesday", Lab2.getDayOfWeek(2)};
        res[2] = new Object[]{"Wednesday", Lab2.getDayOfWeek(3)};
        res[3] = new Object[]{"Thursday", Lab2.getDayOfWeek(4)};
        return res;
    }
    @Test(dataProvider = "addProvider")
    public void testGetDayOfWeek(String expected, String dayOfWeek) {
        Assert.assertEquals(expected, dayOfWeek);
    }

    @Test(dataProvider = "addProvider")
    public void testGetDayOfWeek1(String expected, String dayOfWeek) {
        Assert.assertEquals(expected, dayOfWeek);
    }
    @Test(dataProvider = "addProvider")
    public void testGetDayOfWeek2(String expected, String dayOfWeek) {
        Assert.assertEquals(expected, dayOfWeek);
    }
    @Test(dataProvider = "addProvider")
    public void testGetDayOfWeek3(String expected, String dayOfWeek) {
        Assert.assertEquals(expected, dayOfWeek);
    }
}
