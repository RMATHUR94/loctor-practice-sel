package utils.reporter;
//This is useful when you're running tests in parallel, which you have been working with in TestNG.ThreadLocal maintains a separate ExtentTest object for each thread.

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
    private static ThreadLocal<ExtentTest> extentTest =
            new ThreadLocal<>();

    public static void setTest(ExtentTest test) {
        extentTest.set(test);
    }

    public static ExtentTest getTest() {
        return extentTest.get();
    }

    public static void removeTest() {
        extentTest.remove();
    }
}
