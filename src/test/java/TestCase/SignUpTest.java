package TestCase;

import Base.TestBase;
import Pages.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Listener.listener.class)
public class SignUpTest extends TestBase {
    SignUpPage signUpPage;
    public SignUpTest(){
        super();
    }
    @BeforeMethod
    public void setup(){
        init();
        signUpPage = new SignUpPage();
    }
@Test(priority = 4)
    public void signup() throws InterruptedException {
        signUpPage.signUp(prop.getProperty("name"), prop.getProperty("mobNumber"),prop.getProperty("pass"));
    }
    @Test(priority = 1)
    public void titleRegistrationPage(){
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
        driver.findElement(By.id("createAccountSubmit")).click();
        String signup=  driver.getTitle();
        Assert.assertEquals(signup,"Amazon Registration");
        System.out.println("Title is  :" +signup);
    }

    @Test(priority = 2)
    public void Dropdown(){
        driver.findElement(By.partialLinkText("Start here.")).click();
        Select dropdown = new Select(driver.findElement(By.id("auth-country-picker")));
        boolean status = dropdown.isMultiple();
        if(status){
            System.out.println("Allows multiple selection");
        } else {
            System.out.println("Does not allow multiple selection");
        }

    }
    @Test(priority = 3)
    public void enabledName(){
        driver.get("https://www.amazon.in/ap/register?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
        boolean isEnable = driver.findElement(By.id("ap_customer_name")).isEnabled();
        Assert.assertTrue(isEnable);
    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}
