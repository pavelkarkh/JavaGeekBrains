package ru.s0ber.lesson6;

import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        Cat cat = generateCat();
        System.out.println(cat);
        System.out.println(cat.isJump(0.1f));
    }

    public static Cat generateCat() {
        String[] catNames = {"Барсик", "Рыжий", "Кот", "Машка", "Кряква"};
        Random random = new Random();

        String name = catNames[random.nextInt(catNames.length)];
        int runDistance = random.nextInt(500) + 2000;
        int swimDistance = 0;
        float jumpHeight = random.nextFloat()+ 2.0f;

        return new Cat(name, runDistance, swimDistance, jumpHeight);
    }
}
