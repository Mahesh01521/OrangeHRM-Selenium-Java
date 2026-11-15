package tests;

import base.BaseTest;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.TestData;

@Listeners(TestListener.class)
public class LoginTests extends BaseTest {

    @Test(groups = {"smoke"})
    public void adminCanLoginSuccessfully() {
        LoginPage login = new LoginPage(driver);
        login.login(TestData.ADMIN_USERNAME, TestData.ADMIN_PASSWORD);

        Assert.assertTrue(new DashboardPage(driver).isDisplayed(),
                "Dashboard should appear after a successful login.");
    }

    @Test(groups = {"regression"})
    public void invalidCredentialsShowError() {
        LoginPage login = new LoginPage(driver);
        login.login(TestData.INVALID_USERNAME, TestData.INVALID_PASSWORD);

        Assert.assertTrue(login.getAlertText().toLowerCase().contains("invalid"),
                "Invalid credentials should display an error.");
    }

    @Test(groups = {"smoke"})
    public void adminCanLogout() {
        loginAsAdmin();
        DashboardPage dashboard = new DashboardPage(driver);
        Assert.assertTrue(dashboard.isDisplayed());
        dashboard.logout();

        Assert.assertTrue(driver.getCurrentUrl().contains("auth/login"),
                "User should be redirected to the login page.");
    }
}
