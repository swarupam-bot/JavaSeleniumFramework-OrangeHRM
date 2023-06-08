package com.test.demo.utils;

import com.test.demo.setup.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


public class CommonUtils extends DriverSetup {

    public static int generateRandomNumber(int min, int max) {
        return (int) Math.round(Math.random() * (max - min) + min);
    }

    public static void waitForElement(WebDriver Driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(Driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        Reporter.log("Minimum timeout for 10 sec");
    }

}
