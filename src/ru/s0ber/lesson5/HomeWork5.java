package ru.s0ber.lesson5;

import java.util.Random;

public class HomeWork5 {
    public static void main(String[] args) {

        Associate[] associates = new Associate[5];
        associates[0] = new Associate("Иван Иванов", randomAge(), "iivanov@geekbrains.ru", "+449121184447","Учитель", assignSalary());
        associates[1] = new Associate("Сергей Сергеев", randomAge(), "ssergeev@geekbrains.ru", "+449121184448","Учитель", assignSalary());
        associates[2] = new Associate("Петр Петров", randomAge(), "ppetrov@geekbrains.ru", "+449121184441","Учитель", assignSalary());
        associates[3] = new Associate("Владимир Владимиров", randomAge(), "vvladimirov@geekbrains.ru", "+449121184442","Учитель", assignSalary());
        associates[4] = new Associate("Евгений Евгеньев", randomAge(), "eevgeniev@geekbrains.ru", "+449121184443","Учитель", assignSalary());

        System.out.println("Сотрудники старше 40 лет:");
        for (int i = 0; i < associates.length; i++) {
            if (associates[i].getAge() >= 40){
                associates[i].printInfo();
            }
        }
    }

    private static int assignSalary() {
        int salary;
        Random random = new Random();
        salary = random.nextInt(9000) + 1000;
        return salary;
    }

    private static int randomAge() {
        int age;
        Random random = new Random();
        age = random.nextInt(30) + 21;
        return age;
    }
}

class Associate {
    private String name;
    private int age;
    private String email;
    private String phone;
    private String position;
    private int salary;

    public int getAge() {
        return age;
    }

    public Associate(String name, int age, String email, String phone, String position, int salary) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.position = position;
        this.salary = salary;
    }

    public void printInfo() {
        System.out.format("ФИО: %s, возраст: %d, эл.почта: %s, телефон: %s, должность: %s, зарплата: %d.%n", name, age, email, phone, position, salary);
    }
}
