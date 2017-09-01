package ru.s0ber.lesson5;

public class Associate1 {
    private String name;
    private int age;
    private String email;
    private String phone;
    private String position;
    private int salary;

    public Associate1(String name, int age, String email, String phone, String position, int salary) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.position = position;
        this.salary = salary;
    }

    public void printInfo() {
        System.out.format("ФИО: %s, возраст: %d, эл.почта: %s, телефон: %s, должность: %s, зарплата: %d", name, age, email, phone, position, salary);
    }
}
