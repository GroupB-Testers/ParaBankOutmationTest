package org.example.dataTest.tests;

import org.example.dataTest.pages.LoginPage;
import org.example.dataTest.pages.RegisterPage;
import org.example.dataTest.utils.ScreenShot;
import org.example.dataTest.utils.Utils;
import org.example.dataTest.data.DataTest;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private RegisterPage RegisterPage;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        driver = Utils.setup(browser);
        loginPage = new LoginPage(driver);  // تم تهيئة LoginPage باستخدام PageFactory
        RegisterPage = new RegisterPage(driver);
    }

//    @Test(dataProvider = "dataProvider")
//    public void loginTest(String username, String password) {
    @Test
        public void loginTest( ) {
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
//        String uniqueUsername = "uso2";
        RegisterPage.enterUsername(uniqueUsername);
        String password = "123" ;
        RegisterPage.enterPassword(password);
        RegisterPage.enterRepeatedPassword(password);
        RegisterPage.clickSubmitButton();
        Assert.assertTrue(RegisterPage.isErrorMessageDisplayed(),"لم تظهر رسالة الخطأ عند استخدام بيانات مكررة");
        RegisterPage.logout();

        loginPage.enterUsername(uniqueUsername);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        if (loginPage.isLogoutButtonDisplayed()) {
            System.out.println(" تسجيل دخول ناجح للمستخدم: " + uniqueUsername);
            loginPage.logout();
        } else {
            System.out.println(" تسجيل دخول فاشل للمستخدم: " + uniqueUsername);
            Assert.fail("فشل تسجيل الدخول للمستخدم: " + uniqueUsername);
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

    @DataProvider
    public Object[][] dataProvider() throws IOException, InvalidFormatException {
        DataTest dataTest = new DataTest();
        return dataTest.readSheet();
    }
}
