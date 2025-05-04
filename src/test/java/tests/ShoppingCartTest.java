package tests;

import facades.ShoppingCartFacade;

import org.testng.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class ShoppingCartTest extends BaseTest {

    ShoppingCartFacade shoppingCartFacade;

    @BeforeTest
    public void setUp() {
        super.setUp();
        shoppingCartFacade = new ShoppingCartFacade(driver);
    }

    @Test
    public void AddProductSuccessTest(){
       String id = shoppingCartFacade.addToCartAfterLoggedIn("gaby.htgl@gmail.com", "SecurePassword", "romance","3");
       //wait for 2s to make sure new item added
       try {
            Thread.sleep(2000);
       } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread was interrupted during sleep", e);
       }
        Assert.assertTrue(shoppingCartFacade.isBookExistOnCart(id), "Book Not Exist");
       Assert.assertEquals(shoppingCartFacade.getQuantityOfBookInCart(id),"3");
       Assert.assertEquals( shoppingCartFacade.countTotalPrice(), shoppingCartFacade.getTotalPrice());
    }


}
