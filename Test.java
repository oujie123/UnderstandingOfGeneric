package com.example.myapplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 泛型的简单应用
 * 从没用泛型慢慢演进
 */
public class Test {

    //普通不使用泛型的方法。
    //有个需求需要把香蕉或者更多水果copy一下，难道需要重新写N个copy方法么？
    //答案不是的，出现了泛型copy2
    public static void copy1(List<Apple> dest,List<Apple> src){
        Collections.copy(dest,src);
    }

    //现在可以把无数多相同的水果相互copy了，但是又有一个需求了
    //现在苹果是确定了的，我想想找一个水果list把苹果放进去，于是就出现了copy3
    public static <T> void copy2(List<T> dest,List<T> src){
        Collections.copy(dest,src);
    }

    //现在找到一个水果list放苹果了。但是现在还有一个需求
    //就是现在水果list确定了，我要放的水果不确定，于是有了copy4
    public static <T> void copy3(List<? super T> dest,List<T> src){
        Collections.copy(dest,src);
    }

    //这个就是Collections.copy的终极用法了。
    //public static <T> void copy(@RecentlyNonNull List<? super T> dest, @RecentlyNonNull List<? extends T> src)
    public static <T> void copy4(List<? super T> dest,List<? extends T> src){
        Collections.copy(dest,src);
    }

    public static void main(String[] args) {
        //新建两个苹果list
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(1));
        List<Apple> apples1 = new ArrayList<>();
        apples1.add(new Apple(2));

        //新建两个香蕉list
        List<Banana> bananas = new ArrayList<>();
        bananas.add(new Banana(1));
        List<Banana> bananas1 = new ArrayList<>();
        bananas1.add(new Banana(2));

        //新建水果list
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Apple(10)); //先要告诉编译器fruit是放的苹果，否者copy3的dest参数编译器不知道放什么

        //普通方法
        copy1(apples,apples1);

        //使用泛型方法
        copy2(bananas,bananas1);

        //苹果往水果盘子放
        Test.<Apple>copy3(fruits,apples);  //注意这里苹果是确认的了

        //水果list确定了放任意水果
        Test.<Fruit>copy4(fruits,apples);
    }
}
