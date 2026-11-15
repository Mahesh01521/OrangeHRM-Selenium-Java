package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PimPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By pageTitle = By.xpath("//h6[normalize-space()='PIM']");
    private final By employeeNameInput = By.xpath(
            "//label[normalize-space()='Employee Name']/following::input[1]");
    private final By searchButton = By.xpath("//button[@type='submit']");
    private final By addButton = By.xpath("//button[normalize-space()='Add']");
    private final By firstName = By.name("firstName");
    private final By middleName = By.name("middleName");
    private final By lastName = By.name("lastName");
    private final By saveButton = By.xpath("//button[@type='submit']");
    private final By employeeIdInput = By.xpath(
            "//label[normalize-space()='Employee Id']/following::input[1]");

    public PimPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    }

    public boolean isDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).isDisplayed();
    }

    public void searchEmployeeByName(String name) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameInput));
        input.sendKeys(name);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public boolean resultsContainEmployee(String name) {
        By matchingName = By.xpath(
                "//div[contains(@class,'oxd-table-cell')]//div[normalize-space()='" + name + "']");
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(matchingName)).isDisplayed();
        } catch (Exception exception) {
            return false;
        }
    }

    public void addEmployee(String first, String middle, String last) {
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(first);
        driver.findElement(middleName).sendKeys(middle);
        driver.findElement(lastName).sendKeys(last);
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    public boolean employeeDetailsPageDisplayed() {
        By personalDetails = By.xpath("//h6[normalize-space()='Personal Details']");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(personalDetails)).isDisplayed();
    }
}
