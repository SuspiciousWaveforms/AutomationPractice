package com.qa.examples.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {
    WebDriver webDriver;

    @FindBy(id = "customer_firstname")
    WebElement customerFirstnameInput;

    @FindBy(id = "customer_lastname")
    WebElement customerLastnameInput;

    @FindBy(id = "passwd")
    WebElement passwordInput;

    @FindBy(id = "firstname")
    WebElement addressFirstNameInput;

    @FindBy(id = "lastname")
    WebElement addressLastNameInput;

    @FindBy(id = "address1")
    WebElement addressInput;

    @FindBy(id = "city")
    WebElement addressCityInput;

    @FindBy(id = "id_state")
    WebElement addressStateInput;

    @FindBy(id = "postcode")
    WebElement addressPostcode;

    @FindBy(id = "phone_mobile")
    WebElement addressMobileInput;

    @FindBy(name = "submitAccount")
    WebElement registerButton;

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

    public void inputAddressFirstname(String firstname) {
        addressFirstNameInput.sendKeys(firstname);
    }

    public void inputAddressLastname(String lastname) {
        addressLastNameInput.sendKeys(lastname);
    }

    public void inputAddress(String address) {
        addressInput.sendKeys(address);
    }

    public void inputAddressCity(String city) {
        addressCityInput.sendKeys(city);
    }

    public void inputState(String stateName) {
        Select stateSelect = new Select(addressStateInput);
        stateSelect.selectByVisibleText(stateName);
    }

    public void inputPostcode(String postcode) {
        addressPostcode.sendKeys(postcode);
    }

    public void inputMobile(String mobileNumber) {
        addressMobileInput.sendKeys(mobileNumber);
    }

    public MyAccountPage clickRegister() {
       registerButton.click();

       return PageFactory.initElements(webDriver, MyAccountPage.class);
    }
}
