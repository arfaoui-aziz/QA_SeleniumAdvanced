package com.mystore.pageObjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    Action action = new Action();

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "SubmitLogin")
    WebElement loginBtn;

    @FindBy(id = "email_create")
    WebElement createAccountEmail;
    @FindBy(id = "SubmitCreate")
    WebElement createAccountBtn;


    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public MyAccountPage login(String email, String password) {
        action.type(this.email, email);
        action.type(this.password, password);
        action.click(getDriver(), loginBtn);
        return new MyAccountPage();
    }

    public void createAccount(String email) {
        action.type(this.createAccountEmail, email);
        action.click(getDriver(), createAccountBtn);
    }

}
