package Pages;

import Base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.Iterator;
import java.util.Set;

public class OrderPage extends TestBase {
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

    @FindBy(partialLinkText = "OnePlus 11 5G (Eternal Green, 8GB RAM, 128GB Storage)")
    WebElement mobile;

    @FindBy(id = "buy-now-button")
    WebElement buy;

    @FindBy(xpath = "(//input[@class='a-button-input'])[2]")
    WebElement useaddress;

    @FindBy(xpath = "//input[contains(@id,'125')]")
    WebElement otherupi;
    @FindBy(xpath = "//input[contains(@id,'113')]")
    WebElement upi;

    @FindBy(xpath = "//input[@name='ppw-widgetEvent:ValidateUpiIdEvent']")
    WebElement verify;

    @FindBy(xpath = "(//span[@class='a-button-inner'])[7]")
    WebElement UseThisPayment;

    public OrderPage(){
        PageFactory.initElements(driver,this);
    }

    public void buy(String un, String pw, String sarh, String up) throws InterruptedException, AWTException {
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
        robot.mouseWheel(8);
        Thread.sleep(2000);

        buy.click();
        Thread.sleep(4000);

        useaddress.click();
        Thread.sleep(3000);
        robot.mouseWheel(20);
        otherupi.click();
        Thread.sleep(3000);
        upi.sendKeys(up);
        Thread.sleep(3000);
        verify.click();
        Thread.sleep(3000);

        UseThisPayment.click();



    }
}
