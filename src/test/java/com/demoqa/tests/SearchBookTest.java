package com.demoqa.tests;

import com.demoqa.pages.BookStorePage;
import com.demoqa.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchBookTest extends TestBase{
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getBookStore();
    }

    @Test
    public void searchBookTest(){
        new BookStorePage(driver).typeInSearchFieldInput("Git")
                .verifyText("Git");

    }
}
