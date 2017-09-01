package ru.s0ber.lesson6;

class Animal {
    String name;
    int runDistance;
    int swimDistance;
    float jumpHeight;

    Animal() {
    }

    boolean run(int distance) {
        return distance <= runDistance;
    }

    boolean swim(int distance) {
        return distance <= swimDistance;
    }

    boolean jump(float height) {
        return height <= jumpHeight;
    }
}
