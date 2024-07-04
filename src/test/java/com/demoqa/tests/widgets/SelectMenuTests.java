package com.demoqa.tests.widgets;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.WidgetsPage;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectMenuTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getWidgets();
        new SidePanel(driver).getSelectMenu().hideIframes();
    }

    @Test
    public void selectOldStyleTest() {
        new WidgetsPage(driver).selectOldStyle("Indigo");
    }
    @Test
    public void multiSelectTest() {
        new WidgetsPage(driver).multiSelect(new String[]{"Red","Black"});
    }

    @Test
    public void standartMultiSelectTest(){
        new WidgetsPage(driver).standartMultiSelect(new String[]{"Volvo","Audi"});
    }
}
