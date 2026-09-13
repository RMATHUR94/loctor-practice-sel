import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
//**Naukri.com** — used the same way as Ixigo: locate the job-search keyword box and its autocomplete/recent-searches dropdown,
//since Naukri's search field shows a suggestion list that has to be waited on rather than assumed present.

public class ass8 {
    static WebDriver driver;

    static By searchBox = By.xpath("//input[contains(@placeholder,'Enter skills')]");
    static By pick = By.xpath("//ul[@class='layer-wrap']/li/div[@title='QA Manual Testing']");
    @Test
    public static void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.naukri.com/");
        WebElement search = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchBox)
        );

        search.click();
        search.sendKeys("qa");
        WebElement option = wait.until(
                ExpectedConditions.visibilityOfElementLocated(pick)
        );
        option.click();
    }
}