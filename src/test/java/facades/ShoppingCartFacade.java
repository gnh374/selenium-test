package facades;

import components.ProductComponent;
import org.openqa.selenium.WebDriver;
import pages.*;

public class ShoppingCartFacade {
    LoginPage loginPage;
    WebDriver driver;


    public ShoppingCartFacade(WebDriver driver){
        this.driver = driver;
        loginPage = new LoginPage(driver);

    }
    public String addToCartAfterLoggedIn(String email, String password, String bookName, String quantity){
        HomePage   homePage = loginPage.loginValidUser(email, password);
        SearchPage searchPage = homePage.performSearch(bookName);
        DetailedPage detailedPage = searchPage.clickFirstSearchedProduct();
        return detailedPage.addToCart(quantity);

    }

    public String getQuantityOfBookInCart(String id){
        CartPage cartPage = new CartPage(driver);
        return cartPage.getQuantityOfBook(id);
    }

    public Long getTotalPrice(){
        CartPage cartPage = new CartPage(driver);
        return cartPage.getTotalPrice();
    }
    public Long countTotalPrice(){
        CartPage cartPage = new CartPage(driver);
        return cartPage.countTotalPrice();
    }
    public boolean isBookExistOnCart(String id){
        CartPage cartPage = new CartPage(driver);
        ProductComponent product = cartPage.findBookInCart(id);
        if(product != null){
            return  true;
        }
        return false;
    }
}
