package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName-value")
    WebElement userNameValue;

    public ProfilePage verifyUserName(String text) {
        Assert.assertTrue(userNameValue.getText().equals(text));
        return this;
    }
}
