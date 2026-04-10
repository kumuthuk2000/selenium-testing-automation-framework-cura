package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AppointmentPage;
import pages.HomePage;

public class AppointmentTest extends BaseTest {

    @Test
    public void validAppointmentTest(){
        driver.findElement(By.id("btn-make-appointment")).click();

        HomePage loginPage = new HomePage(driver);
        loginPage.login("John Doe", "ThisIsNotAPassword");

        Assert.assertTrue(driver.getCurrentUrl().contains("appointment"));

        AppointmentPage appointment = new AppointmentPage(driver);
        appointment.makeAppointment("Tokyo CURA Healthcare Center", true, "None","06/11/2026");
        appointment.bookApointment();
        Assert.assertTrue(driver.getCurrentUrl().contains("appointment"), "URL does not contain 'appointment'");

    }
}
