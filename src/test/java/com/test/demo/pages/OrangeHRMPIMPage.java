package com.test.demo.pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.test.demo.utils.UtilsWebElements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import static com.test.demo.utils.CommonUtils.waitForElement;


public class OrangeHRMPIMPage extends UtilsWebElements {

    public OrangeHRMPIMPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //create a new employee
    public void createEmployee(ExtentReports extent, WebDriver Driver, String firstname, String lastname, String employeeId, String username, String password) throws InterruptedException {

        ExtentTest test = extent.createTest("Create a new Employee");
        waitForElement(Driver, navigateTab, 10);
        if (navigateTab.isEnabled()) {
            Reporter.log("PIM tab is enabled.");
            navigateTab.click();
            Reporter.log("PIM tab is clicked");
            test.pass("Able to click on PIM button");

        } else {
            Reporter.log("PIM tab  is not enabled.");
            test.fail("Not able to click on PIM button");

        }

        waitForElement(Driver, addEmp, 10);
        if (addEmp.isEnabled()) {
            Reporter.log("Add Employee is enabled.");
            addEmp.click();
            Reporter.log("Add Employee is clicked");
            test.pass("Able to click on Add Employee button");


        } else {
            Reporter.log("Add Employee is not enabled.");
            test.fail("Not able to click on Add Employee button");

        }

        //Entering Employee Details
        waitForElement(Driver, txtFirstName, 10);
        if (txtFirstName.isEnabled()) {
            Reporter.log("Firstname is enabled.");
            txtFirstName.sendKeys(firstname);
            Reporter.log("Firstname is entered : " + firstname);
            test.pass("Able to enter Firstname");

        } else {
            Reporter.log("Firstname is not enabled.");
            test.fail("Not able to enter Firstname");

        }

        if (txtLastName.isEnabled()) {
            Reporter.log("Lastname is enabled.");
            txtLastName.sendKeys(lastname);
            Reporter.log("Lastname is entered : " + lastname);
            test.pass("Able to enter Lastname");

        } else {
            Reporter.log("Lastname is not enabled.");
            test.fail("Not able to enter Lastname");

        }


        waitForElement(Driver, txtEmployeeId, 10);
        if (txtEmployeeId.isEnabled()) {
            Reporter.log("Employee ID is enabled.");
            txtEmployeeId.sendKeys(Keys.COMMAND + "a");
            txtEmployeeId.sendKeys(employeeId);
            Reporter.log("Employee ID is entered : " + employeeId);
            test.pass("Able to enter Employee ID");

        } else {
            Reporter.log("Employee ID is not enabled.");
            test.fail("Not able to enter Employee ID");

        }


        waitForElement(Driver, btnToggle, 10);
        if (btnToggle.isEnabled()) {
            Reporter.log("Toggle button is enabled.");
            btnToggle.click();
            Reporter.log("Toggle button is clicked");
            test.pass("Able to click Toggle button");

        } else {
            Reporter.log("btnToggle is not enabled.");
            test.fail("Not able to click Toggle button");

        }
        WebElement userName = txtUserName.get(7);
        if (userName.isEnabled()) {
            Reporter.log("User Name is enabled.");
            userName.sendKeys(username);
            Reporter.log("User Name is entered : " + username);
            test.pass("Able to enter User Name");

        } else {
            Reporter.log("User Name is not enabled.");
            test.fail("Not able to enter User  Name");

        }
        WebElement Password = txtPassword.get(10);
        if (Password.isEnabled()) {
            Reporter.log("Password is enabled.");
            Password.sendKeys(password);
            Reporter.log("Password is entered : " + password);
            test.pass("Able to enter Password");

        } else {
            Reporter.log("Password is not enabled.");
            test.fail("Not able to enter Password");

        }

        WebElement ConfPassword = txtConfirmPassword.get(11);
        if (ConfPassword.isEnabled()) {
            Reporter.log("Confirm Password is enabled.");
            ConfPassword.sendKeys(password);
            Reporter.log("Confirm Password is entered : " + password);
            test.pass("Able to enter Confirm Password");

        } else {
            Reporter.log("Confirm Password is not enabled.");
            test.fail("Not able to enter Confirm Password");

        }

        waitForElement(Driver, Submit, 10);
        if (Submit.isEnabled()) {
            Reporter.log("Submit is enabled.");
            Submit.click();
            Reporter.log("Submit is clicked");
            test.pass("Able to click submit button");

        } else {
            Reporter.log("Submit is not enabled.");
            test.fail("Not able to click submit button");

        }

        //Validating new employee created
        waitForElement(Driver, ValidationPageXpath, 10);

        if (ValidationPageXpath.isDisplayed()) {
            Reporter.log("Employee created successfully.");
            test.pass("Able to created new employee successfully.");
            test.info("Validated that Employee is created.");

        } else {
            Reporter.log("Employee Not created successfully.");
            test.fail("Not able to created new employee successfully.");
        }


    }


