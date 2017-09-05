package ru.s0ber.lesson7;

public class MainClass {
    public static void main(String[] args) {
        Cat cat = new Cat("Рэйнбоу", 15);
        Plate plate = new Plate(35);
        plate.info();

        System.out.println("Питомец " + cat.getName() + " проголодался и подошёл к тарелке.");
        cat.eat(plate);
        System.out.println("Питомец " + cat.getName() + " поел.");
        plate.info();

        System.out.println("Питомец " + cat.getName() + " проголодался и подошёл к тарелке.");
        cat.eat(plate);
        System.out.println("Питомец " + cat.getName() + " поел.");
        plate.info();

        System.out.println("Питомец " + cat.getName() + " проголодался и подошёл к тарелке.");
        cat.eat(plate);
        System.out.println("Питомец " + cat.getName() + " поел.");
        plate.info();
    }
}
