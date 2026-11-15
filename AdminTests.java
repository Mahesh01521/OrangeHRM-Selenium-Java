package tests;

import base.BaseTest;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.DashboardPage;

@Listeners(TestListener.class)
public class AdminTests extends BaseTest {

    @Test(groups = {"regression"})
    public void adminModuleCanBeOpened() {
        loginAsAdmin();
        new DashboardPage(driver).openAdmin();

        Assert.assertTrue(new AdminPage(driver).isDisplayed(),
                "Admin page should be displayed.");
    }

    @Test(groups = {"regression"})
    public void adminCanSearchForAdminAccount() {
        loginAsAdmin();
        new DashboardPage(driver).openAdmin();

        AdminPage admin = new AdminPage(driver);
        Assert.assertTrue(admin.isDisplayed());
        admin.searchUser("Admin");

        Assert.assertTrue(admin.resultContainsUsername("Admin"),
                "Search results should contain the Admin username.");
    }
}
