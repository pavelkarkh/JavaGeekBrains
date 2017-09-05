package ru.s0ber.lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public boolean isSatiety() {
        return satiety;
    }

    // пока сделаю приватным чтобы не менять состояние сытости из вне класса
    private void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Plate plate){
        if (plate.decreaseFood(appetite)) {
            setSatiety(true);
        } else {
            setSatiety(false);
        }
    }

    public String getName() {
        return name;
    }
}
