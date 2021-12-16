package com.qa.examples.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    WebDriver webDriver;

    @FindBy(id = "email_create")
    private WebElement emailInput;

    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccountButton;

    public SignInPage(WebDriver webDriver) {
        this.webDriver = webDriver;

        if (!webDriver.getTitle().equals("Login - My Store")) {
            throw new IllegalStateException("Page did not load");
        }
    }

    public void inputEmail(String email) {
        emailInput.sendKeys(email);
    }

    public CreateAccountPage clickCreateAnAccount() {
        createAnAccountButton.click();

        return PageFactory.initElements(webDriver, CreateAccountPage.class);
    }
}
