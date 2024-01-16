package ua.zhdanova.hw22.Task2;
public class Main {
    public static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread incrementThread = new Thread(() -> {
            try {
                for (int i = 0; i < 7; i++) {
                    counter++;
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException("IncrementThread was interrupted", e);
            }
        });

        incrementThread.start();
        incrementThread.join();

        System.out.println("Main thread: Counter value is " + counter);
    }
}