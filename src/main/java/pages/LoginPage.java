package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver ;

    By username = By.id("txt-username");
    By psw = By.id("txt-password");
    By loginBTN = By.id("btn-login");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void login(String user, String password){
        driver.findElement(username).sendKeys(user);
        driver.findElement(psw).sendKeys(password);
        driver.findElement(loginBTN).click();
    }

}
