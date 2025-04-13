package org.example.dataTest.pages;
import org.example.dataTest.utils.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ForgotLoginInfoPage extends Pages {

    @FindBy(xpath = "//a[text()=\"Forgot login info?\"]")
    private WebElement ForgotlogininfoButton;

    @FindBy(id = "firstName")
    private WebElement name;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "address.street")
    private WebElement address;

    @FindBy(id = "address.city")
    private WebElement city ;

    @FindBy(id = "address.state")
    private WebElement state ;

    @FindBy(id = "address.zipCode")
    private WebElement zipCode ;

    @FindBy(id = "ssn")
    private WebElement ssn ;

    @FindBy(xpath = "//input[@value=\"Find My Login Info\"]")
    private WebElement findMyLohinInsubmitButtton ;


    @FindBy(xpath = "//h1[text()=\"Customer Lookup\"]")
    private WebElement HaapySenario ;

    @FindBy(xpath = "//p[@class=\"error\"]\n")
    private WebElement errormessage;


    public ForgotLoginInfoPage(WebDriver driver) {
        super(driver);
    }


    public void ForgotlogininfoButton() {
        WebActions.click(ForgotlogininfoButton);
    }

    public void name(String namee) {
        WebActions.sendKeysWithClear(name,namee);
    }

    public void lastName(String lastNamee) {
        WebActions.sendKeysWithClear(lastName,lastNamee);
    }


    public void address(String addresss) {
        WebActions.sendKeysWithClear(address,addresss);
    }

    public void city(String cityy) {
        WebActions.sendKeysWithClear(city,cityy);
    }

    public void state(String statee) {
        WebActions.sendKeysWithClear(state,statee);
    }

    public void zipCode(String zipCodee) {
        WebActions.sendKeysWithClear(zipCode,zipCodee);
    }
    public void ssn(String ssnn) {
        WebActions.sendKeysWithClear(ssn,ssnn);
    }

    public void findMyLohinInsubmitButtton() {
        WebActions.click(findMyLohinInsubmitButtton);
    }

    public void setTransferFudsSucess() {
        Assert.assertTrue(HaapySenario.isDisplayed(), "Transfer Complete!");
    }

    public boolean isErrorMessageDisplayed() {
        boolean isDisplayed = WebActions.waitForElement(driver, errormessage, 10);
        Assert.assertTrue(isDisplayed, "الرسالة 'Congratulations, your account is now open.' لم تظهر كما هو متوقع.");
        return isDisplayed;
    }

}







