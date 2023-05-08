package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TravelProject {


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.easyjet.com/tr");
        Thread.sleep(5000);
        driver.findElement(By.id("ensCloseBanner")).click();

        
        driver.findElement(By.cssSelector("input[name='origin']")).click();
        driver.findElement(By.cssSelector("input[name='origin']")).sendKeys("Lond");

        List<WebElement> origins = new WebDriverWait(driver,20).
                until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#ui-id-1 li>a>span")));

        for (WebElement origin : origins) {
            if(origin.getText().contains("Luton")){
                origin.click();
            }


        }
        
    }

}