    //Searching the created employee by name.
    public void SearchEmployeeByValidName(ExtentReports extent, WebDriver Driver, String employeeName) throws InterruptedException {
        ExtentTest test2 = extent.createTest("Search for the new Employee");
        waitForElement(Driver, EmployeeList, 10);
        if (EmployeeList.isEnabled()) {
            Reporter.log("Employee List is enabled.");
            EmployeeList.click();
            Reporter.log("Employee List is clicked");
            test2.pass("Able to click on Employee List");

        } else {
            Reporter.log("Employee List is not enabled.");
            test2.fail("Not able to click on Employee List");

        }

        waitForElement(Driver, txtSearchEmpName, 10);
        if (txtSearchEmpName.isEnabled()) {
            Reporter.log("Search Employee Name TextBox is enabled.");
            txtSearchEmpName.sendKeys(employeeName);
            Reporter.log("Search Employee Name is entered : " + employeeName);
            test2.pass("Able to enter Lastname");

        } else {
            Reporter.log("Search Employee Name  is not enabled.");
            test2.fail("Not able to enter Firstname");

        }

        waitForElement(Driver, Submit, 10);
        if (Submit.isEnabled()) {
            Reporter.log("Submit is enabled.");
            Submit.click();
            Reporter.log("Submit is clicked");
            test2.pass("Able to click on submit button");

        } else {
            Reporter.log("Submit is not enabled.");
            test2.fail("Not able to click on submit button");

        }
        Thread.sleep(2500);
    }

    //Delete the created employee
    public void deleteEmployee(ExtentReports extent, WebDriver Driver, String firstname) {
        ExtentTest test = extent.createTest("Delete the created Employee");
        String xpathDel = "(//*[text()='ReplaceWithFName ']/parent::*/parent::*/child::*)[1]";
        String newStringDel = xpathDel.replace("ReplaceWithFName", firstname);
        WebElement newCheakboxElement = Driver.findElement(By.xpath(newStringDel));

        waitForElement(Driver, newCheakboxElement, 10);
        if (newCheakboxElement.isEnabled()) {
            Reporter.log("Checkbox is enabled.");
            newCheakboxElement.click();
            Reporter.log("Checkbox is clicked");
            test.pass("Able to click on Checkbox");

        } else {
            Reporter.log("Checkbox is not enabled.");
            test.fail("Not able to click on Checkbox");

        }

        waitForElement(Driver, DeleteSelectedXpath, 10);
        if (DeleteSelectedXpath.isEnabled()) {
            Reporter.log("Delete Selected is enabled.");
            DeleteSelectedXpath.click();
            Reporter.log("Delete Selected is clicked");
            test.pass("Able to click on Delete Selected ");

        } else {
            Reporter.log("DeleteSelected is not enabled.");
            test.fail("Not able to click on Delete Selected");

        }


        waitForElement(Driver, DeleteConfirmXpath, 10);
        if (DeleteConfirmXpath.isEnabled()) {
            Reporter.log("Delete confirm is enabled.");
            DeleteConfirmXpath.click();
            Reporter.log("Delete confirm  is clicked");
            test.pass("Able to click on Delete confirm");

        } else {
            Reporter.log("Delete confirm  is not enabled.");
            test.fail("Not able to click on Delete Confirm ");

        }


    }

    //LogOut The Current User
    public void logOut(ExtentReports extent, WebDriver Driver) {
        ExtentTest test = extent.createTest("LogOut from current user");
        waitForElement(Driver, AboutUserXpath, 10);
        if (AboutUserXpath.isEnabled()) {
            Reporter.log("About User is enabled.");
            AboutUserXpath.click();
            Reporter.log("About User is clicked");
            test.pass("Able to click on about user");

        } else {
            Reporter.log("About User is not enabled.");
            test.fail("Not able to click on about user");

        }

        waitForElement(Driver, LogOutUserXpath, 10);
        if (LogOutUserXpath.isEnabled()) {
            Reporter.log("LogOut is enabled.");
            LogOutUserXpath.click();
            Reporter.log("LogOut is clicked");
            test.pass("Able to click on LogOut");

        } else {
            Reporter.log("LogOut is not enabled.");
            test.fail("Not able to click on LogOut");

        }

        waitForElement(Driver, LoginUserXpath, 10);
        if (LoginUserXpath.isDisplayed()) {
            Reporter.log("LogIn Page is Displayed.");
            test.pass("Successfully switched to LogIn page");

        } else {
            Reporter.log("LogIn Page is not Displayed.");
            test.fail("Not able  to switc LogIn page");

        }


    }


}
