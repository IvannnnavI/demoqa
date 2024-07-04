package com.demoqa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;

public class ElementsPage extends BasePage {
    JavascriptExecutor js;

    public ElementsPage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }

    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickBtn;

    public ElementsPage doubleClick() {
        pause(1000);

        new Actions(driver).doubleClick(doubleClickBtn).perform();
        return this;
    }

    @FindBy(id = "doubleClickMessage")
    WebElement doubleClickMessage;

    public ElementsPage verifyDoubleClick(String text) {
        Assert.assertTrue(shouldHaveText(doubleClickMessage, text, 5));

        return this;
    }

    @FindBy(id = "rightClickBtn")
    WebElement rightClickBtn;

    public ElementsPage rightClick() {
        pause(1000);
        new Actions(driver).contextClick(rightClickBtn).perform();


        return this;
    }

    @FindBy(id = "rightClickMessage")
    WebElement rightClickMessage;

    public ElementsPage verifyRightClick(String text) {
        Assert.assertTrue(shouldHaveText(rightClickMessage, text, 5));

        return this;
    }

    @FindBy(id = "uploadFile")
    WebElement uploadFile;

    public ElementsPage performKeyEventsWithRobot() {
        pause(1000);
        moveWithJS(uploadFile, 0, 200);
        clickWithRectangle(uploadFile, 10, 3);

        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        // press Shift key
        robot.keyPress(KeyEvent.VK_SHIFT);
        pause(1000);
        //press d
        robot.keyPress(KeyEvent.VK_D);
        //release shift key
        robot.keyRelease(KeyEvent.VK_SHIFT);
        //press 1,.,t,x,t
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_PERIOD);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_X);
        robot.keyPress(KeyEvent.VK_T);
        // press ENTER key
        robot.keyPress(KeyEvent.VK_ENTER);

        return this;
    }

    @FindBy(id = "uploadedFilePath")
    WebElement uploadedFilePath;

    public ElementsPage verifyPath(String path) {
        Assert.assertTrue(shouldHaveText(uploadedFilePath, path, 5));


        return this;
    }

    public ElementsPage performMouseEvent() {
        pause(1000);
        moveWithJS(uploadFile, 0, 200);
        clickWithRectangle(uploadFile, 10, 3);

        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        // find x and y coordinate to pass to mouseMove method
        //get Window size
        Dimension dimension = driver.manage().window().getSize();
        System.out.println("Dimension x and y: " + dimension.getWidth() + "*****" + dimension.getHeight());

        //get point of file location
        int x = dimension.getWidth() / 4 + 800;
        int y = dimension.getHeight() / 3 + 50;
        robot.mouseMove(x, y);
        pause(1000);
        // click left Mouse Button
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        // release left mouse button
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        // press Enter key
        robot.keyPress(KeyEvent.VK_ENTER);


        return this;
    }

    public ElementsPage enterDataWithJS(String name, String email) {

        js.executeScript("document.getElementById('userName').value=' " + name + "';");
        js.executeScript("document.getElementById('userName').style.border='5px solid red';");
        js.executeScript("document.getElementById('userEmail').value=' " + email + "';");
        js.executeScript("document.getElementById('userEmail').style.border='5px solid green';");


        return this;
    }

    public ElementsPage clickOnSubmitButtonWithJS() {
        js.executeScript("document.querySelector('#submit').style.backgroundColor='Red';");
        js.executeScript("document.querySelector('#submit').click();");


        return this;
    }

    public ElementsPage getInnerTextWithJS() {

        String innerText = js.executeScript("return document.documentElement.innerText;").toString();
        System.out.println(innerText);
        System.out.println("***************************************************************");

        return this;
    }

    public ElementsPage refreshWithJS() {

        js.executeScript("history.go(0);");

        return this;
    }

    public ElementsPage checkURLWithJS() {
        String url = js.executeScript("return document.URL;").toString();
        System.out.println("URL -->" + url);
        System.out.println("=====================================================================");

        return this;
    }

    public ElementsPage navigateToNewPageWithJS(String url) {

        js.executeScript("window.location=' " + url + " ' ;");


        return this;
    }

    public ElementsPage verifyTitleOfPageWithJS() {

        String title = js.executeScript("return document.title;").toString();
        System.out.println("Title os the page is " + title);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


        return this;
    }

    public ElementsPage generateAlertWithJS() {

        js.executeScript("alert('Hello World!!!');");
        js.executeScript("window.confirm=function(){return true;}");
        return this;
    }

    @FindBy(css = "a")
    List<WebElement> allLinks;

    public ElementsPage checkAllURL() {
        String url = "";


        System.out.println("Total Links on the web page: " + allLinks.size());

        Iterator<WebElement> iterator = allLinks.iterator();

        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
        }

        return this;
    }

    public ElementsPage checkBrokenList() {

        for (int i = 0; i < allLinks.size(); i++) {
            WebElement element = allLinks.get(i);
            String url = element.getAttribute("href");
            verifyLinks(url);

        }

        return this;
    }

    @FindBy(css = "img")
    List<WebElement> images;

    public ElementsPage checkBrokenImages() {

        System.out.println("Total images on the Web Page: " + images.size());

        //check the received images links
        for (int i = 0; i < images.size(); i++) {
            WebElement image = images.get(i);
            String imageURL = image.getAttribute("src");
            verifyLinks(imageURL);

            // check images with JS executor
            try {
                boolean imageDisplay = (Boolean) ((JavascriptExecutor) driver)
                        .executeScript(("return (typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth>0);"), image);


                if (imageDisplay) {
                    System.out.println("Display - OK!");
                    System.out.println("=============================================");
                } else {
                    System.out.println("Display - Broken");
                    System.out.println("===============================================");
                }
            } catch (Exception e) {
                System.out.println("Error Occurred!");;
            }
        }

        return this;
    }

    @FindBy(id = "userName")
    WebElement userName;
    @FindBy(id = "userEmail")
    WebElement userEmail;

    public ElementsPage enterPersonalData(String name, String email) {
        moveWithJS(userName,0,300);
        type(userName,name);
        type(userEmail,email);
        return this;
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public ElementsPage keyBoardEvent(String address) {

        type(currentAddress,address);

        Actions actions = new Actions(driver);

        //select currentAddress
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        // copy current address
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        //press TAB to switch to permanent address
        actions.sendKeys(Keys.TAB).perform();
        //past current address
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        pause(1000);



        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;


    public ElementsPage submit() {

        clickWithJS(submit,0,200);

        return this;
    }

    @FindBy(css = ".border #currentAddress")
    WebElement currentAddressResult;

    @FindBy(css = ".border #permanentAddress")
    WebElement permanentAddressResult;

    public ElementsPage verifyCopyPastText() {

        String[] current = currentAddressResult.getText().split(":");
        String[] permanent = permanentAddressResult.getText().split(":");
        Assert.assertEquals(permanent[1],current[1]);


        return this;
    }
}
