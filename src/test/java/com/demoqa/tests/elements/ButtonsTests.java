package com.demoqa.tests.elements;

import com.demoqa.pages.ElementsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getElements();
        new SidePanel(driver).selectButtons().hideIframes();
    }

    @Test
    public void doubleClickTest(){
        new ElementsPage(driver).doubleClick()
                .verifyDoubleClick("double click");
    }

    @Test
    public void rightClickTest(){
        new ElementsPage(driver).rightClick()
                .verifyRightClick("right click");
    }
}
