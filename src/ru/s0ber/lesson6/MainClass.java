package ru.s0ber.lesson6;

public class MainClass {
    public static void main(String[] args) {
        Cat cat = new Cat("barsik", 2, 2, 0.2f);
        System.out.println(cat.jump(0.1f));
    }
}
