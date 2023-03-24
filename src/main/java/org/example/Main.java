package org.example;

public class Main {
    public static void main(String[] args) {
        //ЗАДАЧА 2;
        String s = "String";
        onTaskDoneListener taskListener = System.out::println;
        onTaskErrorListener taskErrorCatcher = System.out::println;
        Worker w = new Worker(taskListener, taskErrorCatcher);
        w.start();
    }
}