package org.example.dataTest.tests;

import org.example.dataTest.pages.ForgotLoginInfoPage;
import org.example.dataTest.pages.RegisterPage;
import org.example.dataTest.utils.ScreenShot;
import org.example.dataTest.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ForgotLoginInfoTest {

    private WebDriver driver;
    private RegisterPage RegisterPage;
    private ForgotLoginInfoPage ForgotLoginInfoPage;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        driver = Utils.setup(browser);
        RegisterPage = new RegisterPage(driver);
        ForgotLoginInfoPage = new ForgotLoginInfoPage(driver);

    }

    @Test
    public void testFullUserJourney() {
        RegisterPage.clickRegisterButton();
        String uniqueUsername = "eslam" + System.currentTimeMillis();
//        String uniqueUsername = "eslam6";
        RegisterPage.enterFirstName("John");
        RegisterPage.enterLastName("Doe");
        RegisterPage.enterStreet("123 Main Street");
        RegisterPage.enterCity("Anytown");
        RegisterPage.enterState("CA");
        RegisterPage.enterZipCode("90210");
        RegisterPage.enterPhoneNumber(uniqueUsername);
        RegisterPage.enterSSN("123-45-6789");
        RegisterPage.enterUsername(uniqueUsername);
        String password = uniqueUsername;
        RegisterPage.enterPassword(password);
        RegisterPage.enterRepeatedPassword(uniqueUsername);
        RegisterPage.clickSubmitButton();
        RegisterPage.logout();

        ForgotLoginInfoPage.ForgotlogininfoButton();
        ForgotLoginInfoPage.name("John");
        ForgotLoginInfoPage.lastName("Doe");
        ForgotLoginInfoPage.address("123 Main Street");
        ForgotLoginInfoPage.city("Anytown");
        ForgotLoginInfoPage.state("CA");
        ForgotLoginInfoPage.zipCode("90210");
        ForgotLoginInfoPage.ssn("123-45-6789");
        ForgotLoginInfoPage.findMyLohinInsubmitButtton();
        ForgotLoginInfoPage.setTransferFudsSucess();
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

