package com.mystore.testCases;

import com.mystore.base.BaseClass;
import com.mystore.pageObjects.HomePage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {

    public HomePage homePage = new HomePage();


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


   /* @Test
    public void verifyProduct() throws Throwable {
        homePage.clickSignInBtn();

    }*/

    @Test
    public void verifyTitle() throws Throwable {
        Log.startTestCase("verifyTitle");
        String pageTitle = homePage.getPageTitle();
        Log.info(pageTitle);
        Assert.assertEquals(pageTitle, "My Store1");
    }


}
