package org.legion.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoursesPage extends BasePage {
    //*********************************Constructor***********************************************
    public CoursesPage(WebDriver driver) {
        super(driver);
    }

    //*********************************Web Elements***********************************************
    @FindBy(xpath = "//*[contains(text(), 'Courses')]")
    public WebElement coursesTitle;
    @FindBy(xpath = "//*[@placeholder='Search']")
    public WebElement searchBox;
    @FindBy(className = "course-card__body")
    public WebElement courseCard;

    //*********************************Page Methods***********************************************

    public CoursesPage verifyCoursesPageIsLoaded() {
        assertTrue(coursesTitle.isDisplayed());
        return this;
    }
    public CoursesPage andISearchForTheCourse(String name) {
        searchBox.sendKeys(name);
        searchBox.submit();
        return this;
    }

    public CoursesPage verifyCourseFound() {
        assertTrue(courseCard.isDisplayed());
        return this;
    }

}
