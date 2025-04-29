import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class ShoppingCartTest extends BaseTest{

    @Test
    public void AddProductSuccessTest(){
        login();
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("filter_name")));
        searchBox.sendKeys("romance");

        waitLoading();

        WebElement submitButton = driver.findElement(By.cssSelector("button.btnn"));
        submitButton.click();

        waitLoading();

        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".single-product")));
        firstProduct.click();

        waitLoading();

        WebElement addTocartButton = driver.findElement(By.cssSelector("button.btn-add-to-cart"));
        addTocartButton.click();

        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-text")));

        Assert.assertEquals(modal.getText(), "Success add to cart");

        driver.get("https://www.periplus.com/checkout/cart");

        waitLoading();

        List<WebElement> contentList = driver.findElements(By.className("content"));

        if (!contentList.isEmpty()) {
            WebElement content = contentList.get(0);
            Assert.assertFalse(content.getText().contains("Your shopping cart is empty"), "Cart still empty");
        } else {
            WebElement productDetail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("row-cart-product")));
            Assert.assertNotNull(productDetail, "Cart still empty");

        }






    }
}
