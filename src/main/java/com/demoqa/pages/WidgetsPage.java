package com.demoqa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class WidgetsPage extends BasePage {
    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;

    public WidgetsPage selectOldStyle(String color) {

        Select select = new Select(oldSelectMenu);
        select.selectByVisibleText(color);
        return this;
    }

    @FindBy(id = "react-select-4-input")
    WebElement inputSelect;

    @FindBy(css = "html")
    WebElement space;

    public WidgetsPage multiSelect(String[] colors) {
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] != null) {
                inputSelect.sendKeys(colors[i]);
                inputSelect.sendKeys(Keys.ENTER);
            }
        }
        click(space);
        return this;
    }

    @FindBy(id = "cars")
    WebElement cars;

    public WidgetsPage standartMultiSelect(String[] car) {
        Select select = new Select(cars);
        for (int i = 0; i <car.length ; i++) {
            if (select.isMultiple()){
                select.selectByVisibleText(car[i]);
            }

        }
        List<WebElement> selectOpt = select.getAllSelectedOptions();
        for (WebElement el:selectOpt){
            System.out.println(el.getText());
        }


        return this;
    }

    @FindBy(css =".range-slider")
    WebElement sliderContainer;


//    public WidgetsPage moveSlider() {
//        pause(1000);
//        click(sliderContaner);
//        moveWithJs(0,300);
//
//        Actions actions = new Actions(driver);
//
//        actions.dragAndDropBy(sliderContaner,300,0);
//        pause(1000);
//        return this;
//    }
public WidgetsPage moveSlider() {
    pause(1000);

    Actions actions = new Actions(driver);
    actions.dragAndDropBy(sliderContainer, 320, 0).perform();
    pause(1000);
    return this;
}

@FindBy(xpath ="//a[.='Main Item 2']" )
WebElement mainItem2;
@FindBy(xpath = "//a[.='SUB SUB LIST »']")
WebElement subSubList;
@FindBy(xpath = "//a[.='Sub Sub Item 1']")
WebElement subItem1;


    public WidgetsPage selectSubMenu() {
        pause(1000);
        moveWithJs(mainItem2,0,200);
        Actions actions = new Actions(driver);
        actions.moveToElement(mainItem2).perform();
        pause(1000);
        actions.moveToElement(subSubList).perform();
        pause(1000);
        return this;
    }

    public WidgetsPage verifySubMenu() {
        Assert.assertTrue(isElementVisible(subItem1));
        return this;
    }

    @FindBy(id = "sliderValue")
    WebElement sliderValue;

    public WidgetsPage verifySliderValue(String number) {
        Assert.assertEquals(sliderValue.getAttribute("value"),number);


        return this;
    }
    @FindBy(xpath = "//a[.='Contrary']")
    WebElement contrary;

    public WidgetsPage hoverToolTip() {
        pause(1000);
       // moveWithJS(contrary,0,200);
        new Actions(driver).moveToElement(contrary).perform();
        pause(2000);
        return this;
    }

    public WidgetsPage verifyToolTip(String value) {
        Assert.assertEquals(getValueAttribute(contrary),value);
        return this;
    }

    @FindBy(id = "autoCompleteMultipleInput")
    WebElement autoCompleteMultipleInput;

    public WidgetsPage autoComplete() {
        moveWithJS(autoCompleteMultipleInput,0,200);
        autoCompleteMultipleInput.sendKeys("a");
        autoCompleteMultipleInput.sendKeys(Keys.DOWN, Keys.ENTER);


        return this;
    }

    @FindBy(id = "autoCompleteMultipleContainer")
    WebElement autoCompleteMultipleContainer ;

    public WidgetsPage verifyAutoComplete(String text) {
        Assert.assertTrue(shouldHaveText(autoCompleteMultipleContainer,text,5));

        return this;
    }
}
