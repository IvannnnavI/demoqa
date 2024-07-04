package com.demoqa.tests.interactions;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.InterActionsPage;
import com.demoqa.pages.SidePanel;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DradAndDropTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getInteractions();
        new SidePanel(driver).selectDroppable().hideIframes();
    }

    @Test
    public void actionDragMeTest() {
        new InterActionsPage(driver).actionDragMe()
                .verifyDropped("Dropped!");
    }

    @Test
    public void actionDragMeByTest(){
        new InterActionsPage(driver).actionDragMeBy(20,10)
                .verifyDropped("Dropped!");
    }
}


