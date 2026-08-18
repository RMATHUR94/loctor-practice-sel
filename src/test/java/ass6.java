import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ass6 {

    static WebDriver driver;

    @Test
    public static void test()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://www.ixigo.com/");
// 1. Click the "From" display box — anchor on the visible caption text, not the class list
        By fromDisplayBox = By.xpath(
                "//*[normalize-space(text())='From']/ancestor::div[contains(@class,'items-center')][1]");
       WebElement form =  wait.until(ExpectedConditions.elementToBeClickable(fromDisplayBox));
        form.click();
        form.clear();



//// 2. Now the sibling that currently has class="... hidden ..." should drop 'hidden' and reveal an input
//        WebElement fromInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//input[contains(@placeholder,'City') or contains(@id,'from') or contains(@name,'from')]")));
//        fromInput.clear();
//        fromInput.sendKeys("Delhi");
   }
}
