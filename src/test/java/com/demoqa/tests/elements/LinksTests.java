package com.demoqa.tests.elements;

import com.demoqa.pages.ElementsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getElements();

    }

    @Test
    public void checkAllLinksTest(){
        new SidePanel(driver).selectLinks();
        new ElementsPage(driver).checkAllURL().checkBrokenList();
    }

    @Test
    public void checkBrokenImages(){
        new SidePanel(driver).selectBrokenLinksImages();
        new ElementsPage(driver).checkBrokenImages();
    }
}
