package sensix;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountSettingsPage;
import pages.LeftNavBar;
import pages.LoginPage;
import utils.BaseTest;

import static utils.Constants.*;

public class LogoutTests extends BaseTest {

    private LoginPage loginPage;
    private LeftNavBar leftNavBar;
    private AccountSettingsPage accountSettingsPage;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = initializeDriver();
        loginPage = new LoginPage(driver);
        leftNavBar = new LeftNavBar(driver);
        accountSettingsPage = new AccountSettingsPage(driver);
    }


    @Test
    public void searchSpecificEUIAndCheckIfIsDisplayCorrect() {
        loginPage.login(LOGIN_URL, VALID_EMAIL, VALID_PASSWORD);
        loginPage.selectSpecificWorkspace("Demo1");

        leftNavBar.pressAccountSettingsButton();
        accountSettingsPage.pressLogoutButton();

        Assert.assertEquals(driver.getCurrentUrl(),LOGIN_URL);
    }
}
