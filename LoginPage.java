package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By username = By.name("username");
    private final By password = By.name("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By alert = By.cssSelector(".oxd-alert-content-text");
    private final By dashboardHeading = By.xpath("//h6[normalize-space()='Dashboard']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void login(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).clear();
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
    }

    public boolean isDashboardDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeading)).isDisplayed();
        } catch (Exception exception) {
            return false;
        }
    }

    public String getAlertText() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(alert));
        return message.getText();
    }
}
