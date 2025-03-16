package org.example.restWithoutBDD;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTestNG implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

}

//    public class TestClassSample {
//
//        @Test(retryAnalyzer = RetryTestNG.class)
//        public void test2() {
//            Assert.fail();
//        }
//    }
