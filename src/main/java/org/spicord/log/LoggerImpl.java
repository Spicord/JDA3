package org.spicord.log;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;

public final class LoggerImpl implements org.spicord.log.Logger {

    private final Logger log;
    private final String prefix;

    public LoggerImpl(Logger spicordLogger, String name) {
        this.log = spicordLogger;
        this.prefix = "[JDA:" + name + "] ";
    }

    @Override
    public void debug(String msg) {
        log.fine(prefix + msg);
    }

    @Override
    public void debug(String format, Object arg) {
        log.fine(prefix + format(format, arg));
    }

    @Override
    public void debug(String format, Object... arguments) {
        log.fine(prefix + format(format, arguments));
    }

    @Override
    public void debug(String format, Object arg1, Object arg2) {
        log.fine(prefix + format(format, arg1, arg2));
    }

    @Override
    public void debug(String msg, Throwable t) {
        log.fine(prefix + msg);
        t.printStackTrace(System.err);
    }

    @Override
    public void error(String msg) {
        log.severe(prefix + msg);
    }

    @Override
    public void error(String format, Object arg) {
        log.severe(prefix + format(format, arg));
    }

    @Override
    public void error(String format, Object... arguments) {
        log.severe(prefix + format(format, arguments));
    }

    @Override
    public void error(String format, Object arg1, Object arg2) {
        log.severe(prefix + format(format, arg1, arg2));
    }

    @Override
    public void error(String msg, Throwable t) {
        log.severe(prefix + msg);
        t.printStackTrace(System.err);
    }

    @Override
    public void info(String msg) {
        log.info(prefix + msg);
    }

    @Override
    public void info(String format, Object arg) {
        log.info(prefix + format(format, arg));
    }

    @Override
    public void info(String format, Object... arguments) {
        log.info(prefix + format(format, arguments));
    }

    @Override
    public void info(String format, Object arg1, Object arg2) {
        log.info(prefix + format(format, arg1, arg2));
    }

    @Override
    public void info(String msg, Throwable t) {
        log.info(prefix + msg);
        t.printStackTrace(System.err);
    }

    @Override
    public void trace(String msg) {
        log.finer(prefix + msg);
    }

    @Override
    public void trace(String format, Object arg) {
        log.finer(prefix + format(format, arg));
    }

    @Override
    public void trace(String format, Object... arguments) {
        log.finer(prefix + format(format, arguments));
    }

    @Override
    public void trace(String format, Object arg1, Object arg2) {
        log.finer(prefix + format(format, arg1, arg2));
    }

    @Override
    public void trace(String msg, Throwable t) {
        log.finer(prefix + msg);
        t.printStackTrace(System.err);
    }

    @Override
    public void warn(String msg) {
        log.warning(prefix + msg);
    }

    @Override
    public void warn(String format, Object arg) {
        log.warning(prefix + format(format, arg));
    }

    @Override
    public void warn(String format, Object... arguments) {
        log.warning(prefix + format(format, arguments));
    }

    @Override
    public void warn(String format, Object arg1, Object arg2) {
        log.warning(prefix + format(format, arg1, arg2));
    }

    @Override
    public void warn(String msg, Throwable t) {
        log.warning(prefix + msg);
        t.printStackTrace(System.err);
    }

    @Override
    public boolean isDebugEnabled() {
        return log.getLevel().intValue() <= Level.FINE.intValue();
    }

    private static String toString(Object object) {
        if (object == null) {
            return "null";
        }
        return object.toString();
    }

    private static String format(String format, Object... arguments) {
        for (int i = 0; i < arguments.length; i++) {
            format = format.replaceFirst("\\{\\}", Matcher.quoteReplacement(toString(arguments[i])));
        }
        return format;
    }
}
