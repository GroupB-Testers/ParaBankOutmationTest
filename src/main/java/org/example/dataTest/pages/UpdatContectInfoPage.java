

package org.example.dataTest.pages;
import org.example.dataTest.utils.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class UpdatContectInfoPage extends Pages {

    @FindBy(xpath = "//a[text()=\"Update Contact Info\"]")
    private WebElement UpdateContactInfoButton;

    @FindBy(id = "customer.firstName")
    private WebElement firstName;

    @FindBy(id = "customer.lastName")
    private WebElement lastName;

    @FindBy(id = "customer.address.street")
    private WebElement address;

    @FindBy(id = "customer.address.city")
    private WebElement city ;

    @FindBy(id = "customer.address.state")
    private WebElement state ;

    @FindBy(id = "customer.address.zipCode")
    private WebElement zipCode ;

    @FindBy(id = "customer.phoneNumber")
    private WebElement phoneNumber ;

    @FindBy(xpath = "//input[@type=\"button\"]")
    private WebElement UpdadatProfileButton ;

    @FindBy(linkText = "Log Out")
    private WebElement logoutLink;

    @FindBy(xpath = "//h1[@class=\"title\"]")
    private WebElement HaapySenario ;


    public UpdatContectInfoPage(WebDriver driver) {
        super(driver);
    }


    public void UpdateContactInfoButton() {

        WebActions.click(UpdateContactInfoButton);

    }
    public void firstName(String fname) {
        WebActions.sendKeysWithClear(firstName,fname);
    }
    public void lastName(String lname) {
        WebActions.sendKeysWithClear(lastName,lname);
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

    public void phoneNumber(String phoneNumberr) {
        WebActions.sendKeysWithClear(phoneNumber,phoneNumberr);
    }

    public void UpdadatProfileButton() {
        WebActions.click(UpdadatProfileButton);
    }

    public void setTransferFudsSucess() {
        Assert.assertTrue(HaapySenario.isDisplayed(), "Transfer Complete!");

    }

    public void logout() {
        WebActions.click(logoutLink);
    }


}





