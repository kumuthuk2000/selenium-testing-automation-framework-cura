package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Logintest extends BaseTest {
    @Test
    public void validLoginTest(){
        driver.findElement(By.id("btn-make-appointment")).click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("John Doe", "ThisIsNotAPassword");

        Assert.assertTrue(driver.getCurrentUrl().contains("appointment"));

    }
}
