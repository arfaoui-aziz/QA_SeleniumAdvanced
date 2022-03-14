package com.mystore.pageObjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage extends BaseClass {


    Action action = new Action();


    @FindBy(xpath = "//a[normalize-space()='Sign in']")
    WebElement signInBtn;


    @FindBy(name = "submit_search")
    WebElement searchBtn;

    @FindBy(id = "search_query_top")
    WebElement searchProductBox;

    /**
     * initialize Page inside constructor
     */
    public HomePage() {

       // AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(getDriver(),100);
        PageFactory.initElements(getDriver(), this);
    }

  public LoginPage clickSignInBtn() throws Throwable {
        System.out.println(signInBtn);
        System.out.println(getDriver().findElement(By.xpath("//a[normalize-space()='Sign in']")));
        signInBtn.click();
        return new LoginPage();
    }

    public String getPageTitle() throws Throwable {
        System.out.println(driver);
        return getDriver().getTitle();
    }

    public searchResultPage searchProduct(String productName) throws Throwable {
        action.type(searchProductBox, productName);
        action.click(getDriver(), searchBtn);
        return new searchResultPage();
    }

}
