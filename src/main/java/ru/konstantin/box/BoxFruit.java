package ru.konstantin.box;

import ru.konstantin.fruit.Fruit;

import java.util.ArrayList;
import java.util.Arrays;

public class BoxFruit<T extends Fruit> {

    private ArrayList<T> fruitStack;

    public BoxFruit(T... fruitStack) {
        this.fruitStack = new ArrayList<T>();
        this.fruitStack.addAll(Arrays.asList(fruitStack));
    }

    public float getWeight() {
        float weight = 0;
        for (T fruit : fruitStack) {
            weight += fruit.getFruitWeight();
        }
        return weight;
    }

    public boolean compare(BoxFruit boxFruit) {
        return boxFruit.getWeight() == this.getWeight();
    }

    public ArrayList<T> getFruitStack() {
        return fruitStack;
    }

    public ArrayList<T> addFruit(T... fruitStack) {
        this.fruitStack.addAll(Arrays.asList(fruitStack));
        return this.fruitStack;
    }

    public ArrayList<T> scatterFruits(BoxFruit<T> boxFruit) {
        boxFruit.fruitStack.addAll(this.fruitStack);
        this.fruitStack.clear();
        return boxFruit.fruitStack;
    }

    @Override
    public String toString() {
        return "BoxFruit{" +
                "fruitStack=" + fruitStack +
                '}';
    }
}
