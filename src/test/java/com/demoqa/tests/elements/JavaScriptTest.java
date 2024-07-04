package com.demoqa.tests.elements;

import com.demoqa.pages.ElementsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptTest extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getElements();
        new SidePanel(driver).selectTextBox();
    }

    @Test
    public void JSExecuterTest(){
        new ElementsPage(driver).enterDataWithJS("Roberto Carlos","roberto@gm.com")
                .clickOnSubmitButtonWithJS()
                .getInnerTextWithJS()
                .refreshWithJS()
                .getInnerTextWithJS()
                .checkURLWithJS()
                .navigateToNewPageWithJS("https://ticket-service-69443.firebaseapp.com")
                .verifyTitleOfPageWithJS()
                .generateAlertWithJS();
    }
}
