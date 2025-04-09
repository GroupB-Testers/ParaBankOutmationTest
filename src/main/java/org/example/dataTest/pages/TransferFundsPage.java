

package org.example.dataTest.pages;
import org.example.dataTest.utils.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TransferFundsPage extends Pages {

        @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[3]/a")
        private WebElement TransferFudsButton;

        @FindBy(id = "amount")
        private WebElement Amount;

        @FindBy(id = "fromAccountId")
        private WebElement fromAccountId;

        @FindBy(id = "toAccountId")
        private WebElement toAccountId;

        @FindBy(xpath = "//input[@value=\"Transfer\"]")
        private WebElement TransferButton ;

        @FindBy(linkText = "Log Out")
        private WebElement logoutLink;

        @FindBy(xpath = "//h1[text()=\"Transfer Complete!\"]")
        private WebElement HaapySenario ;


    public TransferFundsPage(WebDriver driver) {
        super(driver);
    }


    public void enterTransferFudsButton() {

            WebActions.click(TransferFudsButton);

        }
        public void enterAmount() {
            WebActions.sendKeysWithClear(Amount,"100");
        }


        public void enterfromAccountId(int i ) {
            WebActions.select(fromAccountId,i);
        }

       public void entertoAccountId(int x) {
        WebActions.select(toAccountId,x);
       }


        public void enterTransferButton() {
            WebActions.click(TransferButton);
        }

    public void verifyHappyScenario() {

        boolean isDisplayed = WebActions.waitForElement(driver, HaapySenario, 10);
        Assert.assertTrue(isDisplayed, "الرسالة 'Congratulations, your account is now open.' لم تظهر كما هو متوقع.");
    }

    public void logout() {
        WebActions.click(logoutLink);
    }







    }




