package org.example.dataTest.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScreenShot {
    public static void takeScreenshot(WebDriver driver, String path) throws IOException {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver لا يمكن أن يكون فارغًا");
        }
        if (path == null || path.trim().isEmpty()) {
            throw new IllegalArgumentException("مسار الحفظ غير صالح");
        }

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        Files.copy(screenshotFile.toPath(), Path.of(path));

        System.out.println("تم حفظ لقطة الشاشة في: " + path);
    }
}