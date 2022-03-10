package com.mystore.pageObjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    Action action = new Action();

    @FindBy(xpath = "//a[@class='login']")
    WebElement signInBtn;

    @FindBy(name = "submit_search")
    WebElement searchBtn;

    @FindBy(id = "search_query_top")
    private WebElement searchProductBox;

    /**
     * initialize Page inside constructor
     */
    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public LoginPage clickSignInBtn() throws Throwable {
        action.click(getDriver(), signInBtn);
        return new LoginPage();
    }

    public String getPageTitle() throws Throwable {
        return getDriver().getTitle();
    }

    public searchResultPage searchProduct(String productName) throws Throwable {
        action.type(searchProductBox, productName);
        action.click(getDriver(), searchBtn);
        return new searchResultPage();
    }

}
