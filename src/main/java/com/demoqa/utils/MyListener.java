package com.demoqa.utils;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

public class MyListener implements WebDriverListener {

    Logger logger = LoggerFactory.getLogger(MyListener.class);
    public MyListener(){
        super();
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElement(driver, locator);
        logger.info("Before find element ->" + locator);
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        WebDriverListener.super.afterFindElement(driver, locator, result);
        logger.info("After find element ->" + locator);
    }

    @Override
    public void beforeFindElements(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElements(driver, locator);
        logger.info("Before find elements ->" + locator);
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        WebDriverListener.super.afterFindElements(driver, locator, result);
        logger.info("After find elements ->" + locator);
        logger.info("List size is " + result.size());

    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        WebDriverListener.super.onError(target, method, args, e);

        logger.info("Something went wrong!!!");
        logger.info("=======================================================================================");
        logger.info("Method--> " + method.getName());
        logger.info("=======================================================================================");
        logger.info("Target exception " + e.getTargetException());

        int i = new Random().nextInt(1000) + 1000;
        String path = "screenshots/screen_" + i + ".png";
        logger.info("Screenshot with error --> " + path);

        WebDriver driver = (ChromeDriver)target;

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File tmp = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tmp,new File(path));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void beforeGet(WebDriver driver, String url) {
        WebDriverListener.super.beforeGet(driver, url);

        logger.info("Before navigate to URL --> " + url);
    }

    @Override
    public void afterGet(WebDriver driver, String url) {
        WebDriverListener.super.afterGet(driver, url);
        logger.info("After navigate to URL --> " + url);
    }

    @Override
    public void afterAccept(Alert alert) {
        WebDriverListener.super.afterAccept(alert);
    }
}

