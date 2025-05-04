package factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public static WebDriver getDriver(String browserType) {
        if ("chrome".equalsIgnoreCase(browserType)) {
            return new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browserType)) {
            return new FirefoxDriver();
        }
        throw new IllegalArgumentException("Unsupported browser type");
    }
}
