package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FormsPage extends BasePage {
    public FormsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement fName;
    @FindBy(id = "lastName")
    WebElement lName;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "userNumber")
    WebElement userNumber;

    public FormsPage enterPersonalData(String firstName, String lastName, String email, String phone) {

        moveWithJS(fName, 0, 300);
        type(fName, firstName);
        type(lName, lastName);
        type(userEmail, email);
        type(userNumber, phone);
        return this;
    }

    @FindBy(css = "[for='gender-radio-1']")
    WebElement male;
    @FindBy(css = "[for='gender-radio-2']")
    WebElement female;
    @FindBy(css = "[for='gender-radio-3']")
    WebElement other;

    public FormsPage selectGender(String gender) {
        if (gender.equals("Male")) {
            click(male);
        } else if (gender.equals("Female")) {
            click(female);
        } else {
            click(other);
        }


        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;

    public FormsPage enterDate(String date) {
        click(dateOfBirthInput);

        String os = System.getProperty("os.name");
        if (os.startsWith("Mac")) {
            dateOfBirthInput.sendKeys(Keys.COMMAND, "a");
        } else {
            dateOfBirthInput.sendKeys(Keys.CONTROL, "a");
        }

        dateOfBirthInput.sendKeys(date);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;

    }

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    public FormsPage selectSubject(String[] subjects) {
        moveWithJS(subjectsInput, 0, 200);
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                type(subjectsInput, subjects[i]);
                subjectsInput.sendKeys(Keys.ENTER);
            }

        }

        return this;
    }

    @FindBy(css = "[for='hobbies-checkbox-1']")
    WebElement sports;
    @FindBy(css = "[for='hobbies-checkbox-2']")
    WebElement reading;
    @FindBy(css = "[for='hobbies-checkbox-3']")
    WebElement music;

    public FormsPage selectHobbies(String[] hobbies) {

        for (int i = 0; i < hobbies.length; i++) {
            if (hobbies[i].equals("Sports")) {
                click(sports);
            }
            if (hobbies[i].equals("Reading")) {
                click(reading);
            }
            if (hobbies[i].equals("Music")) {
                click(music);
            }
        }
        return this;
    }

    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;

    public FormsPage uploadFile(String path) {
        uploadPicture.sendKeys(path);


        return this;
    }

    @FindBy(id = "state")
    WebElement stateContainer;

    @FindBy(id = "react-select-3-input")
    WebElement stateInput;

    public FormsPage selectState(String state) {
        clickWithJS(stateContainer,0,200);
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "city")
    WebElement cityContainer;
    @FindBy(id = "react-select-4-input")
    WebElement cityInput;

    public FormsPage selectCity(String city) {
        click(cityContainer);
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);

        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;

    public FormsPage submit() {
        click(submit);

        return this;
    }

    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement modelTitle;

    public FormsPage verifySuccessRegistration(String title) {
        Assert.assertTrue(shouldHaveText(modelTitle,title,5));

        return this;
    }

    @FindBy(css = ".react-datepicker__month-select")
    WebElement monthContainer;
    @FindBy(css = ".react-datepicker__year-select")
    WebElement yearContainer;

    public FormsPage selectDate(String month, String year, String day) {
        click(dateOfBirthInput);
        new Select(monthContainer).selectByVisibleText(month);
        new Select(yearContainer).selectByVisibleText(year);

        driver.findElement(By.xpath("//div[@class='react-datepicker__week']//div[.='"+ day + "']")).click();



        return this;
    }
}
