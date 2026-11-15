package tests;

import base.BaseTest;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.PimPage;

@Listeners(TestListener.class)
public class PimTests extends BaseTest {

    @Test(groups = {"smoke"})
    public void pimModuleCanBeOpened() {
        loginAsAdmin();
        DashboardPage dashboard = new DashboardPage(driver);
        Assert.assertTrue(dashboard.isDisplayed());

        dashboard.openPim();
        Assert.assertTrue(new PimPage(driver).isDisplayed(),
                "PIM page should be displayed.");
    }

    @Test(groups = {"regression"})
    public void adminCanAddEmployee() {
        loginAsAdmin();
        new DashboardPage(driver).openPim();

        String unique = String.valueOf(System.currentTimeMillis()).substring(7);
        String first = "Auto";
        String last = "Test" + unique;

        PimPage pim = new PimPage(driver);
        pim.addEmployee(first, "QA", last);

        Assert.assertTrue(pim.employeeDetailsPageDisplayed(),
                "Personal Details page should open after saving a new employee.");
    }
}
