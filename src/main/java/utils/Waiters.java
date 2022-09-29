package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters extends BasePage{
    public Waiters(WebDriver driver) {
        super(driver);
    }

    public void waitDisappearsLoadingSpinner(){
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".criBsS")));
        WebElement loadingElement = driver.findElement(By.cssSelector(".criBsS"));
        wait.until(ExpectedConditions.invisibilityOf((loadingElement)));
    }
}
