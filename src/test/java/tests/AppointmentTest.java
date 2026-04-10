package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AppointmentPage;
import pages.HomePage;

import java.time.Duration;

public class AppointmentTest extends BaseTest {

    @Test
    public void validAppointmentTest(){
        driver.findElement(By.id("btn-make-appointment")).click();

        HomePage loginPage = new HomePage(driver);
        loginPage.login("John Doe", "ThisIsNotAPassword");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("appointment"));
        Assert.assertTrue(driver.getCurrentUrl().contains("appointment"));

        AppointmentPage appointment = new AppointmentPage(driver);
        appointment.makeAppointment("Tokyo CURA Healthcare Center", true, "None","06/11/2026", "The Data is Added via selenium automation");
        appointment.bookApointment();
    }
}
