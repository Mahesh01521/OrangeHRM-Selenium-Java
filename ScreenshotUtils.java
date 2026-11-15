package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public final class ScreenshotUtils {
    private ScreenshotUtils() {}

    public static String capture(WebDriver driver, String testName) {
        if (driver == null) return "No browser session available";
        try {
            Path folder = Path.of("target", "screenshots");
            Files.createDirectories(folder);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path destination = folder.resolve(testName + "_" + timestamp + ".png");
            Files.copy(source.toPath(), destination);
            return destination.toString();
        } catch (IOException exception) {
            return "Screenshot failed: " + exception.getMessage();
        }
    }
}
