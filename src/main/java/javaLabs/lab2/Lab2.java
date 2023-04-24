package javaLabs.lab2;

import java.util.Scanner;
import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        int inputDayOfWeek = getInput();
        String dayOfWeek = getDayOfWeek(inputDayOfWeek);
        printResult(dayOfWeek);
    }

    public static int getInput() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter day of week:");
        int inputDayOfWeek = 0;
        if (myObj.hasNextInt()) {
            inputDayOfWeek = Integer.parseInt(myObj.nextLine());  // Отримання введеного числа
            getDayOfWeek(inputDayOfWeek);
        } else {
            System.out.println("Invalid input. Please enter a number between 1 and 7.");
        }
        return inputDayOfWeek;
    }

    public static String getDayOfWeek(int day) {
        String dayOfWeek;
        switch (day) {
            case 1 -> dayOfWeek = "Monday";
            case 2 -> dayOfWeek = "Tuesday";
            case 3 -> dayOfWeek = "Wednesday";
            case 4 -> dayOfWeek = "Thursday";
            case 5 -> dayOfWeek = "Friday";
            case 6 -> dayOfWeek = "Saturday";
            case 7 -> dayOfWeek = "Sunday";
            default -> dayOfWeek = "Invalid day";
        }
        return dayOfWeek;
    }

    public static void printResult(String dayOfWeek) {
        System.out.println("The day of the week is " + dayOfWeek);
    }
}