package loggerTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class LoggerTest {

    private static Logger log = LoggerFactory.getLogger(LoggerTest.class);

    public static void main(String[] args) {
        log.debug("debug信息");
        log.info("info信息");
        log.warn("warn信息");
        log.error("error信息");
    }
}
