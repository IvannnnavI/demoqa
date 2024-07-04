package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class InterActionsPage extends BasePage {
    public InterActionsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    WebElement dragMe;

    @FindBy(id = "droppable")
    WebElement dropHere;

    public InterActionsPage actionDragMe() {
        pause(1000);

        new Actions(driver).dragAndDrop(dragMe, dropHere).perform();


        return this;
    }

    public InterActionsPage verifyDropped(String text) {

        Assert.assertTrue(shouldHaveText(dropHere, text, 5));
        return this;
    }

    public InterActionsPage actionDragMeBy(int x, int y) {
        pause(1000);
        moveWithJS(dragMe, 0, 200);


        // get coordinates dragMe(from) and print
        int xOffSet = dragMe.getLocation().getX();
        int yOffSet = dragMe.getLocation().getY();
        System.out.println(" dragMe  x--> " + xOffSet + "***" + " y --> " + yOffSet);

        //// get coordinates dropHere(from) and print
        int xOffSet1 = dropHere.getLocation().getX();
        int yOffSet1 = dropHere.getLocation().getY();
        System.out.println(" dropHere x--> " + xOffSet1 + "***" + " y --> " + yOffSet1);

        //find the difference x1OffSet1  yOffSet1
        xOffSet = (xOffSet1 - xOffSet) + x;
        yOffSet = (yOffSet1 - yOffSet) + y;
        new Actions(driver).dragAndDropBy(dragMe, xOffSet, yOffSet).perform();

        return this;
    }
}
