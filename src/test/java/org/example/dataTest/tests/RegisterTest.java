package org.example.dataTest.tests;

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

public class RegisterTest {
    private WebDriver driver;
    private RegisterPage RegisterPage;


    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        driver = Utils.setup(browser);
        RegisterPage = new RegisterPage(driver);  // تم تهيئة RegisterTest باستخدام PageFactory
    }

//    @Test(dataProvider = "dataProvider")
    @Test
    public void testSuccessfulRegistration() {
        RegisterPage.clickRegisterButton();
        RegisterPage.enterFirstName("so2");
        RegisterPage.enterLastName("Mohamed");
        RegisterPage.enterStreet("123 Street");
        RegisterPage.enterCity("Cairo");
        RegisterPage.enterState("Giza");
        RegisterPage.enterZipCode("12345");
        RegisterPage.enterPhoneNumber("01012345678");
        RegisterPage.enterSSN("123-45-6789");
//        String uniqueUsername = "user" + System.currentTimeMillis();
        String uniqueUsername = "so1";
        RegisterPage.enterUsername(uniqueUsername);
        RegisterPage.enterPassword("123");
        RegisterPage.enterRepeatedPassword("123");
        RegisterPage.clickSubmitButton();
        Assert.assertTrue(RegisterPage.isErrorMessageDisplayed(),"لم تظهر رسالة الخطأ عند استخدام بيانات مكررة");
        RegisterPage.logout();
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

//    @DataProvider
//    public Object[][] dataProvider() throws IOException, InvalidFormatException {
//        DataTest dataTest = new DataTest();
//        return dataTest.readSheet();
//    }
}
