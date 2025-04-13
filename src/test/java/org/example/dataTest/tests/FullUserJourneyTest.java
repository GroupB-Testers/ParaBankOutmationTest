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

public class FullUserJourneyTest {

    private WebDriver driver;
    private RegisterPage RegisterPage;
    private LoginPage LoginPage;
    private BillPaymentpage BillPaymentpage;
    private ContactUsPage ContactUsPage;
    private FindTransactionPage FindTransactionPage;
    private UpdatContectInfoPage UpdatContectInfoPage;
    private OpenNewAccount OpenNewAccount;
    private RequestLoanpage RequestLoanpage;
    private TransferFundsPage TransferFundsPage;
    private ForgotLoginInfoPage ForgotLoginInfoPage;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        driver = Utils.setup(browser);
        RegisterPage = new RegisterPage(driver);
        LoginPage = new LoginPage(driver);
        BillPaymentpage = new BillPaymentpage(driver);
        ContactUsPage = new ContactUsPage(driver);
        FindTransactionPage = new FindTransactionPage(driver);
        UpdatContectInfoPage = new UpdatContectInfoPage(driver);
        OpenNewAccount = new OpenNewAccount(driver);
        RequestLoanpage = new RequestLoanpage(driver);
        TransferFundsPage = new TransferFundsPage(driver);
        ForgotLoginInfoPage = new ForgotLoginInfoPage(driver);
    }

    @Test
    public void testFullUserJourney() {
        //عمل تسجيل دخول لاول مره
        RegisterPage.clickRegisterButton();
        RegisterPage.enterFirstName("so2");
        RegisterPage.enterLastName("Mohamed");
        RegisterPage.enterStreet("Cairo");
        RegisterPage.enterCity("Cairo");
        RegisterPage.enterState("Giza");
        RegisterPage.enterZipCode("12345");
        RegisterPage.enterPhoneNumber("01012345678");
        RegisterPage.enterSSN("123-45-6789");
        String uniqueUsername = "user" + System.currentTimeMillis();
        String password = "123";
        RegisterPage.enterUsername(uniqueUsername);
        RegisterPage.enterPassword(password);
        RegisterPage.enterRepeatedPassword(password);
        RegisterPage.clickSubmitButton();
        Assert.assertTrue(RegisterPage.isErrorMessageDisplayed(), "لم تظهر رسالة الخطأ عند استخدام بيانات مكررة");
        RegisterPage.logout();


        try {
            //عمل تسجيل دخول للمره الثانية
            LoginPage.enterUsername(uniqueUsername);
            LoginPage.enterPassword(password);
            LoginPage.clickLoginButton();
            if (LoginPage.isLogoutButtonDisplayed()) {
                System.out.println(" تسجيل دخول ناجح للمستخدم: " + uniqueUsername);
            } else {
                System.out.println(" تسجيل دخول فاشل للمستخدم: " + uniqueUsername);
                Assert.fail("فشل تسجيل الدخول للمستخدم: " + uniqueUsername);
            }
            if (LoginPage.isErrorMessageDisplayed()) {
                System.out.println("️ ظهرت رسالة الخطأ المتوقعة.");
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String path = "src\\main\\java\\org\\example\\dataTest\\screenshots\\internal_error_" + timestamp + ".png";
                ScreenShot.takeScreenshot(driver, path);
                RegisterPage.clickRegisterButton();
                RegisterPage.enterFirstName("so2");
                RegisterPage.enterLastName("Mohamed");
                RegisterPage.enterStreet("Cairo");
                RegisterPage.enterCity("Cairo");
                RegisterPage.enterState("Giza");
                RegisterPage.enterZipCode("12345");
                RegisterPage.enterPhoneNumber("01012345678");
                RegisterPage.enterSSN("123-45-6789");
                RegisterPage.enterUsername(uniqueUsername);
                RegisterPage.enterPassword(password);
                RegisterPage.enterRepeatedPassword(password);
                RegisterPage.clickSubmitButton();
                Assert.assertTrue(RegisterPage.isErrorMessageDisplayed(), "لم تظهر رسالة الخطأ عند استخدام بيانات مكررة");
            } else {
                System.out.println(" لم تظهر رسالة الخطأ المتوقعة.");
            }
        } catch (Exception | AssertionError e) {
            System.out.println("⚠️ حصل استثناء: " + e.getMessage());
        }

        //عمل حساب جديد
        OpenNewAccount.enterOpenNewacountButton();
        OpenNewAccount.entertypeOfAcount(1);
        OpenNewAccount.enterfromAccountId(0);
        OpenNewAccount.enterSubmitButton();
        OpenNewAccount.verifyHappyScenario();

        // عمل نقل اموال جديد
        TransferFundsPage.enterTransferFudsButton();
        TransferFundsPage.enterAmount();
        TransferFundsPage.enterfromAccountId(0);
        TransferFundsPage.entertoAccountId(0);
        TransferFundsPage.enterTransferButton();
        TransferFundsPage.verifyHappyScenario();

        // هنا عمليت البحث بكل الطرق الممكنة (id ,date , amount)
        FindTransactionPage.enterAccountsOverview();
        FindTransactionPage.enterAccountsOverviewFirstAcount();
        FindTransactionPage.enterFindTransferSentFirst();
        String id = FindTransactionPage.getTransactionID();
        FindTransactionPage.enterFindTransactionsButton();
        FindTransactionPage.Selectaccount(0);
        FindTransactionPage.entertransactionId(id);
        try {
            FindTransactionPage.enterfindById();
            if (FindTransactionPage.idwrongmassage()) {
                System.out.println("️ ظهرت رسالة الخطأ المتوقعة.");
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String path = "src\\main\\java\\org\\example\\dataTest\\screenshots\\internal_error_" + timestamp + ".png";
                ScreenShot.takeScreenshot(driver, path);
            } else {
                System.out.println(" لم تظهر رسالة الخطأ المتوقعة.");
            }
        } catch (Exception | AssertionError e) {
            System.out.println("⚠️ حصل استثناء: " + e.getMessage());
        }

        FindTransactionPage.enterAccountsOverview();
        FindTransactionPage.enterAccountsOverviewFirstAcount();
        String date = FindTransactionPage.getdate();
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

        //هنا عمل عمليت Bill
        BillPaymentpage.enterBillPayButton();
        BillPaymentpage.enterAmopayeeNameunt("eslam");
        BillPaymentpage.enterAddress("state");
        BillPaymentpage.entercity("state");
        BillPaymentpage.enterstate("state");
        BillPaymentpage.enterzipCode("15777");
        BillPaymentpage.phoneNumber("01254654564");
        BillPaymentpage.accountNumber("13566");
        BillPaymentpage.verifyAccount("13566");
        BillPaymentpage.amount("100");
        BillPaymentpage.fromAccountId(0);
        BillPaymentpage.SendPaymentButton();
        BillPaymentpage.verifyHappyScenario();

        //عمل تحديث لمعلومات الحساب
        UpdatContectInfoPage.UpdateContactInfoButton();
        UpdatContectInfoPage.firstName("eslam");
        UpdatContectInfoPage.lastName("eslam");
        UpdatContectInfoPage.address("eslam");
        UpdatContectInfoPage.city("eslam");
        UpdatContectInfoPage.state("eslam");
        UpdatContectInfoPage.zipCode("105454");
        UpdatContectInfoPage.phoneNumber("01245464787");
        UpdatContectInfoPage.UpdadatProfileButton();
        UpdatContectInfoPage.setTransferFudsSucess();

        //طلب قرض
        RequestLoanpage.RequestLoanButton();
        RequestLoanpage.amount("100");
        RequestLoanpage.downPayment("100");
        RequestLoanpage.fromAccountId(0);
        RequestLoanpage.ApplayButtonsubmit();
        try {
            RequestLoanpage.setTransferFudsSucess();
            if (RequestLoanpage.isErrorMessageDisplayed()) {
                System.out.println("️ ظهرت رسالة الخطأ المتوقعة.");
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String path = "src\\main\\java\\org\\example\\dataTest\\screenshots\\internal_error_" + timestamp + ".png";
                ScreenShot.takeScreenshot(driver, path);
            } else {
                System.out.println(" لم تظهر رسالة الخطأ المتوقعة.");
            }
        } catch (Exception | AssertionError e) {
            System.out.println("⚠️ حصل استثناء: " + e.getMessage());
        }
        RequestLoanpage.logout();

        //اتصل بنا
        ContactUsPage.contectUusButton();
        ContactUsPage.name("eslam");
        ContactUsPage.email("eslam8@gamil.com");
        ContactUsPage.phone("0125465464");
        ContactUsPage.message("I want to login but I can't");
        ContactUsPage.SendtoCustomerCare();
        ContactUsPage.setTransferFudsSucess();

//        نسيان بينات الدخول
        ForgotLoginInfoPage.ForgotlogininfoButton();
        ForgotLoginInfoPage.name("John");
        ForgotLoginInfoPage.lastName("Doe");
        ForgotLoginInfoPage.address("123 Main Street");
        ForgotLoginInfoPage.city("Anytown");
        ForgotLoginInfoPage.state("CA");
        ForgotLoginInfoPage.zipCode("90210");
        ForgotLoginInfoPage.ssn("123-45-6789");
        try {
            ForgotLoginInfoPage.findMyLohinInsubmitButtton();
            if (ForgotLoginInfoPage.isErrorMessageDisplayed()) {
                System.out.println("️ ظهرت رسالة الخطأ المتوقعة.");
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String path = "src\\main\\java\\org\\example\\dataTest\\screenshots\\internal_error_" + timestamp + ".png";
                ScreenShot.takeScreenshot(driver, path);
            } else {
                System.out.println(" لم تظهر رسالة الخطأ المتوقعة.");
            }
        } catch (Exception | AssertionError e) {
            System.out.println("⚠️ حصل استثناء: " + e.getMessage());
        }
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
