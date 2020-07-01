package com.example.myapplication;

public class Fruit extends Food{
    private int fruitId;

    public Fruit(){}

    public Fruit(int fruitId) {
        this.fruitId = fruitId;
    }

    public int getFruitId() {
        return fruitId;
    }

    public void setFruitId(int fruitId) {
        this.fruitId = fruitId;
    }
}
