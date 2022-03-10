package com.mystore.Factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    private static WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver initDriver(String browser) {

        System.out.println("Browser value is: " + browser);

        switch (browser.toUpperCase()) {
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                tlDriver.set(new FirefoxDriver());
                break;
            case "CHROME":
            default:
                WebDriverManager.chromedriver().setup();
                tlDriver.set(new ChromeDriver());
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
    public WebDriver getDriver() {
        return tlDriver.get();
    }

}
