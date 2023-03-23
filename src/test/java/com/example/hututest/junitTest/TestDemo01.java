package com.example.hututest.junitTest;


import com.example.hututest.config.MyInterceptor;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayName("a good test")
public class TestDemo01 {
    public static final Logger logger = LoggerFactory.getLogger(TestDemo01.class);
    static MyInterceptor myInterceptor = null;

    @BeforeAll
    static void beforeAll(){
        logger.info("call beforeAll");
        myInterceptor = new MyInterceptor();
    }

    @BeforeEach
    @DisplayName("😱")
    public void beforeEach(){
        logger.info("call beforeEach");
    }

    @Test
    public void succeedingTest1(){
        String result = assertTimeout(ofMillis(20), TestDemo01::greeting);
        assertEquals("yth", result);
    }

    @Test
    @RepeatedTest(10)
    void testOnlyOnCiServer() {
        assumeTrue("CI".equals(System.getenv("ENV")));
        // remainder of test
        System.out.println("11");
    }

    @ParameterizedTest
    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
    void palindromes(String candidate, String a) {
        System.out.println(candidate + "---" + a);
    }

    @Test
    void testOnlyOnDeveloperWorkstation() {
        assumeTrue("DEV".equals(System.getenv("ENV")),
                () -> "Aborting test: not on developer workstation");
        // remainder of test
    }

    @Test
    void testInAllEnvironments() {
        
    }

    @Test
    static void succeedingTest2(){
        logger.info("succeedingTest");
    }

    private static String greeting() {
        return "yth";
    }
}
