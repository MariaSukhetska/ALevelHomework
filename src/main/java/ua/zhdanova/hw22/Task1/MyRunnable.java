package ua.zhdanova.hw22.Task1;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("Hello, A-Level №2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread 2 interrupted", e);
            }
        }
    }
}
