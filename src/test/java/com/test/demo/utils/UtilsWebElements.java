package com.test.demo.utils;

import com.test.demo.setup.DriverSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UtilsWebElements extends DriverSetup {
    /*####################################PIM Page CommonUtils####################################*/
    @FindBy(name = "firstName")
    public WebElement txtFirstName;
    @FindBy(css = "[name=lastName]")
    public WebElement txtLastName;
    @FindBy(xpath = "//*[text()='Employee Id']/parent::*//following-sibling::div//input")
    public WebElement txtEmployeeId;
    @FindBy(className = "oxd-switch-input")
    public WebElement btnToggle;
    @FindBy(tagName = "input")
    public List<WebElement> txtUserName;
    @FindBy(tagName = "input")
    public List<WebElement> txtPassword;
    @FindBy(tagName = "input")
    public List<WebElement> txtConfirmPassword;
    @FindBy(css = "[type=submit]")
    public WebElement Submit;
    @FindBy(xpath = "//span[normalize-space()='PIM']")
    public WebElement navigateTab;
    @FindBy(xpath = "//a[text()='Add Employee']")
    public WebElement addEmp;
    @FindBy(xpath = "//a[text()='Employee List']")
    public WebElement EmployeeList;
    @FindBy(xpath = "//*[text()='Employee Name']/parent::*//following-sibling::div//input")
    public WebElement txtSearchEmpName;
    @FindBy(xpath = "//h6[normalize-space()='Personal Details']")
    public WebElement ValidationPageXpath;
    @FindBy(xpath = "//*[text()=\" Delete Selected \"]")
    public WebElement DeleteSelectedXpath;

    @FindBy(xpath = "//*[text()=\" Yes, Delete \"]")
    public WebElement DeleteConfirmXpath;

    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    public WebElement AboutUserXpath;

    @FindBy(xpath = "//*[text()='Logout']")
    public WebElement LogOutUserXpath;

    @FindBy(xpath = "//*[text()='Login']")
    public WebElement LoginUserXpath;

    /*####################################Login Page CommonUtils####################################*/


    @FindBy(name = "username")
    public WebElement txtLoginUserName;
    @FindBy(name = "password")
    public WebElement txtLoginPassword;
    @FindBy(css = "[type=submit]")
    public WebElement btnLogin;


}
