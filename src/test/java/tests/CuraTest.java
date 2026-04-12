package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AppointmentPage;
import pages.HomePage;
import utils.DataProviderUtils;

import java.time.Duration;

public class CuraTest extends BaseTest {

    @Test(
            dataProvider = "loginData",
            dataProviderClass = DataProviderUtils.class
    )
    public void logintest(String username, String password){
        //login
        driver.findElement(By.id("btn-make-appointment")).click();

        HomePage loginPage = new HomePage(driver);
        loginPage.login(username, password);

        By errormsg = By.xpath("//p[@class ='lead text-danger']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("appointment"),
                ExpectedConditions.visibilityOfElementLocated(errormsg)
        ));

        String currentURL = driver.getCurrentUrl();

        if(currentURL.contains("appointment")){
            Assert.assertTrue(true);
            System.out.println("Login Successfully with \n user name :" +username +" \n password : "+ password);
        }else{
            String actualerror = driver.findElement(errormsg).getText();
            System.out.println("Unable to login with \n user name :" +username +" \n password : "+ password + " \n " +actualerror);

            Assert.assertTrue(false);
        }

    }

    @Test(
            dataProvider = "appointmentData",
            dataProviderClass = DataProviderUtils.class
    )
    public void validAppointmentTest(String facility, boolean tick, String programe, String date, String com){
        //login
        driver.findElement(By.id("btn-make-appointment")).click();

        HomePage loginPage = new HomePage(driver);
        loginPage.login("John Doe", "ThisIsNotAPassword");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("appointment") );

        String currentURL = driver.getCurrentUrl();
        if(currentURL.contains("appointment")){
            //create appointment
            AppointmentPage appointment = new AppointmentPage(driver);
            appointment.makeAppointment(facility, tick, programe, date, com);
            appointment.bookApointment();

            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait2.until(ExpectedConditions.urlContains("summary"));
            Assert.assertTrue(driver.findElement(By.xpath("//h2[text() = 'Appointment Confirmation']")).isDisplayed(),"appointment record fail..");
        }
    }
}
