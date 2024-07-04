package com.demoqa.tests.elements;

import com.demoqa.pages.ElementsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RobotTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getElements();
        new SidePanel(driver).selectUpload().hideIframes();
    }

    @Test
    public void performKeyEventsWithRobotTest() {
        new ElementsPage(driver).performKeyEventsWithRobot().verifyPath("C:\\fakepath\\D1.txt");
    }
    @Test
    public void performMouseEventTests(){
        new ElementsPage(driver).performMouseEvent().verifyPath("C:\\fakepath\\D1.txt");
    }

}
