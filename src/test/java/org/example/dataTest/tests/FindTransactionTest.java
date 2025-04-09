package org.example.dataTest.tests;

import org.example.dataTest.pages.*;
import org.example.dataTest.utils.ScreenShot;
import org.example.dataTest.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FindTransactionTest {

    private WebDriver driver;
    private RegisterPage RegisterPage;
    private LoginPage LoginPage;
    private TransferFundsPage TransferFundsPage;
    private FindTransactionPage FindTransactionPage ;
    private OpenNewAccount OpenNewAccount;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        driver = Utils.setup(browser);
        RegisterPage = new RegisterPage(driver);
        LoginPage = new LoginPage(driver);
        TransferFundsPage = new TransferFundsPage(driver);
        FindTransactionPage = new FindTransactionPage(driver);
        OpenNewAccount = new OpenNewAccount(driver);
    }

    @Test
    public void testFullUserJourney() {
        RegisterPage.clickRegisterButton();
        RegisterPage.enterFirstName("so2");
        RegisterPage.enterLastName("Mohamed");
        RegisterPage.enterStreet("123 Street");
        RegisterPage.enterCity("Cairo");
        RegisterPage.enterState("Giza");
        RegisterPage.enterZipCode("12345");
        RegisterPage.enterPhoneNumber("01012345678");
        RegisterPage.enterSSN("123-45-6789");
        String uniqueUsername = "user" + System.currentTimeMillis();
        RegisterPage.enterUsername(uniqueUsername);
        String password = "123";
        RegisterPage.enterPassword(password);
        RegisterPage.enterRepeatedPassword("123");
        RegisterPage.clickSubmitButton();
        Assert.assertTrue(LoginPage.isLogoutButtonDisplayed(), "فشل في التسجيل");



        OpenNewAccount.enterOpenNewacountButton();
        OpenNewAccount.entertypeOfAcount(1);
        OpenNewAccount.enterfromAccountId(1);
        OpenNewAccount.enterSubmitButton();

        TransferFundsPage.enterTransferFudsButton();
        TransferFundsPage.enterAmount();
        TransferFundsPage.enterfromAccountId(0);
        TransferFundsPage.entertoAccountId(0);
        TransferFundsPage.enterTransferButton();



        FindTransactionPage.enterAccountsOverview();
        FindTransactionPage.enterAccountsOverviewFirstAcount();
        FindTransactionPage.enterFindTransferSentFirst();
        String id =  FindTransactionPage.getTransactionID();
        FindTransactionPage.enterFindTransactionsButton();
        FindTransactionPage.Selectaccount(0);
        FindTransactionPage.entertransactionId(id);
        FindTransactionPage.enterfindById();
        FindTransactionPage.enterAccountsOverview();
        FindTransactionPage.enterFindTransactionsButton();
        FindTransactionPage.enterAccountsOverviewFirstAcount();
        String date =FindTransactionPage.getdate();
        FindTransactionPage.enterFindTransactionsButton();
        FindTransactionPage.entertransactionDate(date);
        FindTransactionPage.findByDateButton();
        FindTransactionPage.enterFindTransactionsButton();
        FindTransactionPage.enterBetween(date);
        FindTransactionPage.enterand(date);
        FindTransactionPage.enterfindByDateRangeDat();
        FindTransactionPage.enterFindTransactionsButton();
        FindTransactionPage.enteramount("100");
        FindTransactionPage.enterfindByAmountButton();
        FindTransactionPage.setTransferFudsSucess();
        FindTransactionPage.logout();




    }

    @AfterMethod
    public void captureScreenshotOnFailure(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String path = "src\\main\\java\\org\\example\\dataTest\\screenshots\\screenshot_" + timestamp + ".png";
            ScreenShot.takeScreenshot(driver, path);
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}


