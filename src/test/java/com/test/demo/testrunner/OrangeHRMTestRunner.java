package com.test.demo.testrunner;

import com.test.demo.pages.OrangeHRMLoginPage;
import com.test.demo.pages.OrangeHRMPIMPage;
import com.test.demo.setup.DriverSetup;
import com.test.demo.utils.CommonUtils;
import org.testng.annotations.Test;


public class OrangeHRMTestRunner extends DriverSetup {


    //pushing second time

    OrangeHRMLoginPage loginPage;
    OrangeHRMPIMPage pimPage;
    String firstname = "Swarupam";
    String lastname = "Kumar";
    int empId = CommonUtils.generateRandomNumber(10000, 99999);
    String employeeId = String.valueOf(empId);
    String username = "Swarupam" + CommonUtils.generateRandomNumber(1000, 9999);
    String password = "Swaru@123";
    String LoginUsername = "admin";
    String LoginPassword = "admin123";


    @Test(priority = 1, description = "Login a user")
    public void doLoginUser() {
        loginPage = new OrangeHRMLoginPage(Driver);
        loginPage.doLogin(extent, Driver, LoginUsername, LoginPassword);
    }

    @Test(priority = 2, description = "Create a employee")
    public void createEmployee() throws InterruptedException {
        pimPage = new OrangeHRMPIMPage(Driver);
        pimPage.createEmployee(extent, Driver, firstname, lastname, employeeId, username, password);
    }

    @Test(priority = 3, description = "Search created employee")
    public void searchEmployee() throws InterruptedException {
        pimPage = new OrangeHRMPIMPage(Driver);
        String FullName = firstname + " " + lastname;
        pimPage.SearchEmployeeByValidName(extent, Driver, FullName);
    }

    @Test(priority = 4, description = "Delete created employee")
    public void deleteCreatedEmp() {
        pimPage = new OrangeHRMPIMPage(Driver);
        pimPage.deleteEmployee(extent, Driver, firstname);
    }

    @Test(priority = 5, description = "LogOut the current User")
    public void logOutUser() {
        pimPage = new OrangeHRMPIMPage(Driver);
        pimPage.logOut(extent, Driver);
    }


}
