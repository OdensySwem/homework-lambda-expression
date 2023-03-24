package com.calc;

public class Main {
    public static void main(String[] args){
        //    ЗАДАЧА 1;
        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 3);
        int b = calc.minus.apply(a, 1);
        int c = calc.pow.apply(22);

        calc.printlnStr.accept("\n");
        calc.printlnInt.accept(a);

    }
}
