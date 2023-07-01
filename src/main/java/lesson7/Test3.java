package lesson7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test3 {
    public static final Logger logger = LoggerFactory.getLogger(Test1.class);


    @MyTest(priority = 3)
    void testThird() {
        logger.info("testThird done");
    }

    @MyTest(priority = 1)
    void testFirst() {
        logger.info("testFirst done");
    }

    @MyTest(priority = 2)
    void testSecond() {
        logger.info("testSecond done");
    }

    @MyTest(priority = 4)
    void testFourth() {
        logger.info("testFourth done");
    }
}