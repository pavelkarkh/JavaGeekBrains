package ru.s0ber.lesson7;

public class MainClass {
    public static void main(String[] args) {
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Рэйнбоу", 15);
        cats[1] = new Cat("Флэш", 35);
        cats[2] = new Cat("Кощей", 5);

        Plate plate = new Plate(51);
        plate.info();

        for (int i = 0; i < cats.length; i++) {
            System.out.println("Питомец " + cats[i].getName() + " проголодался и подошёл к тарелке.");
            cats[i].eat(plate);
            if (cats[i].isSatiety()) {
                System.out.println("Питомец " + cats[i].getName() + " поел. И доволен!");
            } else {
                System.out.println("Питомец " + cats[i].getName() + " грустно смотрит на хозяина.");
            }
            plate.info();
        }

        System.out.println();

        for (int i = 0; i < cats.length; i++) {
            if (cats[i].isSatiety()) {
                System.out.println("Питомец " + cats[i].getName() + " сыт и доволен!");
            } else {
                System.out.println("Питомец " + cats[i].getName() + " до сих пор хочет кушать!");
            }
        }
    }
}
