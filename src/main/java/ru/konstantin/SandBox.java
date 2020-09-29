package ru.konstantin;

import ru.konstantin.box.BoxFruit;
import ru.konstantin.fruit.Apple;
import ru.konstantin.fruit.Orange;

import java.util.ArrayList;

public class SandBox {

    public static void main(String[] args) {

        Apple appleOne = new Apple();
        Apple appleTwo= new Apple();

        Orange orangeOne= new Orange();

        //Не работает. На выходе всегда 0. Конструктор и метод закомментированны в классе BoxFruit
        //BoxFruit boxFruit = new BoxFruit(appleOne, appleTwo, orangeOne);
        //System.out.println( boxFruit.getWeight());

        ArrayList fruitStack = new ArrayList();
        fruitStack.add(appleOne);
        fruitStack.add(appleTwo);

        //Как исключить возможность добавления другого(нельзя яблоки высыпать в коробку с апельсинами) фрукта в зависимости от реализации?
        //1) Если мы передаем ArrayList, в котором уже есть яблоки и апельсины
        //2) Если мы кладем фрукты по одному в коробку
        fruitStack.add(orangeOne);

        BoxFruit boxFruit = new BoxFruit(fruitStack);
        System.out.println( boxFruit.getWeight());

    }
}
