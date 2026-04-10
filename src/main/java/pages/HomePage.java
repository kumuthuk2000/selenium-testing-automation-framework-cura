package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver ;

    By username = By.id("txt-username");
    By psw = By.id("txt-password");
    By loginBTN = By.id("btn-login");
    By toggleBTN = By.id("menu-toggle");
    By logoutBTN = By.linkText("Logout");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void login(String user, String password){
        driver.findElement(username).sendKeys(user);
        driver.findElement(psw).sendKeys(password);
        driver.findElement(loginBTN).click();
    }

    public void logout(){
        driver.findElement(toggleBTN).click();
        driver.findElement(logoutBTN).click();
    }


}
