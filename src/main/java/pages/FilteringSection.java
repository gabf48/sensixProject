package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BasePage;

import java.util.List;

public class FilteringSection extends BasePage {


    //Selectors
    By filterButton = By.cssSelector(".bxgBBu span");
    By closeButton = By.cssSelector(".ReportsFiltersMenustyle__CloseButton-sc-196c8lx-3");

    //Constructor
    public FilteringSection(WebDriver driver) {
        super(driver);
    }

    //Methods
    public void openFilteringSection(){
        click(filterButton);
    }

    public void selectSpecificReportType(String reportName){
        List<WebElement> buttons = driver.findElements(By.cssSelector(".cjmlVn"));
        for (WebElement e : buttons){
            if (e.getText().contains(reportName)) {
                e.click();
                break;
            }
        }
    }

    public void closeFilterSection(){
        click(closeButton);
    }
}
