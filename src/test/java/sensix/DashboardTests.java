package sensix;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.BaseTest;

import static utils.Constants.*;

public class DashboardTests extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = initializeDriver();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Test
    public void searchSpecificEUIAndCheckIfIsDisplayCorrect() throws InterruptedException {
        loginPage.login(LOGIN_URL, VALID_EMAIL, VALID_PASSWORD);
        loginPage.selectSpecificWorkspace("Demo1");

        dashboardPage.searchRandomEUI();

        driver.navigate().back();

        dashboardPage.openEUISearchBar();

        dashboardPage.assertIfSelectedEUIIsDisplayInListWithAvailableEUI();
    }
}
