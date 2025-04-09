package org.example.dataTest.pages;

import org.example.dataTest.utils.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RequestLoanpage extends Pages {

    @FindBy(linkText = "amount")
    private WebElement amount;

    @FindBy(id = "downPayment")
    private WebElement downPayment;

    @FindBy(id = "fromAccountId")
    private WebElement fromAccountId;

    @FindBy(id = "//input[@value=\"Apply Now\"]")
    private WebElement ApplayButtonsubmit;

    @FindBy(linkText = "Log Out")
    private WebElement logoutLink;

    @FindBy(linkText= "Loan Request Processed")
    private WebElement HaapySenario ;


    public RequestLoanpage(WebDriver driver) {
        super(driver);
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
        Assert.assertTrue(HaapySenario.isDisplayed(), "Transfer Complete!");

    }

    public void logout() {
        WebActions.click(logoutLink);
    }


}





