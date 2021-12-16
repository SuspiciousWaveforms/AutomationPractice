package com.qa.examples.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage {
    WebDriver webDriver;

    @FindBy(id = "customer_firstname")
    WebElement customerFirstnameInput;

    @FindBy(id = "customer_lastname")
    WebElement customerLastnameInput;

    @FindBy(id = "passwd")
    WebElement passwordInput;

    public CreateAccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;

        if (!webDriver.getTitle().equals("Login - My Store")) {
            throw new IllegalStateException("Page did not load");
        }
    }

    public void inputCustomerFirstname(String firstname) {
        customerFirstnameInput.sendKeys(firstname);
    }

    public void inputCustomerLastname(String lastname) {
        customerLastnameInput.sendKeys(lastname);
    }

    public void inputPassword(String password) {
        passwordInput.sendKeys(password);
    }
}
