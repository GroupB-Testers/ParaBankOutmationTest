package org.example.dataTest.pages;

import org.example.dataTest.utils.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends Pages {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@id='loginPanel']//input[@type='submit']")
    private WebElement loginButton;

    @FindBy(linkText = "Log Out")
    private WebElement logoutLink;

    @FindBy(xpath = "//p[text()='The username and password could not be verified.']")
    private WebElement errorMessage;



    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        WebActions.sendKeysWithClear(usernameField, username);
    }

    public void enterPassword(String password) {
        WebActions.sendKeysWithClear(passwordField, password);
    }

    public void clickLoginButton() {
        WebActions.click(loginButton);
    }

    public boolean isLogoutButtonDisplayed() {
        return WebActions.waitForElement(driver,logoutLink, 5);
    }

    public boolean isErrorMessageDisplayed() {
            boolean isDisplayed = WebActions.waitForElement(driver, errorMessage, 10);
            Assert.assertTrue(isDisplayed, "الرسالة 'Congratulations, your account is now open.' لم تظهر كما هو متوقع.");
            return isDisplayed;
    }

    public void logout() {
        WebActions.click(logoutLink);
    }
}
