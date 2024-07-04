package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.LoginPage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getBookStore();
        new SidePanel(driver).selectLogin();

    }

    @Test
    public void loginPositiveTest(){
        new LoginPage(driver)
                .enterPersonalData("LeoPold","Davajte1!")
                .clickOnLoginLink()
                .verifyUserName("LeoPold");
    }
}
