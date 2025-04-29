import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.periplus.com/");

    }

    public void login(){
        driver.get("https://www.periplus.com/account/Login");
        WebElement form = driver.findElement(By.id("login"));


        WebElement email = form.findElement(By.name("email"));
        WebElement password = form.findElement(By.name("password"));

        email.sendKeys("gaby.htgl@gmail.com");
        password.sendKeys("SecurePassword");

        WebElement submitButton = form.findElement(By.id("button-login"));
        submitButton.click();
    }

    public void waitLoading(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("preloader")));
    }
}
