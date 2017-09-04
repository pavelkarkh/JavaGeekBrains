package ru.s0ber.lesson6;

abstract class Animal {
    protected String name;
    protected int runDistance;
    protected int swimDistance;
    protected float jumpHeight;

    Animal() {
    }

    boolean isRun(int distance) {
        return distance <= runDistance;
    }

    boolean isSwim(int distance) {
        return distance <= swimDistance;
    }

    boolean isJump(float height) {
        return height <= jumpHeight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", runDistance=" + runDistance +
                ", swimDistance=" + swimDistance +
                ", jumpHeight=" + jumpHeight +
                '}';
    }
}
