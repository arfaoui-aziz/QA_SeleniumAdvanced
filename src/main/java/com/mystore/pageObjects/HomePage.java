package com.mystore.pageObjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    @FindBy(xpath = "//a[@class='login']")
    WebElement signInBtn;

    @FindBy(name = "submit_search")
    WebElement searchBtn;

    /**
     * initialize Page inside constructor
     */
    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }


}
