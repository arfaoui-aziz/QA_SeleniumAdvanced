package com.mystore.testCases;

import com.mystore.base.BaseClass;
import com.mystore.pageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {

    public HomePage homePage = new HomePage();


    @BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void setup() {
        //   loadConfig();
        launchApp();
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
        String pageTitle = homePage.getPageTitle();
        System.out.println(pageTitle);
        Assert.assertEquals(pageTitle, "My Store");
    }


}
