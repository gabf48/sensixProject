package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.testng.Assert.assertTrue;

public class DashboardPage extends BasePage {

    //Selectors and variables
    By euiSearchBar = By.id("devices");
    By treeViewButton = By.cssSelector(".ElectricDashboardHeaderstyle__TreeButton-sc-1o5ivyl-3");

    String eui;

    //Constructor
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    //Methods
    public void searchRandomEUI() throws InterruptedException {
        openEUISearchBar();
        Thread.sleep(5000);
        List<WebElement> euiList = driver.findElements(By.cssSelector("[role=\"listbox\"] div span > span"));
        int randNumber = ThreadLocalRandom.current().nextInt(0, 10);
        euiList.get(randNumber).click();
        storeSelectedEUI();
    }


    //private method
    private void storeSelectedEUI() {
        waitVisibility(By.cssSelector("header h6"));
        eui = driver.findElement(By.cssSelector("header h6")).getText();
    }

    public void openEUISearchBar() {
        click(euiSearchBar);
    }

    public void assertIfSelectedEUIIsDisplayInListWithAvailableEUI() {
        List<WebElement> euiList = driver.findElements(By.cssSelector("[role=\"listbox\"] div span > span"));

        List<String> strings = new ArrayList<>();
        for (WebElement e : euiList) {
            strings.add(e.getText());
        }

        boolean presence = strings.contains(eui);

        assertTrue(presence);
    }

    public void pressOnTreeViewButton(){
        click(treeViewButton);
    }
}
