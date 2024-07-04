package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends BasePage {
    public SidePanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Login']")
    WebElement login;

    public LoginPage selectLogin() {
        clickWithJS(login, 0, 500);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;

    public AlertsFrameWindowsPage selectAlerts() {
        clickWithJS(alerts, 0, 200);
        return new AlertsFrameWindowsPage(driver);
    }

    @FindBy(xpath = "//span[.='Frames']")
    WebElement frames;

    public AlertsFrameWindowsPage selectFrames() {
        clickWithJS(frames, 0, 300);
        return new AlertsFrameWindowsPage(driver);
    }

    @FindBy(xpath = "//span[.='Nested Frames']")
    WebElement nestedFrames;

    public AlertsFrameWindowsPage selectNestedFrames() {
        clickWithJS(nestedFrames, 0, 300);
        return new AlertsFrameWindowsPage(driver);
    }

    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindows;

    public AlertsFrameWindowsPage selectBrowserWindows() {
        click(browserWindows);
        return new AlertsFrameWindowsPage(driver);
    }

    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenu;

    public WidgetsPage getSelectMenu() {
        clickWithJS(selectMenu, 0, 600);
        return new WidgetsPage(driver);
    }

    @FindBy(xpath = "//span[.='Slider']")
    WebElement slider;

    public WidgetsPage selectSlider() {
        clickWithJS(slider, 0, 300);
        return new WidgetsPage(driver);
    }


    @FindBy(xpath = "//span[.='Menu']")
    WebElement menu;

    public WidgetsPage getMenu() {
        clickWithJS(menu, 0, 400);
        return new WidgetsPage(driver);
    }

    @FindBy(xpath = "//span[.='Droppable']")
    WebElement droppable;

    public InterActionsPage selectDroppable() {

        clickWithJS(droppable, 0, 300);
        return new InterActionsPage(driver);
    }

    @FindBy(xpath = "//span[.='Tool Tips']")
    WebElement toolTips;

    public WidgetsPage selectToolTips() {

        clickWithJS(toolTips,0,600);

        return new WidgetsPage(driver);
    }
    @FindBy(xpath = "//span[.='Buttons']")
    WebElement buttons;

    public ElementsPage selectButtons() {
        clickWithJS(buttons,0,100);
        return new ElementsPage(driver);
    }
    @FindBy(xpath = "//span[.='Upload and Download']")
    WebElement upload;

    public ElementsPage selectUpload() {
        clickWithJS(upload,0,300);
        return new ElementsPage(driver);
    }
    @FindBy(xpath = "//span[.='Auto Complete']")
    WebElement autoComplete;

    public WidgetsPage selectAutoComplete() {
        clickWithJS(autoComplete,0,300);
        return new WidgetsPage(driver);
    }

    @FindBy(xpath = "//span[.='Text Box']")
    WebElement textBox;

    public ElementsPage selectTextBox() {
        click(textBox);

        return new ElementsPage(driver);
    }

    @FindBy(xpath = "//span[.='Links']")
    WebElement links;

    public ElementsPage selectLinks() {
        clickWithJS(links,0,300);
        return new ElementsPage(driver);
    }

    @FindBy(xpath = "//span[.='Broken Links - Images']")
    WebElement linksImages;

    public ElementsPage selectBrokenLinksImages() {
        clickWithJS(linksImages,0,300);
        return new ElementsPage(driver);
    }

    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceForm;

    public FormsPage selectPracticeForm() {
        click(practiceForm);

        return new FormsPage(driver);
    }
}
