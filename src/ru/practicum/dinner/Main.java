package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "4":
                    System.out.println(dc.menu);
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("4");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine().trim();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine().trim();

        dc.addDishes(dishType, dishName);// добавьте новое блюдо
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        ArrayList<String> typesDish = new ArrayList<>();

        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            if (dc.checkType(nextItem)) {
                typesDish.add(nextItem);
            } else {
                System.out.println("Такого типа нет в меню. Введите другой тип пожалуйста.");
            }
            nextItem = scanner.nextLine();
        }

        // сгенерируйте комбинации блюд и выведите на экран
        var combos = dc.generateDishCombo(numberOfCombos, typesDish);
        for (ArrayList<String> combo : combos) {
            System.out.println(combo);
        }
    }
}
