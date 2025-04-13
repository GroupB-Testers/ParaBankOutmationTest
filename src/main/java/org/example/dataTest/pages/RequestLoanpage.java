package org.example.dataTest.pages;

import org.example.dataTest.utils.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RequestLoanpage extends Pages {
    @FindBy(xpath = "//a[text()=\"Request Loan\"]")
    private WebElement RequestLoanpageButton ;

    @FindBy(id = "amount")
    private WebElement amount;

    @FindBy(id = "downPayment")
    private WebElement downPayment;

    @FindBy(id = "fromAccountId")
    private WebElement fromAccountId;

    @FindBy(xpath = "//input[@value=\"Apply Now\"]")
    private WebElement ApplayButtonsubmit;

    @FindBy(linkText = "Log Out")
    private WebElement logoutLink;

    @FindBy(xpath= "//h1[text()=\"Loan Request Processed\"]")
    private WebElement HaapySenario ;

    @FindBy(xpath= "//div[@id=\"requestLoanError\"]/p[@class='error']\n")
    private WebElement errorMessage ;

    public RequestLoanpage(WebDriver driver) {
        super(driver);
    }

    public void RequestLoanButton() {
        WebActions.click(RequestLoanpageButton);
    }

    public void amount(String amountt) {
        WebActions.sendKeysWithClear(amount,amountt);
    }

    public void downPayment(String downPaymentt) {
        WebActions.sendKeysWithClear(downPayment,downPaymentt);
    }

    public void fromAccountId(int downPaymenttfromAccountIdd) {
        WebActions.select(fromAccountId,downPaymenttfromAccountIdd);
    }

    public void ApplayButtonsubmit() {
        WebActions.click(ApplayButtonsubmit);
    }

    public void setTransferFudsSucess() {
        WebActions.waitForElement(driver,HaapySenario,10);
        Assert.assertTrue(HaapySenario.isDisplayed(), "Transfer Complete!");
    }

    public void logout() {
        WebActions.click(logoutLink);
    }

    public boolean isErrorMessageDisplayed() {
        boolean isDisplayed = WebActions.waitForElement(driver, errorMessage, 10);
        Assert.assertTrue(isDisplayed, "الرسالة 'Congratulations, your account is now open.' لم تظهر كما هو متوقع.");
        return isDisplayed;
    }

}





