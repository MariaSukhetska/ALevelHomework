package ua.zhdanova.hw21.factory_method;

public class EmailLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Sending email log: " + message);
    }

    @Override
    public void info(String message) {
        System.out.println("INFO: " + message);
    }
}
