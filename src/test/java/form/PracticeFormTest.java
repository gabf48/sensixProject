package form;


import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseTest;

public class PracticeFormTest extends BaseTest {


    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {
        return new Object[][]{
                {"Ana", "Stone", "9/22/2022", 0},
                {"Jane", "Turner", "9/22/2022", 1},
                {"Lisa", "Warden", "9/22/2022", 2},
        };
    }


    @Test(dataProvider = "data-provider")
    public void test1(String val, String val1, String val2, int x) {
        testCase(val, val1, val2, x);
        Assert.assertEquals(driver.findElement(By.cssSelector("[style=\"font-size: medium;\"]")).getText(),"AUTOMATION PRACTICE ME");
    }


    private void testCase(String fistName, String lastName, String data, int x) {
        WebDriver driver = initializeDriver();
        // Open URL
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        // Set Chrome window size
        driver.manage().window().setSize(new Dimension(1552, 840));
        //accept cookies
        driver.findElement(By.id("ez-accept-all")).click();
        // Enter Firstname
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys(fistName);
        // Set Lastname
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        // Select Gender
        driver.findElement(By.id("sex-1")).click();
        // Select Experience
        driver.findElement(By.id("exp-" + x)).click();
        // Enter Date
        driver.findElement(By.id("datepicker")).click();
        driver.findElement(By.id("datepicker")).sendKeys(data);
        // Select Profession
        driver.findElement(By.id("profession-1")).click();
        // Select Automation Tool
        driver.findElement(By.id("tool-2")).click();

        // Select Continent
        driver.findElement(By.id("continents")).click();
        WebElement dropdown = driver.findElement(By.id("continents"));
        dropdown.findElement(By.xpath("//option[. = 'Europe']")).click();

        // Select Command
        WebElement dropdown1 = driver.findElement(By.id("selenium_commands"));
        dropdown1.findElement(By.xpath("//option[. = 'Browser Commands']")).click();

        // Scroll Vertical
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,675.5555419921875)");

        // Click Submit
        driver.findElement(By.id("submit")).click();

    }


}
