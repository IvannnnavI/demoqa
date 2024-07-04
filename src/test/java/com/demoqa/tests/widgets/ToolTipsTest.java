package com.demoqa.tests.widgets;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.WidgetsPage;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolTipsTest extends TestBase {


    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectToolTips().hideIframes();
    }

    @Test
    public void toolTipsTest(){
        new WidgetsPage(driver).hoverToolTip()
        .verifyToolTip("contraryTexToolTip");
    }
}
