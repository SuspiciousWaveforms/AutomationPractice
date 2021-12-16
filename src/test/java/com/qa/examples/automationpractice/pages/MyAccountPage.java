package com.qa.examples.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyAccountPage {
    WebDriver webDriver;

    private By orderHistoryAndDetailsSelector = By.xpath("//*[text()='Order history and details']");

    public MyAccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;

        if (!webDriver.getTitle().equals("My account - My Store")) {
            throw new IllegalStateException("Page did not load");
        }
    }

    public Boolean checkOnMyAccountPage() {
        List<WebElement> orderHistoryAndDetailsButtons = webDriver.findElements(orderHistoryAndDetailsSelector);

        return orderHistoryAndDetailsButtons.size() == 1;
    }
}
