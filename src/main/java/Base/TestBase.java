package Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;

    public ExtentReports extent = new ExtentReports();
    public ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");

    public TestBase(){
        try{
            prop = new Properties();
            FileInputStream pa = new FileInputStream("C:\\Users\\suraj\\IdeaProjects\\BooksWagon\\src\\main\\java\\Config\\config.properties");
            prop.load(pa);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void init(){
        String Browser = prop.getProperty("browser");
        if(Browser.equals("edge")){
            System.setProperty("WebDriver.edge.driver","C:\\Users\\suraj\\Downloads\\edgedriver_win64\\msedgedriver.exe");
            driver= new EdgeDriver();
        }
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
}