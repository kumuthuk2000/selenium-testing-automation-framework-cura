package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class Logintest extends BaseTest {
    @Test
    public void validLoginTest(){
        driver.findElement(By.id("btn-make-appointment")).click();

        HomePage loginPage = new HomePage(driver);
        loginPage.login("John Doe", "ThisIsNotAPassword");

//        Assert.assertTrue(driver.getCurrentUrl().contains("appointment"));
        if(driver.getCurrentUrl().contains("appointtment")){
            loginPage.logout();
        }
    }

}
