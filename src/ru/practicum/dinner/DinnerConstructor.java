package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    final Random random = new Random();
    HashMap<String, ArrayList<String>> menu;

    DinnerConstructor() {
        menu = new HashMap<>();
    }

    void addDishes(String dishType, String dishName) {
        ArrayList<String> dishes;

        if (checkType(dishType)) {
            dishes = menu.get(dishType);
            dishes.add(dishName);
        } else {
            dishes = new ArrayList<>();
            dishes.add(dishName);
            menu.put(dishType, dishes);
        }
    }

    ArrayList<ArrayList<String>> generateDishCombo(int numberOfCombos, ArrayList<String> typesDish) {
        ArrayList<ArrayList<String>> combosSet = new ArrayList<>();

        ArrayList<String> combo;
        for (int i = 0; i < numberOfCombos; i++) {
            combo = new ArrayList<>();

            for (String type : typesDish) {
                ArrayList<String> list = menu.get(type);
                String dish = list.get(random.nextInt(list.size()));
                combo.add(dish);
            }

            combosSet.add(combo);
        }

        return combosSet;
    }

    boolean checkType(String type) {
        return menu.containsKey(type) ? true : false;
    }
}
