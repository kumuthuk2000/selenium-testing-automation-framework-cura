package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AppointmentPage {

    WebDriver driver;

    public AppointmentPage(WebDriver driver){
        this.driver = driver;
    }

    public void makeAppointment(String facility, boolean tick, String programe, String date, String cmnt){
        selectFacility(facility);
        if(tick){
            checkBox();
        }
        healthCareProgramme(programe);
        selectdate(date);
        comment(cmnt);

    }
    public void selectFacility(String facility){
        Select select = new Select(driver.findElement(By.id("combo_facility")));
        select.selectByVisibleText(facility);
    }

    public void checkBox(){
        WebElement box = driver.findElement(By.id("chk_hospotal_readmission"));
        if(!box.isSelected()){
            box.click();
        }
    }

    public void healthCareProgramme(String programe){
        List<WebElement> elements = driver.findElements(By.xpath("//label[contains(@class, 'radio-inline')]"));
        for (WebElement element : elements){
            WebElement radio = element.findElement(By.tagName("input"));

            if(radio.getAttribute("value").equals(programe)){
                element.click();
                break;
            }
        }
    }

    public void selectdate (String date){
        driver.findElement(By.id("txt_visit_date")).sendKeys("date");
    }
    public void bookApointment (){
        driver.findElement(By.id("btn-book-appointment")).click();
    }

    public void comment(String comment){
        driver.findElement(By.id("txt_comment")).sendKeys("comment");
    }


}
