package com.mystore.pageObjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BaseClass {

    public MyAccountPage() {
        PageFactory.initElements(getDriver(), this);
    }
}
