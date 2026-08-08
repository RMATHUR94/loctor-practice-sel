import dataProviders.ExcelDataProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelUtil;

import java.util.ArrayList;

public class DatadriveDemoTestng {

    WebDriver driver;
    @BeforeMethod
    public void Setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/contact/");
    }


    @Test(dataProvider = "formdata",dataProviderClass = ExcelDataProvider.class)
    public void datadrive(String firstname,String lastname,String email,String msg) throws InterruptedException {

        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='text' and @id='wpforms-161-field_0']")).sendKeys(firstname);
        driver.findElement(By.xpath("//input[@type='text' and @id='wpforms-161-field_0-last']")).sendKeys(lastname);
        driver.findElement(By.xpath("//input[@type='email' and @id='wpforms-161-field_1']")).sendKeys(email);
        driver.findElement(By.xpath("//div[@id='wpforms-161-field_2-container']/textarea")).sendKeys(msg);
        Thread.sleep(2000);
        driver.switchTo().frame(
                driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"))
        );
        WebElement checkbox = driver.findElement(By.id("recaptcha-anchor"));
        checkbox.click();
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
