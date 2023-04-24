package javaLabs.java.lab8;

import javaLabs.lab2.Lab2;
import org.testng.Assert;
import org.testng.annotations.Test;

//Task 1: Create 4 simple unit tests for Task_2 (modify your code to have 4 different methods in Task_2 solving if need).
public class Lab8 {
    @Test
    public void testGetDayOfWeek() {
        String expected = "Monday";
        String dayOfWeek = Lab2.getDayOfWeek(1);
        Assert.assertEquals(expected, dayOfWeek);
    }

    @Test
    public void testGetDayOfWeek2() {
        String expected = "Tuesday";
        String dayOfWeek = Lab2.getDayOfWeek(2);
        Assert.assertEquals(expected, dayOfWeek);
    }

    @Test
    public void testGetDayOfWeek3() {
        String expected = "Wednesday";
        String dayOfWeek = Lab2.getDayOfWeek(3);
        Assert.assertEquals(expected, dayOfWeek);
    }

    @Test
    public void testGetDayOfWeek4() {
        String expected = "Thursday";
        String dayOfWeek = Lab2.getDayOfWeek(4);
        Assert.assertEquals(expected, dayOfWeek);
    }
}
