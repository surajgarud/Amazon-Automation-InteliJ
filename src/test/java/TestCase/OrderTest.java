package TestCase;

import Base.TestBase;
import Pages.AddToCart;
import Pages.OrderPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.awt.*;
@Listeners(Listener.listener.class)
public class OrderTest extends TestBase {
    OrderPage orderPage;
    public OrderTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        init();
        orderPage = new OrderPage();
    }
    @Test
    public void Buy() throws InterruptedException, AWTException {
        orderPage.buy(prop.getProperty("email"),
                prop.getProperty("password"),
                prop.getProperty("Search"),
                prop.getProperty("upi"));
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}
