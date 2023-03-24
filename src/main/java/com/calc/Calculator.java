package com.calc;

import org.example.Main;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Calculator{
    static Supplier<Calculator> instance = Calculator::new;
    //бинарные операции;
    BinaryOperator<Integer> plus = Integer::sum;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> divide = (x, y) -> x / y;
    //унарные операции;
    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> {
        if (x > 0){
            return x;
        } return x * -1;
    };
    //предикат;
    Predicate<Integer> isPositive = x -> x > 0;
    //консьюмер;
    Consumer<Integer> printlnInt = System.out::print;
    Consumer<String> printlnStr = System.out::print;
    public Calculator(){};
}
