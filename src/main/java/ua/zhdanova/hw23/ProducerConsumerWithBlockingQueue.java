package ua.zhdanova.hw23;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
public class ProducerConsumerWithBlockingQueue {
    private static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
    private static volatile boolean isRunning = true;
    public static void main(String[] args) {
        Thread producerThread = new Thread(() -> {
            while (isRunning) {
                produce();
                sleep(500);
            }
        });

        Thread consumerThread = new Thread(() -> {
            while (isRunning) {
                consume();
                sleep(1000);
            }
        });

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void produce() {
        int nextInt = ThreadLocalRandom.current().nextInt(200);
        System.out.println("Producer: " + nextInt + ", queue size: " + queue.size());
        try {
            queue.put(nextInt);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void consume() {
        Integer item = null;
        try {
            item = queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Consumer: " + item + ", queue size: " + queue.size());
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
