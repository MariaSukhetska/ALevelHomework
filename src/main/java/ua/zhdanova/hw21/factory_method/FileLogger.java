package ua.zhdanova.hw21.factory_method;

public class FileLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Logging to File: " + message);
    }

    @Override
    public void info(String message) {
        System.out.println("INFO :" + message);
    }
}
