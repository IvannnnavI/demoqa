package com.demoqa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.NoSuchElementException;

public abstract class BasePage {
    WebDriver driver;
    JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    public void clickWithJS(WebElement element, int x, int y) {
        js.executeScript("window.scrollBy(" + x + " , " + y +")");
        click(element);
    }
    public void typeWithJS (WebElement element,String text, int x, int y){
        if (text != null) {
            clickWithJS(element,x,y);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }


    public boolean shouldHaveText(WebElement element, String text, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void hideIframes() {
        hideAd();
        hideFooter();
    }

    private void hideFooter() {
        js.executeScript("document.querySelector('footer').style.display='none';");
    }

    private void hideAd() {
        js.executeScript("document.getElementById('fixedban').style.display='none';");
    }
    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void moveWithJs(WebElement element, int x, int y) {
        js.executeScript("window.scrollBy(" + x + " , " + y +")");

    }

    public boolean isElementVisible(WebElement el) {
        try {
            el.isDisplayed();
            return true;
        }catch (NoSuchElementException ex) {
            ex.getMessage();
        return false;
        }

    }
    public void moveWithJS(WebElement element, int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y +")");
    }

    public String getValueAttribute(WebElement element) {
        return element.getAttribute("aria-describedby");
    }
    public void clickWithRectangle(WebElement element, int x,int y){

        Rectangle rectangle = element.getRect();

        int offSetX = rectangle.getWidth()/x;
        int offSetY = rectangle.getHeight()/y;

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.moveByOffset(-offSetX,-offSetY).click().perform();

    }

    public void verifyLinks(String linkUrl) {

        try {
            URL url = new URL(linkUrl);

            // create URL connection and get response code

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();

            if (connection.getResponseCode() >= 400) {
                System.out.println(linkUrl + " - " + connection.getResponseMessage() + "is a broken link");
            } else {
                System.out.println(linkUrl + " - " + connection.getResponseMessage());
            }
        } catch (IOException e) {
            System.out.println(linkUrl + " - " + e.getMessage() + " - Error occurred");
        }
    }
}
