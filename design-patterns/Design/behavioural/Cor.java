/*
CHAIN OF RESPONSIBILITY DESIGN PATTERN – SINGLE FILE EXPLANATION

Scenario:
A logging system where different log levels are handled
by different handlers.
*/

//////////////////// HANDLER ////////////////////
/*
Abstract handler.
Contains reference to next handler in chain.
*/
abstract class Logger {

    protected Logger nextLogger;

    public void setNext(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (canHandle(level)) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    protected abstract boolean canHandle(int level);
    protected abstract void write(String message);
}

//////////////////// LOG LEVELS ////////////////////
class LogLevel {
    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int ERROR = 3;
}

//////////////////// CONCRETE HANDLERS ////////////////////
class InfoLogger extends Logger {

    @Override
    protected boolean canHandle(int level) {
        return level == LogLevel.INFO;
    }

    @Override
    protected void write(String message) {
        System.out.println("ℹ️ INFO: " + message);
    }
}

class DebugLogger extends Logger {

    @Override
    protected boolean canHandle(int level) {
        return level == LogLevel.DEBUG;
    }

    @Override
    protected void write(String message) {
        System.out.println("🐞 DEBUG: " + message);
    }
}

class ErrorLogger extends Logger {

    @Override
    protected boolean canHandle(int level) {
        return level == LogLevel.ERROR;
    }

    @Override
    protected void write(String message) {
        System.out.println("❌ ERROR: " + message);
    }
}

//////////////////// CLIENT ////////////////////
public class ChainOfResponsibilityDemo {

    private static Logger createChain() {
        Logger info = new InfoLogger();
        Logger debug = new DebugLogger();
        Logger error = new ErrorLogger();

        info.setNext(debug);
        debug.setNext(error);

        return info; // head of chain
    }

    public static void main(String[] args) {

        Logger loggerChain = createChain();

        loggerChain.logMessage(LogLevel.INFO, "Application started");
        loggerChain.logMessage(LogLevel.DEBUG, "Debugging user flow");
        loggerChain.logMessage(LogLevel.ERROR, "Something went wrong!");
    }
}
