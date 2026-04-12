package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }

   @AfterMethod
   public void tearDown(ITestResult result) {
       if (ITestResult.FAILURE == result.getStatus()) {
           // Code to take screenshot using ((TakesScreenshot)driver)
           System.out.println("Test Failed: " + result.getName());
       }
       driver.quit();
   }
}
