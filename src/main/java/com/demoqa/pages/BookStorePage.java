package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BookStorePage extends BasePage{
    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id= "searchBox")
    WebElement searchBox;

    public BookStorePage typeInSearchFieldInput(String text) {
        type(searchBox,text);
        return this;
    }

    @FindBy(css = ".mr-2>a")
    WebElement nameOfBook  ;

    public BookStorePage verifyText(String text) {
        Assert.assertTrue(nameOfBook.getText().contains(text));


        return this;
    }
}
