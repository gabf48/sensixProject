package sensix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FilteringSection;
import pages.LoginPage;
import utils.BaseTest;

import static utils.Constants.*;

public class SortingTests extends BaseTest {

    private LoginPage loginPage;
    private FilteringSection filteringSection;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = initializeDriver();
        loginPage = new LoginPage(driver);
        filteringSection = new FilteringSection(driver);
    }

    @Test
    public void checkSorting() throws InterruptedException {
        loginPage.login(LOGIN_URL, VALID_EMAIL, VALID_PASSWORD);
        loginPage.selectSpecificWorkspace("Demo1");

        driver.get("https://app.sensix.xyz/demo1/reports");

        filteringSection.openFilteringSection();
        Thread.sleep(4000);
        filteringSection.selectSpecificReportType("Energy Performance");
        filteringSection.closeFilterSection();
        Thread.sleep(5000);
        for (int i =1; i<=6;i++){
            driver.findElement(By.cssSelector("div.ReportsListstyle__Header-sc-1gwtk95-2.eWmSbL > div:nth-child("+i+")")).click();
            Thread.sleep(4000);
        }
    }
}
