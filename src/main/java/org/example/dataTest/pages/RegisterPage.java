package org.example.dataTest.pages;

import org.example.dataTest.utils.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends Pages {

    @FindBy(linkText = "Register")
    private WebElement registerButton;

    @FindBy(name = "customer.firstName")
    private WebElement firstName;

    @FindBy(name = "customer.lastName")
    private WebElement lastName;

    @FindBy(name = "customer.address.street")
    private WebElement street;

    @FindBy(name = "customer.address.city")
    private WebElement city;

    @FindBy(name = "customer.address.state")
    private WebElement state;

    @FindBy(name = "customer.address.zipCode")
    private WebElement zipCode;

    @FindBy(name = "customer.phoneNumber")
    private WebElement phoneNumber;

    @FindBy(name = "customer.ssn")
    private WebElement ssn;

    @FindBy(name = "customer.username")
    private WebElement username;

    @FindBy(name = "customer.password")
    private WebElement password;

    @FindBy(name = "repeatedPassword")
    private WebElement repeatedPassword;

    @FindBy(xpath = "//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")
    private WebElement registerSubmit;

    @FindBy(linkText = "Log Out")
    private WebElement logoutLink;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/p")
    private WebElement errorMessage;


    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void clickRegisterButton() {
        WebActions.click(registerButton);
    }

    public void enterFirstName(String fName) {
        WebActions.sendKeysWithClear(firstName, fName);
    }

    public void enterLastName(String lName) {
        WebActions.sendKeysWithClear(lastName, lName);
    }

    public void enterStreet(String str) {
        WebActions.sendKeysWithClear(street, str);
    }

    public void enterCity(String cty) {
        WebActions.sendKeysWithClear(city, cty);
    }

    public void enterState(String st) {
        WebActions.sendKeysWithClear(state, st);
    }

    public void enterZipCode(String zip) {
        WebActions.sendKeysWithClear(zipCode, zip);
    }

    public void enterPhoneNumber(String phone) {
        WebActions.sendKeysWithClear(phoneNumber, phone);
    }

    public void enterSSN(String ssnNumber) {
        WebActions.sendKeysWithClear(ssn, ssnNumber);
    }

    public void enterUsername(String user) {
        WebActions.sendKeysWithClear(username, user);
    }

    public void enterPassword(String pass) {
        WebActions.sendKeysWithClear(password, pass);
    }

    public void enterRepeatedPassword(String repPass) {
        WebActions.sendKeysWithClear(repeatedPassword, repPass);
    }

    public void clickSubmitButton() {
        WebActions.click(registerSubmit);
    }

    public boolean isErrorMessageDisplayed() {
        return WebActions.waitForElement(driver, errorMessage, 5);
    }

    public void logout() {
        WebActions.click(logoutLink);
    }
}
