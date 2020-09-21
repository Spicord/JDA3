package org.spicord.log;

import java.util.Arrays;

public interface Logger {

    public static void main(String[] args) {
        Arrays.asList("debug", "error", "info", "trace", "warn").forEach(n -> {
            System.out.printf("void %s(String msg);\n", n);
            System.out.printf("void %s(String format, Object arg);\n", n);
            System.out.printf("void %s(String format, Object... arguments);\n", n);
            System.out.printf("void %s(String format, Object arg1, Object arg2);\n", n);
            System.out.printf("void %s(String msg, Throwable t);\n", n);
        });
        System.out.println("boolean isDebugEnabled();");
    }

    void debug(String msg);
    void debug(String format, Object arg);
    void debug(String format, Object... arguments);
    void debug(String format, Object arg1, Object arg2);
    void debug(String msg, Throwable t);
    void error(String msg);
    void error(String format, Object arg);
    void error(String format, Object... arguments);
    void error(String format, Object arg1, Object arg2);
    void error(String msg, Throwable t);
    void info(String msg);
    void info(String format, Object arg);
    void info(String format, Object... arguments);
    void info(String format, Object arg1, Object arg2);
    void info(String msg, Throwable t);
    void trace(String msg);
    void trace(String format, Object arg);
    void trace(String format, Object... arguments);
    void trace(String format, Object arg1, Object arg2);
    void trace(String msg, Throwable t);
    void warn(String msg);
    void warn(String format, Object arg);
    void warn(String format, Object... arguments);
    void warn(String format, Object arg1, Object arg2);
    void warn(String msg, Throwable t);
    boolean isDebugEnabled();
}
