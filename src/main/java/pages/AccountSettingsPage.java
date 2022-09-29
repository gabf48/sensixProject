package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class AccountSettingsPage extends BasePage {


    //Selectors
    By logoutButton = By.cssSelector("div.Layoutstyle__Column-sc-1lt1ngp-0.jHPTyd > button span");


    //Constructor
    public AccountSettingsPage(WebDriver driver) {
        super(driver);
    }

    //Methods
    public void pressLogoutButton(){
        click(logoutButton);
    }
}
