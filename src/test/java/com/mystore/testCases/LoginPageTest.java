package com.mystore.testCases;

import com.mystore.base.BaseClass;
import com.mystore.pageObjects.HomePage;
import com.mystore.pageObjects.LoginPage;
import com.mystore.pageObjects.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {

    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void setup(String browser) {
        //   loadConfig();
        launchApp(browser);
    }

    @AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void tearDown() {
        getDriver().quit();
    }

    @Test
    public void loginTest() throws Throwable {
        homePage = new HomePage();
        loginPage = homePage.clickSignInBtn();
        //homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        myAccountPage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        String actualURL = myAccountPage.getCurrURL();
        String expectedURL= "http://automationpractice.com/index.php?controller=my-account";
        Assert.assertEquals(actualURL, expectedURL);

    }

}
