package com.qa.examples.automationpractice.stepdefs;

import com.qa.examples.automationpractice.pages.HomePage;
import com.qa.examples.automationpractice.pages.PageRepository;
import com.qa.examples.automationpractice.pages.SignInPage;
import com.qa.examples.automationpractice.utils.WebDriverHooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Random;

public class CreateAccountStepDefinitions {
    WebDriver webDriver;
    PageRepository pageRepository;

    // Separate file?
    Random random = new Random();
    String email = "testitnowsdflkjsal@fmail.com";
    String firstname = "Jackson";
    String lastname = "James";
    String password = "hunter2";
    String address = "32 Canon Close";
    String city = "London";
    String state = "Arkansas";
    String postcode = "00000";
    String mobileNumber = "091242239232";

    public CreateAccountStepDefinitions(WebDriverHooks hooks) {
        this.webDriver = hooks.getWebDriver();
        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

        pageRepository = new PageRepository();
        pageRepository.homePage = PageFactory.initElements(webDriver, HomePage.class);
    }

    @Given("the user is on the 'Sign in' page")
    public void the_user_is_on_the_page() {
        pageRepository.signInPage = pageRepository.homePage.clickSignIn();
    }
    @When("the user creates an account")
    public void the_user_creates_an_account() {
        pageRepository.signInPage.inputEmail(email);
        pageRepository.createAccountPage = pageRepository.signInPage.clickCreateAnAccount();
        pageRepository.createAccountPage.inputCustomerFirstname(firstname);
        pageRepository.createAccountPage.inputCustomerLastname(lastname);
        pageRepository.createAccountPage.inputPassword(password);
        pageRepository.createAccountPage.inputAddressFirstname(firstname);
        pageRepository.createAccountPage.inputAddressLastname(lastname);
        pageRepository.createAccountPage.inputAddress(address);
        pageRepository.createAccountPage.inputAddressCity(city);
        pageRepository.createAccountPage.inputState(state);
        pageRepository.createAccountPage.inputPostcode(postcode);
        pageRepository.createAccountPage.inputMobile(mobileNumber);
        pageRepository.myAccountPage = pageRepository.createAccountPage.clickRegister();
    }
    @Then("the user should be on the 'My account' page")
    public void the_user_should_be_on_the_page() {
        assert(pageRepository.myAccountPage.checkOnMyAccountPage());
    }
}
