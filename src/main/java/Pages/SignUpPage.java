package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends TestBase {

    @FindBy (partialLinkText= "Start here.")
    WebElement signup;

    @FindBy(id = "ap_customer_name")
    WebElement name;

    @FindBy(id = "ap_phone_number")
    WebElement MoNumber;

    @FindBy(id = "ap_password")
    WebElement pass;

    @FindBy(id = "continue")
    WebElement continuebtn;

    public SignUpPage(){
        PageFactory.initElements(driver,this);

    }
     public void signUp(String nm, String MobNo, String pw) throws InterruptedException {
        signup.click();
        name.sendKeys(nm);
        MoNumber.sendKeys(MobNo);
        pass.sendKeys(pw);
        Thread.sleep(2000);
        continuebtn.click();

    }
}
