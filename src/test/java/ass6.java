import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    public static void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://www.ixigo.com/");
        // 1. Click the "From" display box — anchor on the visible caption text, not the class list
        By fromDisplayBox = By.xpath("//p[normalize-space()='From']/ancestor::div[contains(@class,'items-center')]");
        WebElement form =  wait.until(ExpectedConditions.elementToBeClickable(fromDisplayBox));
        form.click();

        By fromInputLocator = By.xpath(
                "//label[normalize-space()='From']/following-sibling::input"
        );

        WebElement fromInput = driver.findElement(fromInputLocator);

        fromInput.click();

        Thread.sleep(500);
        // Re-find the element after click

        fromInput = driver.findElement(fromInputLocator);
        fromInput.sendKeys(Keys.CONTROL, "a");
        fromInput.sendKeys(Keys.BACK_SPACE);
        fromInput.sendKeys("Delhi");
        WebElement Del = driver.findElement(By.xpath("//div[contains(@class,'items-center')]/div[contains(@class,'inline-flex')]/span[normalize-space()='DEL']"));
        wait.until(ExpectedConditions.visibilityOf(Del)).click();

        WebElement toInput = driver.findElement(By.xpath("//label[normalize-space()='To']/ancestor::div[contains(@class,'inline-flex')]"));
        wait.until(ExpectedConditions.visibilityOf(toInput)).click();
        Thread.sleep(500);
        WebElement toInputLocators = driver.findElement(By.xpath("//label[normalize-space()='To']/following-sibling::input"));
        toInputLocators.click();
        toInputLocators.sendKeys("Kolkata");
        Thread.sleep(3000);
        WebElement CCU = driver.findElement(By.xpath("//div[@role='listitem'][.//span[normalize-space()='CCU']]"));
        wait.until(ExpectedConditions.elementToBeClickable(CCU)).click();

        CCU.click();
   }
}
