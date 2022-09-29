package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class LeftNavBar extends BasePage {

    //Selectors
    By accountSettingsButton = By.cssSelector("[alt=\"avatar\"]");

    //Constructor
    public LeftNavBar(WebDriver driver) {
        super(driver);
    }

    //Methods
    public void pressAccountSettingsButton(){
        click(accountSettingsButton);
    }
}
