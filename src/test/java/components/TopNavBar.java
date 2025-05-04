package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopNavBar extends  BaseComponent{
    private By searchBarBy = By.id("filter_name");
    private By buttonSearchBy = By.cssSelector("button.btnn");
    public TopNavBar(WebElement root){
        super(root);
    }

    public WebElement getSearchBarBy() {
        return root.findElement(searchBarBy);
    }
    public WebElement getSearchButtonBy() {
        return root.findElement(buttonSearchBy);
    }
}
