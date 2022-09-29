package sensix;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BasePage;
import utils.BaseTest;
import utils.Waiters;

import static utils.Constants.*;

public class LoginTests extends BaseTest {

    private LoginPage loginPage;
    private BasePage basePage;
    private Waiters waiters;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = initializeDriver();
        loginPage = new LoginPage(driver);
        basePage = new BasePage(driver);
        waiters = new Waiters(driver);
    }

    @Test
    public void checkErrorForInvalidUser() {
        loginPage.login(LOGIN_URL);
        waiters.waitDisappearsLoadingSpinner();
        basePage.assertIfTextIsDisplayedOnTheScreen("No active account found with the given credentials.");
    }

}
