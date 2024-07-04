package com.demoqa.tests.alertsFrameWindows;

import com.demoqa.pages.AlertsFrameWindowsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getAlertsFrameWindows();
        new SidePanel(driver).selectAlerts();

    }

    @Test
    public void waitAlertTest(){
        new AlertsFrameWindowsPage(driver).waitAlert();
    }

    @Test
    public void selectConfirmTest(){
        new AlertsFrameWindowsPage(driver).selectResult("Cancel")
                .verifyResult("Cancel");
    }

    @Test
    public void sendMessageToAlertTest(){


        new AlertsFrameWindowsPage(driver).sendMessageToAlert("Hello World!!")
                .verifyMessage("Hello World!!");
    }

}
