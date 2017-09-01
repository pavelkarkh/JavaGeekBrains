package ru.s0ber.lesson1;

public class HomeWork1 {
    public static void main(String[] args) {
        byte b = 10;
        short sh = 1000;
        int i = 1000000;
        long l = 10000000;
        float f = 0.1f;
        double d = 0.2;
        boolean b1 = true;
        char ch = 'o';
        String s = "This is string!";
    }

    public static int calculateFormula(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    public static boolean checkLimits(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }

    public static void checkPositiveOrNegative(int a) {
        if (a >= 0) {
            System.out.println("Positive");
        } else {
            System.out.println("Negative");
        }
    }

    public static boolean checkNegative(int a) {
        return a < 0;
    }

    public static void printName(String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static void checkYear(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            System.out.println("Високосный!");
        } else {
            if (year % 400 == 0 && year % 100 == 0) {
                System.out.println("Високосный!");
            } else {
                System.out.println("Не високосный");
            }
        }
    }
}
