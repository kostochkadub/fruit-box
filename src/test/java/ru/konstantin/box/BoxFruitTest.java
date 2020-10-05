package ru.konstantin.box;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.konstantin.fruit.Apple;
import ru.konstantin.fruit.Orange;

import java.util.ArrayList;


class BoxFruitTest {

    @Test
    @DisplayName("Проверка расчета веса коробки коробки")
    void getWeight() {
        BoxFruit<Apple> boxFruitApples = getAppleBoxFruitWeightTwo();

        Assertions.assertEquals(2,boxFruitApples.getWeight());
    }

    @Test
    @DisplayName("Проверка сравнения веса коробок с фруктами")
    void compare() {
        BoxFruit<Orange> boxFruitOrange = getBoxFruitContainingTwoOranges();
        BoxFruit<Orange> boxFruitOrange2 = getBoxFruitContainingOneOrange();

        Assertions.assertEquals(false,boxFruitOrange.compare(boxFruitOrange2));
        Assertions.assertEquals(true,boxFruitOrange.compare(boxFruitOrange));
    }

    @Test
    @DisplayName("Проверка getFruitStack")
    void getFruitStack() {
        BoxFruit<Orange> boxFruitOrange = getBoxFruitContainingTwoOranges();

        Assertions.assertEquals(boxFruitOrange.toString(),"BoxFruit{fruitStack=" + boxFruitOrange.getFruitStack() + "}");
    }

    @Test
    @DisplayName("Проверка добавления фруктов в коробку")
    void addFruit() {
        BoxFruit<Apple> boxFruitApples = new BoxFruit<Apple>();

        Apple apple = new Apple();

        //До добавления 1-ого яблока
        Assertions.assertEquals(false, boxFruitApples.addFruit().contains(apple));
        //После добавления 1-ого яблока
        Assertions.assertEquals(true, boxFruitApples.addFruit(apple).contains(apple));
    }

    @Test
    @DisplayName("Проверки работы пересыпания фруктов, с использованием метода getWeight")
    void scatterFruitOrange() {
        BoxFruit<Orange> boxFruitOrange = getBoxFruitContainingTwoOranges();
        BoxFruit<Orange> boxFruitOrange2 = getBoxFruitContainingOneOrange();

        //Проверка веса коробок до пересыпания апельсинов
        Assertions.assertEquals(3, boxFruitOrange.getWeight());
        Assertions.assertEquals(1.5, boxFruitOrange2.getWeight());

        boxFruitOrange.scatterFruits(boxFruitOrange2);

        //Проверка веса коробок после пересыпания апельсинов
        Assertions.assertEquals(0, boxFruitOrange.getWeight());
        Assertions.assertEquals(4.5, boxFruitOrange2.getWeight());
    }

    @Test
    @DisplayName("Проверки работы пересыпания фруктов, не используя метод getWeight")
    void scatterFruitOrange1() {
        Apple apple = new Apple();
        Apple apple2 = new Apple();

        BoxFruit<Apple> boxFruitApples1 = new BoxFruit<Apple>(apple);
        BoxFruit<Apple> boxFruitApples3 = new BoxFruit<Apple>(apple2);
        BoxFruit<Apple> boxFruitApples2 = new BoxFruit<Apple>();

        ArrayList<Apple> list = boxFruitApples1.scatterFruits(boxFruitApples2);

        Assertions.assertEquals(true, list.contains(apple));
        Assertions.assertEquals(false, list.contains(apple2));

        list = boxFruitApples1.scatterFruits(boxFruitApples3);

        Assertions.assertEquals(true, list.contains(apple2));
    }

    private BoxFruit<Orange> getBoxFruitContainingOneOrange() {
        Orange orangeThree = new Orange();
        BoxFruit<Orange> boxFruitOrange2 = new BoxFruit<Orange>(orangeThree);
        return boxFruitOrange2;
    }

    private BoxFruit<Orange> getBoxFruitContainingTwoOranges() {
        Orange orangeOne = new Orange();
        Orange orangeTwo = new Orange();

        BoxFruit<Orange> boxFruitOrange = new BoxFruit<Orange>(orangeOne, orangeTwo);
        return boxFruitOrange;
    }

    private BoxFruit<Apple> getAppleBoxFruitWeightTwo() {
        Apple appleOne = new Apple();
        Apple appleTwo = new Apple();
        BoxFruit<Apple> boxFruitApples = new BoxFruit<Apple>(appleOne, appleTwo);
        return boxFruitApples;
    }
}