package lesson7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test1 {
    public static final Logger logger = LoggerFactory.getLogger(lesson7.Test1.class);

    @BeforeSuite
    void beforeMethods() {
        logger.info("method beforeAllMethods done");
    }

    @AfterSuite
    void afterMethods() {
        logger.info("method afterAllMethods done");
    }

    @MyTest(priority = 1)
    void testFirst() {
        logger.info("testFirst done");
    }

    @MyTest(priority = 2)
    void testSecond() {
        logger.info("testSecond done");
    }
}
