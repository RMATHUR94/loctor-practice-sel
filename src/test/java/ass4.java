import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
//test passed


public class ass4 {

    WebDriver driver;

    @Test
    public void brokenLinks() throws InterruptedException, MalformedURLException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://uae.sharafdg.com/");
        Thread.sleep(5000);
       List<WebElement> al =  driver.findElements(By.tagName("a"));

       for(WebElement link : al)
       {
           String url =   link.getAttribute("href");

           if (url == null || url.isEmpty()) {
               continue;
           }


           try{
               URL linkUrl = new URL(url);
               HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();
               connection.setRequestMethod("GET");
               connection.connect();
               int responseCode = connection.getResponseCode();

               if (responseCode >= 400) {

                   System.out.println("❌ Broken Link : " + url);
                   System.out.println("Response Code : " + responseCode);

               } else {

                   System.out.println("✅ Valid Link : " + url);
                   System.out.println("Response Code : " + responseCode);
               }

               connection.disconnect();

           } catch (Exception e) {
               System.out.println("Exception : " + url);
           }
       }
        driver.quit();
    }
}
