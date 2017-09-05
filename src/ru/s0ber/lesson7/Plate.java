package ru.s0ber.lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.format("В тарелке осталось %d еды.\n", this.food);
    }

    public boolean decreaseFood(int food) {
        if (food > this.food) {
            return false;
        } else {
            this.food -= food;
            return true;
        }
    }

    public void increaseFood(int food) {
        this.food += food;
    }
}
