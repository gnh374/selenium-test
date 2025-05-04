package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Keys;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetailedPage extends BasePage{
    private By identifierBy = By.className("row-product-detail");
    private By quantityBy = By.xpath("//input[starts-with(@name, 'qty_')]");
    private By addToCartButtonBy = By.cssSelector("button.btn-add-to-cart");
    public DetailedPage(WebDriver driver) {
        super(driver);
        this.wait.until(ExpectedConditions.presenceOfElementLocated(identifierBy));
    }


    public String addToCart(String quantity){
        WebElement element = driver.findElement(quantityBy);
        element.click();
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(quantity);
        WebElement addTocartButton = driver.findElement(addToCartButtonBy);
        addTocartButton.click();

        String title = driver.getTitle(); 
        Pattern pattern = Pattern.compile("\\|\\s(\\d{13})\\s\\|");
        Matcher matcher = pattern.matcher(title);

        if (matcher.find()) {
            String id = matcher.group(1);
    
            return id.trim();
        } else {
            return  null;
        }


    }
}
