package com.mystore.base;


import com.mystore.Factory.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
/*
    private static Properties props;
    public WebDriver driver;

    @BeforeSuite(groups = {"Smoke", "Sanity", "Regression"})
    public void loadConfig() {

        try {
            props = new Properties();
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "\\Configuration\\config.properties");
            props.load(ip);
            System.out.println(props);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }





    public static Properties getProps() {
        return props;
    }
*/

    public static Properties prop;

    // Declare ThreadLocal Driver
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //loadConfig method is to load the configuration
    @BeforeSuite(groups = {"Smoke", "Sanity", "Regression"})
    public void loadConfig() {


        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "\\Configuration\\config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void launchApp(String browserName) {

        //String browserName = prop.getProperty("browser");
        BrowserFactory browserFactory = new BrowserFactory();
        browserFactory.initDriver(browserName);
        BrowserFactory.getDriver().manage().timeouts().implicitlyWait
                (Integer.parseInt(prop.getProperty("implicitWait")), TimeUnit.SECONDS);
        //PageLoad TimeOuts
        BrowserFactory.getDriver().manage().timeouts().pageLoadTimeout
                (Integer.parseInt(prop.getProperty("pageLoadTimeOut")), TimeUnit.SECONDS);
        //Launching the URL
        BrowserFactory.getDriver().get(prop.getProperty("BASE_URL"));
    }

    public static WebDriver getDriver() {
        // Get Driver from threadLocalmap
        return BrowserFactory.getDriver();
    }
    public static Properties getProps() {
        return prop;
    }


    /*@AfterSuite(groups = { "Smoke", "Regression","Sanity" })
    public void afterSuite() {
        ExtentManager.endReport();
    }*/


}
