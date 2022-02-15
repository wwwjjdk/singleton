public class Logger {
    private static Logger logger = null;
    protected int num = 1;

    private Logger() {
    }

    public static Logger getInstance() {
        if (logger == null) {
            return logger = new Logger();
        }
        return logger;
    }

    public void log(String msg) {
        System.out.println("[" + System.currentTimeMillis() + "ms " + num++ + "] " + msg);
    }


}

