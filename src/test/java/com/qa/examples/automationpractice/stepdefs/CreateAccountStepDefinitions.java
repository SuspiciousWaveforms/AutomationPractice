package com.qa.examples.automationpractice.stepdefs;

import com.qa.examples.automationpractice.pages.HomePage;
import com.qa.examples.automationpractice.pages.PageRepository;
import com.qa.examples.automationpractice.pages.SignInPage;
import com.qa.examples.automationpractice.utils.WebDriverHooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CreateAccountStepDefinitions {
    WebDriver webDriver;
    PageRepository pageRepository;

    // Separate file?
    String email = "testitnow@fmail.com";
    String firstname = "Jackson";
    String lastname = "James";
    String password = "hunter2";

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
    }
    @Then("the user should be on the 'My account' page")
    public void the_user_should_be_on_the_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
