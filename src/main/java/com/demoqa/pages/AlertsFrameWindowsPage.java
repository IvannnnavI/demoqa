package com.demoqa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AlertsFrameWindowsPage extends BasePage {
    public AlertsFrameWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    public AlertsFrameWindowsPage waitAlert() {
        click(timerAlertButton);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent()).accept();
        return this;
    }

    @FindBy(id="confirmButton")
    WebElement confirmButton;

    public AlertsFrameWindowsPage selectResult(String text) {
        click(confirmButton);

        if(text != null && text.equals("Ok")){
            driver.switchTo().alert().accept();

        }else if (text != null && text.equals("Cancel")){
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(id = "confirmResult")
    WebElement confirmResult;

    public AlertsFrameWindowsPage verifyResult(String result) {
        Assert.assertTrue(shouldHaveText(confirmResult,result,5));
        return this;
    }

    @FindBy(id = "promtButton")
    WebElement promtButton;

    public AlertsFrameWindowsPage sendMessageToAlert(String message) {
        clickWithJS(promtButton,0,300);

        if (message != null) {
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }
        return this;
    }

    @FindBy(id = "promptResult")
    WebElement promptResult;

    public AlertsFrameWindowsPage verifyMessage(String message) {
        Assert.assertTrue(shouldHaveText(promptResult,message,5));


        return this;
    }

    @FindBy(tagName = "iframe")
    List<WebElement> iframes;

    public AlertsFrameWindowsPage getListOflframes() {

        System.out.println("Number of iframes on the page are " + iframes.size());

        return this;
    }
    public AlertsFrameWindowsPage switchToIframeByIndex(int index) {
        //driver.switchTo().frame(index);
        //by using JS
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Integer numberOfIframes = Integer.parseInt(js.executeScript("return window.length").toString());
        System.out.println("Number of iframes on the page are " + numberOfIframes);
        return this;


    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public AlertsFrameWindowsPage verifyIframeText(String text) {
        Assert.assertTrue(shouldHaveText(sampleHeading,text,5));
        return this;
    }

    @FindBy(id = "frame1")
    WebElement frame1;

    public AlertsFrameWindowsPage switchToIframeByID() {
        driver.switchTo().frame(frame1);
        return this;
    }

    public AlertsFrameWindowsPage returnToMainContent() {
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy(css = "#framesWrapper>div")
    WebElement mainContentText;

    public AlertsFrameWindowsPage verifyMainContentText(String text) {
        Assert.assertTrue(mainContentText.getText().contains(text));
        return this;
    }

    @FindBy(css = "body")
    WebElement body;

    public AlertsFrameWindowsPage handleNestedIframes() {

        System.out.println("Number of iframes on the page are " + iframes.size());

        //switch to parent iframe
        driver.switchTo().frame(frame1);
        //get text from parent iframe
        System.out.println("Iframe 1 is " + body.getText());
        //get number of iframes on parent iframe
        System.out.println("Number of iframes on the parent iframe are " + iframes.size());

        //switch to child iframe
        driver.switchTo().frame(0);
        //get text from child iframe
        System.out.println("Iframe is " + body.getText());

        //switch to parent iframe
        //  driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        //get text from parent iframe
        System.out.println("Iframe 1 is " + body.getText());
        return this;
    }

    @FindBy(id = "tabButton")
    WebElement tabButton;

    public AlertsFrameWindowsPage switchToNewTab(int index) {

        click(tabButton);

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

    public AlertsFrameWindowsPage verifyNewTabTitle(String title) {
        Assert.assertTrue(shouldHaveText(sampleHeading,title,5));
        return this;
    }

}
