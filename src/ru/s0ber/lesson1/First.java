package ru.s0ber.lesson1;

import ru.s0ber.lesson1.HomeWork1;

public class First {
    public static void main(String[] args) {
        // тестируем byte!
        byte b = 1; // 8 bit (1 byte) -128 .. 127
        for (int i = 0; i < 1000; i++) {
            System.out.println(b++);
        }

        short s; // 16 bit (2 byte)  -2^15 .. 2^15 -1

        int j; // 32 bit (4 byte) -2^31 .. 2^15 -1

        long l; // 64 bit (8 byte) -2^63 .. 2^63 -1

        boolean b1; // 32 bit (4 byte)

        char ch = 'q'; // 16 bit (2 byte)

        System.out.println(HomeWork1.calculateFormula(4, 5, 3, 2));
        System.out.println(HomeWork1.checkLimits(10, 11));
        HomeWork1.checkPositiveOrNegative(77);
        System.out.println(HomeWork1.checkNegative(-90));
        HomeWork1.printName("Doby");
        HomeWork1.checkYear(2017);
    }
}