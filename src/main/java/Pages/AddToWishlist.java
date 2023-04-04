package Pages;

import Base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.Iterator;
import java.util.Set;

public class AddToWishlist extends TestBase {

    @FindBy(partialLinkText = "Sign in")
    WebElement sign;

    @FindBy(id = "ap_email")
    WebElement email;

    @FindBy(id = "continue")
    WebElement continuebtn;

    @FindBy(id = "ap_password")
    WebElement pass;

    @FindBy(id = "signInSubmit")
    WebElement signbtn;

    @FindBy(id = "twotabsearchtextbox")
    WebElement search;

    @FindBy(partialLinkText = "Apple iPhone 13 (128GB) - Starlight")
    WebElement mobile;

    @FindBy(id = "add-to-wishlist-button-submit")
    WebElement addwishlist;

    @FindBy(partialLinkText = "View Your List")
    WebElement list;

    public AddToWishlist(){
        PageFactory.initElements(driver,this);
    }

    public void addwishlist(String un, String pw, String sarh) throws InterruptedException, AWTException {
        sign.click();
        email.sendKeys(un);
        continuebtn.click();
        Thread.sleep(2000);
        pass.sendKeys(pw);
        signbtn.click();
        Thread.sleep(2000);
        search.sendKeys(sarh);
        search.sendKeys(Keys.ENTER);
        mobile.click();

        //storing in windows variable by using getwindow method
        Set<String> windows= driver.getWindowHandles();

        //Calling Iterator method to perform iteration on windows
        Iterator<String> it = windows.iterator();

        //Creating Windows variable ie p is Parent and c is Child
        String p = it.next();
        String c = it.next();
        Thread.sleep(2000);

        //Switching to required windows ie c
        driver.switchTo().window(c);
        Thread.sleep(1000);

        //to perform scroll operation
        Robot robot = new Robot();
        robot.mouseWheel(6);
        Thread.sleep(2000);

        addwishlist.click();
        Thread.sleep(4000);

        //switching controller back to the parent window
//        driver.switchTo().window(p);
//        Thread.sleep(4000);

        list.click();


    }
}
