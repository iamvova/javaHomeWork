import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException, NoSuchFieldException, IllegalAccessException {
        int threadsCount = 5;
        CountDownLatch latch = new CountDownLatch(threadsCount);

        // Створюємо об'єкт нашого класу і заповнюємо його даними
        MyClass myObject = new MyClass("Hello World", 123, true);

        // Виводимо всі поля класу та їх типи
        System.out.println("Початковий стан об'єкту:");
        Field[] fields = MyClass.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName() + " (" + field.getType().getSimpleName() + "): " + field.get(myObject));
        }

        // Модифікуємо значення поля "message" на "Hello Java"
        Field messageField = MyClass.class.getDeclaredField("message");
        messageField.setAccessible(true);
        messageField.set(myObject, "Hello Java");

        // Виводимо об'єкт після зміни поля "message"
        System.out.println("Об'єкт після зміни поля \"message\":");
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName() + " (" + field.getType().getSimpleName() + "): " + field.get(myObject));
        }

        // Створюємо загальний клас, який може зберігати список елементів будь-якого типу
        List<Object> myList = new ArrayList<>();
        myList.add("Hello");
        myList.add(123);
        myList.add(true);
        myList.add(3.14);

        System.out.println("Список елементів:");
        for (Object obj : myList) {
            System.out.println(obj);
        }

        latch.await();
    }
}

class MyClass {
    private String message;
    private int number;
    private boolean flag;

    public MyClass(String message, int number, boolean flag) {
        this.message = message;
        this.number = number;
        this.flag = flag;
    }
}