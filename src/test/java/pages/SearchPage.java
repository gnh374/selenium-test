package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage{
    private By singleProductBy = By.cssSelector(".single-product");
    public SearchPage(WebDriver driver){
        super(driver);
        this.wait.until(ExpectedConditions.titleIs("Search"));

    }

    public DetailedPage clickFirstSearchedProduct() {
        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(singleProductBy));
        firstProduct.click();
        waitLoading();
        return new DetailedPage(driver);
    }

}
