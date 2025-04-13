package org.example.dataTest.tests;
import org.example.dataTest.pages.ContactUsPage;
import org.example.dataTest.pages.RegisterPage;
import org.example.dataTest.pages.UpdatContectInfoPage;
import org.example.dataTest.utils.ScreenShot;
import org.example.dataTest.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContactUsTest {
    private WebDriver driver;
   private ContactUsPage ContactUsPage;



    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        driver = Utils.setup(browser);
        ContactUsPage =new ContactUsPage(driver);
    }

    @Test
    public void testFullUserJourney() {
        ContactUsPage.contectUusButton();
        ContactUsPage.name("eslam");
        ContactUsPage.email("eslam8@gamil.com");
        ContactUsPage.phone("0125465464");
        ContactUsPage.message("I want to login but i cant");
        ContactUsPage.SendtoCustomerCare();
        ContactUsPage.setTransferFudsSucess();
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



