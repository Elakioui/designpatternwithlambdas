package com.tonasolution;

import java.util.function.*;

public class DecoratorPattern {
    
    
    public static void main(String[] args) {

        Function<Integer, Integer> increment = e -> e + e;
        Function<Integer, Integer> doubleIt = e -> e * e;

        doWork(5, increment);
        doWork(5, doubleIt);
        doWork(5, increment.andThen(doubleIt));

    }

    private static void doWork(int i, Function<Integer, Integer> increment) {

        System.out.println(increment.apply(i));
    }


}
