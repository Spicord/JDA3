package org.spicord.log;

public class NOPLogger implements Logger {

    @Override
    public void debug(String msg) {}

    @Override
    public void debug(String format, Object arg) {}

    @Override
    public void debug(String format, Object... arguments) {}

    @Override
    public void debug(String format, Object arg1, Object arg2) {}

    @Override
    public void debug(String msg, Throwable t) {}

    @Override
    public void error(String msg) {}

    @Override
    public void error(String format, Object arg) {}

    @Override
    public void error(String format, Object... arguments) {}

    @Override
    public void error(String format, Object arg1, Object arg2) {}

    @Override
    public void error(String msg, Throwable t) {}

    @Override
    public void info(String msg) {}

    @Override
    public void info(String format, Object arg) {}

    @Override
    public void info(String format, Object... arguments) {}

    @Override
    public void info(String format, Object arg1, Object arg2) {}

    @Override
    public void info(String msg, Throwable t) {}

    @Override
    public void trace(String msg) {}

    @Override
    public void trace(String format, Object arg) {}

    @Override
    public void trace(String format, Object... arguments) {}

    @Override
    public void trace(String format, Object arg1, Object arg2) {}

    @Override
    public void trace(String msg, Throwable t) {}

    @Override
    public void warn(String msg) {}

    @Override
    public void warn(String format, Object arg) {}

    @Override
    public void warn(String format, Object... arguments) {}

    @Override
    public void warn(String format, Object arg1, Object arg2) {}

    @Override
    public void warn(String msg, Throwable t) {}

    @Override
    public boolean isDebugEnabled() {
        return false;
    }
}
