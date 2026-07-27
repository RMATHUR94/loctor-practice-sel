import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class calprac {
    public class Cal1 {

        WebDriver driver;

        @BeforeMethod
        public void setup() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @Test
        public void googleTest() throws InterruptedException {
            String amonth = "December 2026";
            driver.get("https://www.redbus.in/");

            WebElement da = driver.findElement(By.xpath(" //div[@aria-label='Select date of journey']"));

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.visibilityOf(da));
            da.click();
            Thread.sleep(2000);

         //  String month = driver.findElement(By.xpath("//div[@role='dialog']//p[@class='monthYear___fe577e']")).getText();

            // Locate the "Next Month" button
            WebElement nextbtn = driver.findElement(
                    By.xpath("//div[@role='dialog']//i[@aria-label='Next month']")
            );

// Read the currently displayed month and year
            String month = driver.findElement(
                    By.xpath("//div[@role='dialog']//p[@aria-live='polite']")
            ).getText().replace("\n", " ");

            System.out.println("Current Month : " + month);

// Check if the displayed month is the target month
            if (month.equals(amonth))
            {
                System.out.println("Target month found.");
              //  break;      // Exit the loop
            }
            else
            {
                // Not the required month, so go to the next month
                nextbtn.click();
            }

//        @AfterMethod
//        public void tearDown() {
//            driver.quit();
//        }
    }
}
}
