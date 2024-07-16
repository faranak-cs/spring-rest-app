package com.example.springrestapp;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.assertj.core.api.Fail.fail;


public class DemoTest {

    @BeforeAll
    static void initAll(){
        // SERVICES
        // IT COULD BE DOCKER IMAGES THAT MUST BE RUNNING PRIOR TO RUNNING TESTS
    }

    @BeforeEach
    void init(){
        // ANY SPECIFIC SERVICE YOU WANT TO BE RUNNING BEFORE TESTS
    }

    @Test
    public void succeedingTest(){
        // ACTUAL TEST
    }

//    @Test
//    public void failingTest(){
//        // FAIL TEST
//        fail("A failing test");
//    }

    @Test
    @Disabled("for demo")
    public void skippedTest(){
        // WILL NOT BE EXECUTED
    }

    @Test
    public void abortedTest(){
        assumeTrue("abc".contains("A"));

        // IF ASSUMPTION IS TRUE, THEN BELOW CODE WORKS
        fail("test should have been aborted");
    }

    @AfterEach
    void tearDown(){
        // CLOSES SERVICE
    }

    @AfterAll
    static void tearDownAll(){
        // CLOSES ALL THE SERVICES
    }

}
