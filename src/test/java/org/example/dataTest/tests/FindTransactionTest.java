package org.example.dataTest.tests;

import org.example.dataTest.pages.*;
import org.example.dataTest.utils.ScreenShot;
import org.example.dataTest.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public void testFullUserJourney() throws InterruptedException {
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
        RegisterPage.enterPassword("123");
        RegisterPage.enterRepeatedPassword("123");
        RegisterPage.clickSubmitButton();
        Assert.assertTrue(RegisterPage.isErrorMessageDisplayed(),"لم تظهر رسالة الخطأ عند استخدام بيانات مكررة");


        OpenNewAccount.enterOpenNewacountButton();
        OpenNewAccount.entertypeOfAcount(1);
        OpenNewAccount.enterfromAccountId(0 );
        OpenNewAccount.enterSubmitButton();
        OpenNewAccount.verifyHappyScenario();


        TransferFundsPage.enterTransferFudsButton();
        TransferFundsPage.enterAmount();
        TransferFundsPage.enterfromAccountId(0);
        TransferFundsPage.entertoAccountId(0);
        TransferFundsPage.enterTransferButton();
        TransferFundsPage.verifyHappyScenario();



        FindTransactionPage.enterAccountsOverview();
        FindTransactionPage.enterAccountsOverviewFirstAcount();
        FindTransactionPage.enterFindTransferSentFirst();
        String id =  FindTransactionPage.getTransactionID();
        FindTransactionPage.enterFindTransactionsButton();
        FindTransactionPage.Selectaccount(0);
        FindTransactionPage.entertransactionId(id);


        try {
            FindTransactionPage.enterfindById();
            // تحقق من ظهور رسالة الخطأ المتوقعة في الصفحة
            if ( FindTransactionPage.idwrongmassage()){
                System.out.println("️ ظهرت رسالة الخطأ المتوقعة: An internal error has occurred and has been logged.");
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String path = "src\\main\\java\\org\\example\\dataTest\\screenshots\\internal_error_" + timestamp + ".png";
                try {
                    ScreenShot.takeScreenshot(driver, path);
                } catch (IOException ioException) {
                    System.out.println(" فشل في أخذ السكرين شوت: " + ioException.getMessage());
                }
            } else {
                System.out.println(" لم تظهر رسالة الخطأ المتوقعة.");
            }

        } catch (Exception | AssertionError e) {
            System.out.println("⚠️ حصل استثناء غير متوقع أثناء الضغط على Find by ID: " + e.getMessage());
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String path = "src\\main\\java\\org\\example\\dataTest\\screenshots\\unexpected_exception_" + timestamp + ".png";
            try {
                ScreenShot.takeScreenshot(driver, path);
            } catch (IOException ioException) {
                System.out.println(" فشل في أخذ السكرين شوت: " + ioException.getMessage());
            }
        }



        FindTransactionPage.enterAccountsOverview();
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
        FindTransactionPage.verifyHappyScenario();
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


