package org.example.dataTest.tests;

import org.example.dataTest.pages.LoginPage;
import org.example.dataTest.pages.OpenNewAccount;
import org.example.dataTest.pages.RegisterPage;
import org.example.dataTest.utils.ScreenShot;
import org.example.dataTest.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OpenNewAccountTest {
    private WebDriver driver;
    private RegisterPage RegisterPage;
    private LoginPage LoginPage;
    private OpenNewAccount OpenNewAccount;



    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        driver = Utils.setup(browser);
        RegisterPage = new RegisterPage(driver);
        OpenNewAccount = new OpenNewAccount(driver);
        LoginPage =new LoginPage(driver);
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
        String password = "123";
        RegisterPage.enterPassword(password);
        RegisterPage.enterRepeatedPassword("123");
        RegisterPage.clickSubmitButton();
        Assert.assertTrue(LoginPage.isLogoutButtonDisplayed(), "فشل في التسجيل");

        OpenNewAccount.enterOpenNewacountButton();
        OpenNewAccount.entertypeOfAcount(0);
        OpenNewAccount.enterfromAccountId(0 );
        OpenNewAccount.enterSubmitButton();
        OpenNewAccount.verifyHappyScenario();
        OpenNewAccount.logout();

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
