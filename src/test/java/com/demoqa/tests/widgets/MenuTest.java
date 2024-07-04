package com.demoqa.tests.widgets;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.WidgetsPage;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuTest extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getWidgets();
        new SidePanel(driver).getMenu().hideIframes();
    }

    @Test
    public void selectSubMenuTest(){
        new WidgetsPage(driver).selectSubMenu()
                .verifySubMenu();
    }
}
