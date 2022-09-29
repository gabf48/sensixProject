package sensix;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.TreeViewPage;
import utils.BasePage;
import utils.BaseTest;
import utils.Waiters;

import static utils.Constants.*;
import static utils.Constants.VALID_PASSWORD;

public class TreeViewTests extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private BasePage basePage;
    private TreeViewPage treeViewPage;
    private Waiters waiters;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = initializeDriver();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        basePage = new BasePage(driver);
        treeViewPage = new TreeViewPage(driver);
        waiters = new Waiters(driver);
    }

    @Test
    public void checkLegendTreeView() throws InterruptedException {
        loginPage.login(LOGIN_URL, VALID_EMAIL, VALID_PASSWORD);
        Thread.sleep(2000);
        loginPage.selectSpecificWorkspace("Demo1");
        Thread.sleep(5000);
        dashboardPage.pressOnTreeViewButton();

        Thread.sleep(10000);
        basePage.assertIfTextIsDisplayedOnTheScreen("Critical");
        basePage.assertIfTextIsDisplayedOnTheScreen("Warning");
        basePage.assertIfTextIsDisplayedOnTheScreen("Normal");
        basePage.assertIfTextIsDisplayedOnTheScreen("None");
    }

    @Test
    public void checkStatusNone() throws InterruptedException {
        loginPage.login(LOGIN_URL, VALID_EMAIL, VALID_PASSWORD);
        waiters.waitDisappearsLoadingSpinner();
        loginPage.selectSpecificWorkspace("Demo1");
        Thread.sleep(5000);
        dashboardPage.pressOnTreeViewButton();
        Thread.sleep(15000);
        treeViewPage.excludeSpecificFilter("Critical");
        treeViewPage.excludeSpecificFilter("Warning");
        treeViewPage.excludeSpecificFilter("Normal");
        treeViewPage.assertSpecificDotsColorIsNotDisplayedOnTheScreen("rgb(232,71,71)");

    }
}
