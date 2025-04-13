package org.example.dataTest.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WebActions {

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static boolean waitForElement(WebDriver driver, WebElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean waitForOptionsToBePresent(WebDriver driver, WebElement selectElement, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(driver1 -> {
                Select select = new Select(selectElement);
                return select.getOptions().size() > 0;
            });
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public static void sendKeysWithClear(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static void click(WebElement element) {
        element.click();
    }

    public static String  gittext(WebElement element) {
        return   element.getText();
    }


    public static void select (WebElement element,int NumberOfSelect){
        Select select=new Select(element);
        select.selectByIndex(NumberOfSelect);
    }
}
