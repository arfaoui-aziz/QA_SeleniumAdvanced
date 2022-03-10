package com.mystore.base;


import com.mystore.Factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    private static Properties props;
    private WebDriver driver;

    @BeforeSuite()
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

    public void launchBrowser() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.initDriver(props.getProperty("browser"));
    }

    public static Properties getProps() {
        return props;
    }

    public WebDriver getDriver() {
        return driver;
    }

}
