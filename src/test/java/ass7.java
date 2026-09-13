import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ass7 {
    static WebDriver driver;
    @Test
    public static void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alertdialog']")));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Dismiss')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nav-search-field ']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='twotabsearchtextbox']"))).sendKeys("iphone 17 pro");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='iphone 17 pro max']"))).click();
    }
}
