package com.test.demo.pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.test.demo.utils.UtilsWebElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import static com.test.demo.utils.CommonUtils.waitForElement;

public class OrangeHRMLoginPage extends UtilsWebElements {


    public OrangeHRMLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    // Login to user
    public void doLogin(ExtentReports extent, WebDriver Driver, String username, String password) {

        ExtentTest test = extent.createTest("Log In  with vailed userName and password");
        //Entering UserName
        waitForElement(Driver, txtLoginUserName, 10);
        if (txtLoginUserName.isEnabled()) {
            Reporter.log("Username is enabled.");
            txtLoginUserName.sendKeys(username);
            Reporter.log("Username is entered : " + username);
            test.pass("Able to enter username");

        } else {
            Reporter.log("Username is not enabled.");
            test.fail("Not able to enter username");

        }


        //Entering password
        if (txtLoginPassword.isEnabled()) {
            Reporter.log("Password is enabled.");
            txtLoginPassword.sendKeys(password);
            Reporter.log("Password is entered : " + password);
            test.pass("Able to enter Password");

        } else {
            Reporter.log("Password is not enabled.");
            test.fail("Not able to enter Password");

        }

        if (btnLogin.isEnabled()) {
            Reporter.log("Login Button is enabled.");
            btnLogin.click();
            Reporter.log("Login Button is clicked.");
            test.pass("Able to click on login button ");

        } else {
            Reporter.log("Login Button is not enabled.");
            test.fail("Not able to click on login button ");

        }


    }


}
