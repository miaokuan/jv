package pp.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jTest {
    private static final Logger logger = LoggerFactory.getLogger(Log4jTest.class);

    public static void main(String[] args)
    {
        logger.info("Hello {}","SLF4J");
        logger.debug("Hello World");
        logger.info("hello {}", "ereryone");
        logger.warn("chudashile");
    }
}
