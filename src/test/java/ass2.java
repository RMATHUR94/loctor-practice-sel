import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class ass2 {
    WebDriver driver;
    @Test
    @Parameters({"url"})
    public void ass2(String url) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        long endtime = System.currentTimeMillis()+ 20000;
        while(System.currentTimeMillis()<endtime)
        {

            WebElement population = driver.findElement(
                    By.cssSelector("span[rel='current_population']"));

            System.out.println("Current Population : " + population.getText());


             WebElement Birth = driver.findElement(
                    By.cssSelector("span[rel='births_today']"));

            System.out.println("birth today" +Birth.getText());

            WebElement Bith_this_year = driver.findElement(
                    By.cssSelector("span[rel='births_this_year']"));

            System.out.println("birth this year" +Bith_this_year.getText());
        }
    }
}
