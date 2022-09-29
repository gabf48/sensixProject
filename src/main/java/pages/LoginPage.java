package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BasePage;

import java.util.List;

public class LoginPage extends BasePage {

    //Selectors
    By emailField = By.id("email");
    By passwordField = By.id("password");
    By loginButton = By.xpath("//*[@id=\"root\"]/div/main/div/section/div[2]/div/form[2]/button");
    By workspaceDropDown = By.cssSelector("[class=\"DropdownTogglestyle__Toggle-v1w2zb-0 dRKhAX\"]");
    By enterButton = By.xpath("//*[@id=\"root\"]/div/main/div/section/div[3]/div/div/div/div[1]/button");

    //Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Methods
    public void login(String url,String email,String password){
        driver.manage().window().maximize();
        driver.get(url);
        pressDefaultLoginButton();
        typeEmail(email);
        typePassword(password);
        pressLoginButton();
    }

    //second method with same name for using polymorphism
    public void login(String url) {
        driver.manage().window().maximize();
        driver.get(url);
        pressDefaultLoginButton();
        typeEmail(RandomStringUtils.randomAlphabetic(8) + "@gmail.com");
        typePassword( RandomStringUtils.randomAlphabetic(8));
        pressLoginButton();
    }

    public void selectSpecificWorkspace(String workspace){
        click(workspaceDropDown);
        List<WebElement> buttons = driver.findElements(By.cssSelector(".DropdownMenustyle__ChildrenContainer-mql1r5-2 span >span"));
        for (WebElement e : buttons){
            if (e.getText().contains(workspace)) {
                e.click();
                break;
            }
        }
        pressEnter();
    }

    //private methods
    private void pressDefaultLoginButton(){
        List<WebElement> buttons = driver.findElements(By.cssSelector("form button"));
        for (WebElement e : buttons){
            if (e.getText().contains("Default")) {
                e.click();
                break;
            }
        }
    }

    private void typeEmail(String email){
        writeText(emailField,email);
    }

    private void typePassword(String password){
        writeText(passwordField, password);
    }

    private void pressLoginButton(){
        click(loginButton);
    }

    private void pressEnter(){
        click(enterButton);
    }
}
