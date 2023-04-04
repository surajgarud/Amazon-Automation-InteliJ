package TestCase;

import Base.TestBase;
import Pages.AddToWishlist;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;
@Listeners(Listener.listener.class)
public class AddWishlistTest extends TestBase {
    AddToWishlist addToWishlist;
    public AddWishlistTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        init();
        addToWishlist = new AddToWishlist();
    }
    @Test
    public void addtocart() throws InterruptedException, AWTException {
        addToWishlist.addwishlist(prop.getProperty("email"), prop.getProperty("password"),prop.getProperty("wishlist"));
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}
