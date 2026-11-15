package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By dashboardHeader = By.xpath("//h6[normalize-space()='Dashboard']");
    private final By pimMenu = By.xpath("//span[normalize-space()='PIM']");
    private final By adminMenu = By.xpath("//span[normalize-space()='Admin']");
    private final By userDropdown = By.cssSelector(".oxd-userdropdown-tab");
    private final By logoutLink = By.xpath("//a[normalize-space()='Logout']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    }

    public boolean isDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader)).isDisplayed();
    }

    public void openPim() {
        wait.until(ExpectedConditions.elementToBeClickable(pimMenu)).click();
    }

    public void openAdmin() {
        wait.until(ExpectedConditions.elementToBeClickable(adminMenu)).click();
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(userDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }
}
