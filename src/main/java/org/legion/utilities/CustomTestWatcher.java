package org.legion.utilities;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.util.Optional;

public class CustomTestWatcher implements TestWatcher, AfterTestExecutionCallback {

    private static WebDriver driver;
    public void setDriver(WebDriver driver){
        this.driver = driver;
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("Test passed: " + context.getDisplayName());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("Test failed: " + context.getDisplayName());
    }

    @Override
    public void afterTestExecution(ExtensionContext context){
        if(context.getExecutionException().isPresent()){
            final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            String testName = context.getRequiredTestMethod().getName();
            Allure.addAttachment(testName, new ByteArrayInputStream(screenshot));
        }
    }


}
