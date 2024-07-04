package com.demoqa.tests.alertsFrameWindows;

import com.demoqa.pages.AlertsFrameWindowsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframesTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getAlertsFrameWindows();
        new SidePanel(driver).selectFrames();
    }
    @Test
    public void framesTest(){
        new AlertsFrameWindowsPage(driver).getListOflframes();
    }
    @Test
    public void switchToIframeByIndexTest() {
        new AlertsFrameWindowsPage(driver).switchToIframeByIndex(1)
                .verifyIframeText("This is a sample page");
    }

    @Test
    public void switchToIframeByIDTest() {
        new AlertsFrameWindowsPage(driver).switchToIframeByID().returnToMainContent()
                .verifyMainContentText("There are 2 Iframes in this page");
    }
}
