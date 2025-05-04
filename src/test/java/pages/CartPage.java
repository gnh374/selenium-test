package pages;

import components.ProductComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {
    private By subTotalBy = By.id("sub_total");
    private By listProductBy = By.className("row-cart-product");
    private By activeTabBy = By.className("active");
    public CartPage(WebDriver driver){
        super(driver);
        driver.get("https://www.periplus.com/checkout/cart");
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(activeTabBy));
        String text = element.getText();

        if (!text.equals("Shopping Cart")) {
            throw new IllegalStateException("This is not Cart Page of logged in user," +
                    " current page is: " + driver.getCurrentUrl());
        }

    }

    public ProductComponent findBookInCart(String id) {
        List<ProductComponent> cartItems = driver.findElements(listProductBy).stream().map(e -> new ProductComponent(e)).toList();

        for (ProductComponent item : cartItems) {
           String itemId = item.getProductId();
           if (itemId.equals(id)){
               return item;
           }
        }
        return null;
    }

    public String getQuantityOfBook(String id){
        ProductComponent book = findBookInCart(id);
        if(book!=null){
            return book.getQuantity();
        }
        return null;
    }

    public Long countTotalPrice() {
        List<WebElement> cartItemsElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listProductBy));
        List<ProductComponent> cartItems = cartItemsElements.stream()
                .map(e -> new ProductComponent(e))
                .toList();
        Long total =0L;
 
        for (ProductComponent item : cartItems) {
            Integer quantity = Integer.parseInt( item.getQuantity());
            Long price = item.getPrice();
  
            total+= price*quantity;


        }
        return total;
    }

    public Long getTotalPrice() {

        String totalPriceText = driver.findElement(subTotalBy).getText();

        totalPriceText = totalPriceText.replaceAll("[^\\d]", "");

        return Long.parseLong(totalPriceText);
    }


}
