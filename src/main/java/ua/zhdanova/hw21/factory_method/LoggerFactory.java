package ua.zhdanova.hw21.factory_method;

public class LoggerFactory {
    public Logger createLogger(LoggerType loggerType) {
        return switch (loggerType) {
            case FILE -> new FileLogger();
            case EMAIL -> new EmailLogger();
            case DATABASE -> new DatabaseLogger();
            default -> throw new IllegalArgumentException("Unsupported logger type");
        };
    }
}
