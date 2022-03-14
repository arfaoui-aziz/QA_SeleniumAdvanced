package com.mystore.Factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {


    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver initDriver(String browserName) {

        System.out.println("Browser value is: " + browserName);

      /*
        switch (browser.toUpperCase()) {
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                tlDriver.set(new FirefoxDriver());
                break;
            case "CHROME":
            default:
                WebDriverManager.chromedriver().setup();
                tlDriver.set(new ChromeDriver());
        }*/
        if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            // Set Browser to ThreadLocalMap
            tlDriver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        } else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            tlDriver.set(new InternetExplorerDriver());
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();

        return getDriver();
    }

    /**
     * this is used to get the driver with ThreadLocal
     *
     * @return WebDriver driver
     */
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

}
