package ru.konstantin;

import ru.konstantin.box.BoxFruit;
import ru.konstantin.fruit.Apple;
import ru.konstantin.fruit.Orange;

import java.util.ArrayList;

public class SandBox {

    public static void main(String[] args) {

        Apple appleOne = new Apple();
        Apple appleTwo = new Apple();

        Orange orangeOne = new Orange();
        Orange orangeTwo = new Orange();
        Orange orangeThree = new Orange();
        Orange orangeFour = new Orange();

        BoxFruit<Apple> boxFruitApples = new BoxFruit<Apple>(appleOne, appleTwo);
        System.out.println("Коробка из двух яблок = " + boxFruitApples.getWeight());

        BoxFruit<Orange> boxFruitOrange = new BoxFruit<Orange>(orangeOne, orangeTwo);

        System.out.println("Сравнение коробок = " + boxFruitApples.compare(boxFruitOrange));

        BoxFruit<Orange> boxFruitOrange2 = new BoxFruit<Orange>(orangeThree);
        boxFruitOrange2.addFruit(orangeFour);

        System.out.println("Вес коробки до пересыпания = " + boxFruitOrange2.getWeight());

        boxFruitOrange.scatterFruits(boxFruitOrange2);

        System.out.println("Вес пересыпанной коробки = " + boxFruitOrange2.getWeight());
    }
}
