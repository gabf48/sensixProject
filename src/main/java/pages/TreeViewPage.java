package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.BasePage;

import java.util.ArrayList;
import java.util.List;

public class TreeViewPage extends BasePage {

    //Constructor
    public TreeViewPage(WebDriver driver) {
        super(driver);
    }

    //Methods
    public void assertSpecificDotsColorIsNotDisplayedOnTheScreen(String color) {
        List<WebElement> list = driver.findElements(By.cssSelector(".echarts-for-react path"));
        List<String> strings = new ArrayList<>();

        for (WebElement e : list) {
            strings.add(e.getAttribute("fill"));
        }

        boolean x = !strings.contains(color);

        System.out.println(strings);

        Assert.assertTrue(x);
    }

    public void excludeSpecificFilter(String filter) {

        List<WebElement> list =
                driver.findElements(By.cssSelector(".echarts-for-react text"));

        for (WebElement e : list) {
            if (e.getText().contains(filter)) {
                e.click();
                break;
            }
        }

    }
}
