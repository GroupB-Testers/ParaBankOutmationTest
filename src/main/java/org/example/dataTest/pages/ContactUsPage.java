
package org.example.dataTest.pages;
import org.example.dataTest.utils.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContactUsPage extends Pages {

    @FindBy(xpath = "//a[text()='contact']")
    private WebElement contectUusButton;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "message")
    private WebElement message ;

    @FindBy(xpath = "//input[@value=\"Send to Customer Care\"]")
    private WebElement SendtoCustomerCare  ;


    @FindBy(xpath = "//h1[text()='Customer Care']")
    private WebElement HaapySenario ;


    public ContactUsPage(WebDriver driver) {
        super(driver);
    }


    public void contectUusButton() {

        WebActions.click(contectUusButton);

    }

    public void name(String namee) {
        WebActions.sendKeysWithClear(name,namee);
    }

    public void email(String emaill) {
        WebActions.sendKeysWithClear(email,emaill);
    }


    public void phone(String phonee) {
        WebActions.sendKeysWithClear(phone,phonee);
    }

    public void message(String messagee) {
        WebActions.sendKeysWithClear(message,messagee);
    }

    public void SendtoCustomerCare() {
        WebActions.click(SendtoCustomerCare);
    }


    public void setTransferFudsSucess() {
        Assert.assertTrue(HaapySenario.isDisplayed(), "Transfer Complete!");
    }


}






