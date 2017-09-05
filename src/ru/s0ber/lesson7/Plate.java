package ru.s0ber.lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.format("В тарелке осталось %d еды", this.food);
        System.out.println();
    }

    public void decreaseFood(int food) {
        if (food > this.food) {
            System.out.println("Теперь тарелка пуста");
            this.food = 0;
        } else {
            this.food -= food;
        }
    }
}
