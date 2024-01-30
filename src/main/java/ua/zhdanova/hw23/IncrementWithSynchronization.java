package ua.zhdanova.hw23;

public class IncrementWithSynchronization {
    private static int counter = 0;
    private static final Object synchronizationObject = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> increment());
        Thread thread2 = new Thread(() -> increment());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Increment counter with synchronization: " + counter);
    }

    private static void increment() {
        for (int i = 0; i < 100_000; i++) {
            try {
                synchronized (synchronizationObject) {
                    counter++;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
