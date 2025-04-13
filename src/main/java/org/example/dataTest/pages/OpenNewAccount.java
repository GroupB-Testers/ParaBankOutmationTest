package org.example.dataTest.pages;

import org.example.dataTest.utils.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class OpenNewAccount extends Pages {

        @FindBy(xpath = "//a[text()=\"Open New Account\"]")
        private WebElement OpenNewacountButton;

        @FindBy(id = "type")
        private WebElement typeOfAcount;

        @FindBy(id = "fromAccountId")
        private WebElement fromAccountId;

        @FindBy(linkText = "Log Out")
        private WebElement logoutLink;

        @FindBy(xpath = "//input[@value=\"Open New Account\"]")
        private WebElement SubmitButton;

        @FindBy(xpath = "//h1[text()='Account Opened!']")
        private WebElement HaapySenario ;


        public OpenNewAccount(WebDriver driver) {

            super(driver);
        }


        public void enterOpenNewacountButton() {

            WebActions.click(OpenNewacountButton);

        }


        public void entertypeOfAcount(int i) {
            boolean isDisplayed = WebActions.waitForElement(driver, typeOfAcount, 10);
            WebActions.select(typeOfAcount,i);
           }


       public void enterfromAccountId(int x) {
           WebActions.waitForElement(driver, fromAccountId, 10);
            WebActions.click(fromAccountId);
        WebActions.waitForOptionsToBePresent(driver, fromAccountId, 10); // الجديد هنا
        WebActions.select(fromAccountId, x);
        }



        public void enterSubmitButton() {
            WebActions.click(SubmitButton);
          }

    public void verifyHappyScenario() {

            boolean isDisplayed = WebActions.waitForElement(driver, HaapySenario, 10);
            Assert.assertTrue(isDisplayed, "الرسالة 'Congratulations, your account is now open.' لم تظهر كما هو متوقع.");
    }

        public void logout() {

            WebActions.click(logoutLink);
        }

    }



