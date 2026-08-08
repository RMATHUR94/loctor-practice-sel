import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ass5 {

    WebDriver driver;

    //Question - I need to locate on element on a table starting with "meeting text" - after finding i need to return other table colm value date and name from the table - currently i have found that meeting element - now tell me how to traverse from that element to patent and print all the child?

    @Test
    public void calpolytable() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://afd.calpoly.edu/web/sample-tables");
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement meetingweb = driver.findElement(By.xpath("(//table)[1]//td[contains(text(),'Meeting')]"));
        String text = meetingweb.getText();
        boolean isMatch = text.contains("Meeting");
        if (isMatch) {
            WebElement row = meetingweb.findElement(By.xpath("./parent::tr"));
            // Get all columns in that row
            List<WebElement> columns = row.findElements(By.tagName("td"));

            System.out.println("----- Row Data -----");

            for (int i = 0; i < columns.size(); i++) {
                System.out.println("Column " + (i + 1) + " : " + columns.get(i).getText());
            }
        }
        else{
            System.out.println("Text does not contain 'Meeting'");
        }
    }

}
