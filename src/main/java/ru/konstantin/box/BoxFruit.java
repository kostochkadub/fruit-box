package ru.konstantin.box;

import ru.konstantin.fruit.Fruit;

import java.util.ArrayList;

public class BoxFruit<T extends Fruit> {

    private ArrayList<T> fruitStack;

    public BoxFruit(ArrayList<T> fruitStack) {
        this.fruitStack = fruitStack;
    }

    // Не работает. Почему?
   // public BoxFruit(T... fruitStack) {
   //     this.fruitStack = new ArrayList<T>();
   // }

    public float getWeight() {
        float weight = 0;
        for (T fruit: fruitStack) {
            weight += fruit.getFruitWeight();
        }
        return weight;
    }

    public boolean compare(BoxFruit boxFruit){
        return boxFruit.getWeight() == this.getWeight();
    }

    public ArrayList<T> getFruitStack() {
        return fruitStack;
    }
}
