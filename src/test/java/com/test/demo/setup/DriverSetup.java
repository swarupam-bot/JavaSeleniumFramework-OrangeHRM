package com.test.demo.setup;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class DriverSetup {

    public ExtentReports extent = new ExtentReports();
    public ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");
    public WebDriver Driver;


    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/swarupamkumar/IdeaProjects/EndToEndDemo/Driver/chromedriver");

        Driver = new ChromeDriver();

        Driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Driver.manage().window().maximize();

        ExtentTest test = extent.createTest("Launch Browser and website");
        test.log(Status.PASS, "User is able to Login");

        extent.attachReporter(spark);


    }

    @AfterTest
    public void closeDriver() {
        extent.flush();
        Driver.close();

    }
}
