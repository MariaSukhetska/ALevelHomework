package ua.zhdanova.hw21.factory_method;

public class Main {
    public static void main(String[] args) {
        // Створюємо фабрику логгерів
        LoggerFactory loggerFactory = new LoggerFactory();

        // Створюємо логгер
        Logger logger = loggerFactory.createLogger(LoggerType.EMAIL);
        logger.log("Sending message");
        logger.info("Really important information about: "
                + "a secret scientific project on the development of photonic engines");

        logger = loggerFactory.createLogger(LoggerType.FILE);
        logger.log("File log message");
        logger.info("Unique File Information: Don't tell anyone!");

        logger = loggerFactory.createLogger(LoggerType.DATABASE);
        logger.log("Database log message");
        logger.log("Hibernate log information: how to fix LazyInitializationException");
    }
}

