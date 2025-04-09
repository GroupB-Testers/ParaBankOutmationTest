package org.example.dataTest.pages;

import org.example.dataTest.utils.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BillPaymentpage extends Pages {

    @FindBy(linkText = "Bill Pay")
    private WebElement BillPayButton;

    @FindBy(name = "payee.name")
    private WebElement AmopayeeNameunt;

    @FindBy(name = "payee.address.street")
    private WebElement Address;

    @FindBy(name = "payee.address.city")
    private WebElement city;

    @FindBy(name = "payee.address.state")
    private WebElement state;

    @FindBy(name = "payee.address.zipCode")
    private WebElement zipCode;

    @FindBy(name = "payee.phoneNumber")
    private WebElement phoneNumber;

    @FindBy(name = "payee.accountNumber")
    private WebElement accountNumber;

    @FindBy(name = "verifyAccount")
    private WebElement verifyAccount;

    @FindBy(name = "amount")
    private WebElement amount;

    @FindBy(name = "fromAccountId")
    private WebElement fromAccountId;

    @FindBy(xpath = "//input[@value=\"Send Payment\"]")
    private WebElement SendPaymentButton;

    @FindBy(linkText = "Log Out")
    private WebElement logoutLink;

    @FindBy(linkText = "Bill Payment Complete!")
    private WebElement HaapySenario ;


    public BillPaymentpage(WebDriver driver) {
        super(driver);
    }


    public void enterBillPayButton() {
        WebActions.click(BillPayButton);
    }

    public void enterAmopayeeNameunt(String Payee ) {
        WebActions.sendKeysWithClear(AmopayeeNameunt,Payee);
    }


    public void enterAddress(String Addresss ) {
        WebActions.sendKeysWithClear(Address,Addresss);
    }



    public void entercity(String cityy ) {
        WebActions.sendKeysWithClear(city,cityy);
    }


    public void enterstate(String statee ) {
        WebActions.sendKeysWithClear(state,statee);
    }

    public void enterzipCode(String statee ) {
        WebActions.sendKeysWithClear(zipCode,statee);
    }

    public void phoneNumber(String phoneNumberr ) {
        WebActions.sendKeysWithClear(phoneNumber,phoneNumberr);
    }

    public void accountNumber(String accountNumberr ) {
        WebActions.sendKeysWithClear(accountNumber,accountNumberr);
    }

    public void verifyAccount(String verifyAccountt ) {
        WebActions.sendKeysWithClear(verifyAccount,verifyAccountt);
    }

    public void amount(String amountt ) {
        WebActions.sendKeysWithClear(amount,amountt);
    }

    public void fromAccountId(int fromAccountIdd ) {
        WebActions.select(fromAccountId,fromAccountIdd);
    }

    public void SendPaymentButton( ) {
        WebActions.click(SendPaymentButton);
    }

    public void logout() {
        WebActions.click(logoutLink);
    }


    public void setTransferFudsSucess() {
        Assert.assertTrue(HaapySenario.isDisplayed(), "Bill Payment Complete");
    }
}
