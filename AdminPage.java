package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By pageTitle = By.xpath("//h6[normalize-space()='Admin']");
    private final By usernameInput = By.xpath("//label[normalize-space()='Username']/following::input[1]");
    private final By searchButton = By.xpath("//button[@type='submit']");

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    }

    public boolean isDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).isDisplayed();
    }

    public void searchUser(String username) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        input.sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public boolean resultContainsUsername(String username) {
        By result = By.xpath("//div[contains(@class,'oxd-table-cell')]//div[normalize-space()='"
                + username + "']");
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(result)).isDisplayed();
        } catch (Exception exception) {
            return false;
        }
    }
}
