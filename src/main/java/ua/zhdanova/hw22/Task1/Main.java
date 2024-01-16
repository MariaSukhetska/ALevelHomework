package ua.zhdanova.hw22.Task1;

public class Main {
    public static void main(String[] args) {
        MyThread numberThread = new MyThread();
        numberThread.start();

        MyRunnable myRunnable = new MyRunnable();
        Thread runnableThread = new Thread(myRunnable);
        runnableThread.start();
    }
}