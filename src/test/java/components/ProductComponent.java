package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class ProductComponent extends BaseComponent {
    private By productIdBy = By.xpath(".//div[@class='row'][2]");
    private By quantityBy = By.xpath(".//input[starts-with(@name, 'quantity')]");
    private By totalPriceBy = By.xpath(".//div[contains(text(), 'Rp')]");
    public  ProductComponent(WebElement root){
        super(root);
    }

    public String getProductId(){
        WebElement secondRowDiv = root.findElement(productIdBy);
        String bookId = secondRowDiv.getText().trim();
    
        return  bookId;

    }

    public String getQuantity(){
        WebElement element = root.findElement(quantityBy);
        return element.getAttribute("value");
    }

    public Long getPrice(){
        WebElement priceElement = root.findElement(totalPriceBy);
        String priceText = priceElement.getText(); 


        Pattern pattern = Pattern.compile("Rp\\s*([\\d,.]+)");
        Matcher matcher = pattern.matcher(priceText);
        if (matcher.find()) {
            String price = matcher.group(1).replace(",", "");
            return  Long.parseLong(price);
        }
        return  null;
    }
}
