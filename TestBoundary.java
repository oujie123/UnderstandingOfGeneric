package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * extends 上界
 * super   下界
 * 说明：以下方便记忆的：“上”表示父类，“下”表示子类
 * 口诀：
 * 上界只可往上读，往上赋值；方法只能传递自己或者子类
 * 下界只可向下写，向下赋值；方法只能传递自己或者父类
 *
 * 类关系： apple extends fruit extends food
 */
public class TestBoundary {

    public static void main(String[] args) {
        //演示extends赋值的上界
        List<Food> foods = new ArrayList<>();
        List<Apple> apples = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        //fruits = apples;  //error 往上赋值需要 extends
        List<? extends Fruit> fruits1 = apples;  //向上赋值成功

        //演示向上读取
        Fruit fruit = fruits1.get(0); //ok  上界修饰的可以往上读
        Food food = fruits1.get(0);   //ok  上界修饰的可以往上读
        Object object = fruits1.get(0); //ok  上界修饰的可以往上读
        //Apple apple = fruits1.get(0);  //error 不能往下读

        //演示方法传递
        eat1(fruits); //ok 传递自己
        eat1(apples); //ok  传递子类
        //eat1(foods);  //error 传递了父类


        //演示Super赋值的下界
        List<Food> foodsLower = new ArrayList<>();
        List<Apple> applesLower = new ArrayList<>();
        List<Fruit> fruitsLower = new ArrayList<>();
        //fruitsLower = foodsLower; //error 往下赋值需要super修饰
        List<? super Fruit> fruitList = foodsLower; // 向下赋值ok了

        //演示向下写
        fruitList.add(new Apple(1));  //用下写是ok的
        //fruitList.add(new Food());  //error 用上写是不行的；

        //演示下界方法只能传递自己或者父类
        eat2(fruitsLower); //传递自己ok
        eat2(foodsLower); // 传递父类ok
        //eat2(applesLower); //传递子类error
    }

    public static <T> void eat1(List<? extends Fruit> fruits){}

    public static <T> void eat2(List<? super Fruit> fruits){}
}
