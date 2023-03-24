package org.example;

public class Worker{
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

