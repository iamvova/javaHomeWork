import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        enum DAY {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter day of week");

        int inputDayOfWeek = Integer.parseInt(myObj.nextLine());  // Read user input
        switch (inputDayOfWeek) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            case 4 -> System.out.println("Thursday");
            case 5 -> System.out.println("Friday");
            case 6 -> System.out.println("Saturday");
            case 7 -> System.out.println("Sunday");
        }
    }
}