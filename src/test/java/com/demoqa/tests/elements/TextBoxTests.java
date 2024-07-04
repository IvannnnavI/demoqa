package com.demoqa.tests.elements;

import com.demoqa.pages.ElementsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.tests.TestBase;
import com.demoqa.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTests extends TestBase {

    HomePage homePage;
    SidePanel sidePanel;
    ElementsPage elementsPage;

    @BeforeMethod
    public void precondition(){
        homePage = new HomePage(driver);
        sidePanel = new SidePanel(driver);
        elementsPage = new ElementsPage(driver);

        homePage.getElements();
        sidePanel.selectTextBox();
    }

    @Test(dataProviderClass = DataProviders.class,dataProvider = "addNewUserFromCsv")
    public void keyBoardEventTest(String name,String email, String address){
        elementsPage.enterPersonalData(name,email)
                .keyBoardEvent(address)
                .submit()
                .verifyCopyPastText();
    }
}
