package wikipedia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseTest;

public class WikiTest extends BaseTest {


    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {
        return new Object[][]{
                {"https://en.wikipedia.org/","go game","Go (game)"},
                {"https://de.wikipedia.org/","Go (Spiel)","Go (Spiel)"},
        };
    }

    @Test(dataProvider = "data-provider")
    public void test(String val, String val1, String val2) {
        testCase(val,val1, val2);
    }


    private void testCase(String url, String searchWord, String title) {
        WebDriver driver = initializeDriver();
        // Open URL
        driver.get(url);
        // Maximize the browser window
        driver.manage().window().maximize();
        // Type search word
        driver.findElement(By.name("search")).sendKeys(searchWord);
        // Press search button
        driver.findElement(By.id("searchButton")).click();
        // Assert title
        Assert.assertEquals(driver.findElement(By.className("mw-page-title-main")).getText(),title);
    }

}
