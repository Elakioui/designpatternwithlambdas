package com.tonasolution;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StrategyPattern {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(totalValues(numbers, e -> true));
        System.out.println(totalValues(numbers, Util::isEven));
        System.out.println(totalValues(numbers, Util::isOdd));
    }

    private static int totalValues(
            List<Integer> numbers,
            Predicate<Integer> selector
    ) {

        return numbers.stream()
                .filter(selector)
                .mapToInt( e -> e)
                .sum();

    }
}

class Util {

    public static boolean isEven(int number){
        return number % 2 == 0;
    }

    public static boolean isOdd(int number){
        return number % 2 != 0;
    }
}
