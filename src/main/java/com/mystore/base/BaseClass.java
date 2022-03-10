package com.mystore.base;


import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    public static Properties props;

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

}
