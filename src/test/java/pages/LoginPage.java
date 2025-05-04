package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    private By emailBy = By.name("email");

    private By passwordBy = By.name("password");

    private By buttonLoginBy = By.id("button-login");

    public LoginPage (WebDriver driver){
        super(driver);
        driver.get("https://www.periplus.com/account/Login");

    }

    public HomePage loginValidUser(String userName, String password) {
        driver.findElement(emailBy).sendKeys(userName);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(buttonLoginBy).click();
        return new HomePage(driver);
    }
}
