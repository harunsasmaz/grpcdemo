package com.grpcdemo.instrument.v1.logger;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerFactory {

    public static Logger getLogger(String name) {
        Logger logger = Logger.getLogger(name);

        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);

        logger.setUseParentHandlers(false);
        logger.addHandler(handler);
        logger.setLevel(Level.ALL);

        return logger;
    }
}
