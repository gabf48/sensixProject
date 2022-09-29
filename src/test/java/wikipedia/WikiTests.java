package wikipedia;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.io.File;

public class WikiTests extends BaseTest {


    @Test
    public void testWiki1() throws Exception {
        WebDriver driver = initializeDriver();
        // Open URL
        driver.get("https://en.wikipedia.org/");
        // Maximize the browser window
        driver.manage().window().maximize();
        // Type search word
        driver.findElement(By.name("search")).sendKeys("go game");
        // Press search button
        driver.findElement(By.id("searchButton")).click();
        // Assert title
        Assert.assertEquals(driver.findElement(By.className("mw-page-title-main")).getText(),"Go (game)");
        //screenshot
        this.takeSnapShot(driver, "src/test/java/screenshots/test.png") ;
    }

    @Test
    public void testWiki2() throws Exception {
        WebDriver driver = initializeDriver();
        // Open URL
        driver.get("https://de.wikipedia.org/");
        // Maximize the browser window
        driver.manage().window().maximize();
        // Type search word
        driver.findElement(By.name("search")).sendKeys("Go (Spiel)");
        // Press search button
        driver.findElement(By.id("searchButton")).click();
        // Assert title
        String text = driver.findElement(By.className("mw-page-title-main")).getText();
        Assert.assertEquals(driver.findElement(By.className("mw-page-title-main")).getText(),"Go (Spiel)");
        //screenshot
        this.takeSnapShot(driver, "src/test/java/screenshots/test1.png") ;
    }

    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(fileWithPath);

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);

    }
}
