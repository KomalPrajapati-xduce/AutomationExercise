package steps;

import base.BaseTest;
import io.cucumber.java.Before;
import utils.DataReader;

public class Hooks {
    private final BaseTest baseTest = new BaseTest();

    @Before
    public void setUp() {
        DataReader.loadData();
        baseTest.setUp();
    }

//    @After
//    public void tearDown() {
//        baseTest.tearDown();
//    }
}
