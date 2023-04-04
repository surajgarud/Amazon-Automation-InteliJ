package TestCase;

import Base.TestBase;
import Pages.LoginPage;
import Utility.utilityclass;
import io.qameta.allure.internal.shadowed.jackson.databind.exc.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(Listener.listener.class)
public class LoginTest extends TestBase {
    LoginPage loginpg;
    public utilityclass utility;
    public String sheetname = "Sheet1";

    public LoginTest(){

        super();
    }
@BeforeMethod
    public void setup(){
        init();
        loginpg = new LoginPage();
    }
@Test(priority = 5)
    public void Logintest() throws InterruptedException {

        loginpg.login(prop.getProperty("email"), prop.getProperty("password") );
    }
    @Test(priority = 1)
    public void title(){
      String title = driver.getTitle();
      System.out.println(title);
    }
@Test(priority = 2)
public void url(){
        String url = loginpg.geturl();
      Assert.assertEquals(url, "https://www.amazon.in/ref=ap_frn_logo");
}
@Test(priority = 3)
    public void logintitle(){
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
        String title = driver.getTitle();
        System.out.println(title);
    }

    @Test(priority = 4)
    public void enabledEmail(){
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
        boolean isEnable = driver.findElement(By.id("ap_email")).isEnabled();
        Assert.assertTrue(isEnable);
    }

    @DataProvider
    public Object[][]getLoginDetails() throws InvalidFormatException {
        Object data[][]=utility.getTestData(sheetname);
        return data;
    }
    @Test(dataProvider = "getLoginDetails",priority=6)
    public void MultiUserLogin(String un, String pw) throws InterruptedException {
        loginpg.multipleUserLogin(un,pw);
    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}
