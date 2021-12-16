package com.qa.examples.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver webDriver;

    @FindBy(className = "login")
    private WebElement signInLink;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;

        webDriver.get("http://automationpractice.com/index.php");

        if (!webDriver.getTitle().equals("My Store")) {
            throw new IllegalStateException("Page did not load");
        }
    }

    public SignInPage clickSignIn() {
        signInLink.click();

        return PageFactory.initElements(webDriver, SignInPage.class);
    }
}
