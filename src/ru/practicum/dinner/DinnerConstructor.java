package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DinnerConstructor {
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


    boolean checkType(String type) {
        if (menu.containsKey(type)) {
            return true;
        }
        return false;
    }
}
