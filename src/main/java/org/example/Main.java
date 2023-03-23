import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

class Main {
    public static void main(String[] args) {
        //    ЗАДАЧА 1;
        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 3);
        int b = calc.minus.apply(a, 1);
        int c = calc.pow.apply(22);

        calc.printlnStr.accept("\n");
        calc.printlnInt.accept(a);

        //ЗАДАЧА 2;
        String s = "String";
        onTaskDoneListener taskListener = System.out::println;
        onTaskErrorListener taskErrorCatcher = System.out::println;
        Worker w = new Worker(taskListener, taskErrorCatcher);
        w.start();
    }

    public static class Worker{
        private onTaskDoneListener callback;
        private onTaskErrorListener errorCallback;

        public Worker(onTaskDoneListener callback, onTaskErrorListener errorCallback){
            this.callback = callback;
            this.errorCallback = errorCallback;
        }

        public void start(){
            for(int i = 0; i < 100; i++){
                if (i == 33){
                    errorCallback.onError("Ошибка");
                }
                callback.onDone("Task on " + i + " iteration");
            }
        }
    }

    @FunctionalInterface
    public interface onTaskDoneListener{
        void onDone(String onDone);
    }

    @FunctionalInterface
    public interface onTaskErrorListener{
        void onError(String onError);
    }

    //1 ЗАДАЧА;
    static public class Calculator{
        static Supplier<Calculator> instance = Calculator::new;
        //бинарные операции;
        BinaryOperator<Integer> plus = (x, y) -> x + y;
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

    public interface Supplier<T>{
        T get();
    }

}