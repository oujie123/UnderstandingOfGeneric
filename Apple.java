package com.example.myapplication;

import java.util.ArrayList;

public class Apple extends Fruit{
    private int id;

    public Apple(int id) {
        super(id);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
