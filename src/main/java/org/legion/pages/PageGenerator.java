package org.legion.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageGenerator {
    public WebDriver driver;

    public PageGenerator(WebDriver driver){
        this.driver = driver;
    }

    public <Page extends BasePage> Page getPage(Class <Page> pageClass){
        return PageFactory.initElements(driver, pageClass);
    }

}
