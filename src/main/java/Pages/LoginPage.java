package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

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

    public LoginPage(){

        PageFactory.initElements(driver,this);
    }

    public void login(String un, String pw) throws InterruptedException {
        sign.click();
        email.sendKeys(un);
        continuebtn.click();
        Thread.sleep(2000);
        pass.sendKeys(pw);
        signbtn.click();
        Thread.sleep(2000);
    }

    public void multipleUserLogin(String un, String pw) throws InterruptedException {
        sign.click();
        email.sendKeys(un);
        continuebtn.click();
        Thread.sleep(2000);
        pass.sendKeys(pw);
        signbtn.click();
        Thread.sleep(2000);
    }

    public String geturl(){

        return driver.getCurrentUrl();
    }

}
