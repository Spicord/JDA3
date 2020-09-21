package org.spicord.log;

public class LoggerFactory {

    private static final NOPLogger NOP = new NOPLogger();

    private static java.util.logging.Logger spicordLogger;

    public static void init(java.util.logging.Logger logger) {
        spicordLogger = logger;
    }

    public static Logger getLogger(String name) {
        if (spicordLogger == null) {
            return NOP;
        } else {
            return new LoggerImpl(spicordLogger, name);
        }
    }

    public static Logger getLogger(Class<?> clazz) {
        return getLogger(clazz.getSimpleName());
    }
}
