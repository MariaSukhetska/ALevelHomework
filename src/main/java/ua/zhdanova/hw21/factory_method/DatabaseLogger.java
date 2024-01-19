package ua.zhdanova.hw21.factory_method;

public class DatabaseLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Logging to Database: " + message);
    }

    @Override
    public void info(String message) {
        System.out.println("INFO: " + message);
    }
}
