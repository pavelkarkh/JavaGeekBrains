package ru.s0ber.lesson6;

import java.util.Random;

public class MainClass {

    static Random  random = new Random();
    static int runDistance = random.nextInt(100) + 2000;
    static int swimDistance = random.nextInt(100) + 500;
    static float jumpHeight = random.nextFloat()+ 0.5f;

    public static void main(String[] args) {

        Cat cat = generateCat();
        System.out.println(cat);

        Dog dog = generateDog();
        System.out.println(dog);

        competition(cat);
        competition(dog);
    }

    private static Cat generateCat() {
        String[] catNames = {"Барсик", "Рыжий", "Кот", "Машка", "Кряква"};
        Random random = new Random();

        String name = catNames[random.nextInt(catNames.length)];
        int runDistance = random.nextInt(500) + 2000;
        int swimDistance = 0;
        float jumpHeight = random.nextFloat()+ 2.0f;

        return new Cat(name, runDistance, swimDistance, jumpHeight);
    }

    private static Dog generateDog() {
        String[] dogNames = {"Бим", "Белый", "Хрыч", "Чернослив", "Федька"};
        Random random = new Random();

        String name = dogNames[random.nextInt(dogNames.length)];
        int runDistance = random.nextInt(500) + 3000;
        int swimDistance = random.nextInt(100) + 500;
        float jumpHeight = random.nextFloat()+ 0.5f;

        return new Dog(name, runDistance, swimDistance, jumpHeight);
    }

    private static void competition(Animal animal) {

        System.out.println(animal.name + " соревнуется в беге на дистанцию: " + runDistance);
        if (animal.isRun(runDistance)) {
            System.out.println(animal.name + " удачно проходит этот этап!");
        } else {
            System.out.println(animal.name + " падает без сил не доходя до финиша! Увы, но это его последний этап.");
            return;
        }

        System.out.println(animal.name + " соревнуется в перепрыгивании препятствий: " + jumpHeight);
        if (animal.isJump(jumpHeight)) {
            System.out.println(animal.name + " удачно проходит этот этап!");
        } else {
            System.out.println(animal.name + " падает без сил так и не перепрыгнув препятствие! Увы, но это его последний этап.");
            return;
        }

        System.out.println(animal.name + " соревнуется в плавании: " + swimDistance);
        if (animal.isSwim(swimDistance)) {
            System.out.println(animal.name + " удачно проходит этот этап!");
        } else {
            System.out.println(animal.name + " чуть не утонул, но спасатели прибыли во время! Увы, но это его последний этап.");
            return;
        }
    }
}
