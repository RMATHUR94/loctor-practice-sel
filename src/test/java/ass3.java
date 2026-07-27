import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ass3 {

    WebDriver driver;
    //not passed coursel control
    @Test
    public void noon() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.noon.com/uae-en/");
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String name = "Lowest prices on top brands";
        getCarouselImages(name);
    }

    public void getCarouselImages(String sectionName)
    {

        List<WebElement> products = driver.findElements(By.xpath(
                "//h2[normalize-space()='" + sectionName + "']" +
                        "/ancestor::div[contains(@class,'_moduleHeaderContainer')]" +
                        "/following-sibling::div//h2[@data-qa='product-box-name']"));

        System.out.println("Total Products : " + products.size());

        for (WebElement product : products) {
            System.out.println(product.getAttribute("title"));
    }
}
}


