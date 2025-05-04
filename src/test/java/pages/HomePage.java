package pages;

import components.TopNavBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    private TopNavBar topNavBar;
    private By identifierBy = By.className("middle-inner");
    public HomePage(WebDriver driver) {
        super(driver);
        waitLoading();
        WebElement topNavRoot = driver.findElement(identifierBy);
        this.topNavBar = new TopNavBar(topNavRoot);
    }

        public SearchPage performSearch(String bookName){
        WebElement searchBar = topNavBar.getSearchBarBy();
        wait.until(ExpectedConditions.elementToBeClickable(searchBar));
        searchBar.sendKeys(bookName);

        WebElement submitButton = topNavBar.getSearchButtonBy();
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));

        submitButton.click();

        waitLoading();

        return new SearchPage(driver);
    }
}
