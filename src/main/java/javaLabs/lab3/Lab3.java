package javaLabs.lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Lab3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введіть розмір масиву: ");
        int size = input.nextInt();

        int[] array = new int[size];

        System.out.print("Введіть елементи масиву: ");
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(array[i]);
        }

        System.out.print("Введіть елемент, який потрібно додати до списку: ");
        int elementToAdd = input.nextInt();
        list.add(elementToAdd);

        System.out.print("Введіть індекс елемента, який потрібно видалити зі списку: ");
        int indexToRemove = input.nextInt();
        list.remove(indexToRemove);

        System.out.print("Введіть індекс елемента, який потрібно замінити у списку: ");
        int indexToReplace = input.nextInt();
        System.out.print("Введіть нове значення для елемента: ");
        int newElementValue = input.nextInt();
        list.set(indexToReplace, newElementValue);

        Collections.sort(list);

        System.out.print("Елементи списку: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }


        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Ділення на нуль неможливе!");
        }

    }
}