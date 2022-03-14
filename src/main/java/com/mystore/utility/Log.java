package com.mystore.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
    private static final Logger l = (Logger) LoggerFactory.getLogger(Log.class.getName());

    public static void startTestCase(String sTestCaseName){
        l.info("====================================="+sTestCaseName+" TEST START=========================================");
    }

    public static void endTestCase(String sTestCaseName){
        l.info("====================================="+sTestCaseName+" TEST END=========================================");
    }

    // Need to create below methods, so that they can be called

    public static void info(String message) {

        l.info(message);

    }

    public static void warn(String message) {

        l.warn(message);

    }

    public static void error(String message) {

        l.error(message);

    }

    public static void fatal(String message) {

       // l.fatal(message);

    }

    public static void debug(String message) {

        l.debug(message);

    }
}
