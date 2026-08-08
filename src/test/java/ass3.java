import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
@Test
public void getElectronicsName() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.noon.com/uae-en/");
    Thread.sleep(5000);
    Actions actions  = new Actions(driver);

    WebElement electronics = driver.findElement(
            By.xpath("//span[text()='Electronics']/parent::a"));

    actions.moveToElement(electronics).pause(Duration.ofSeconds(2)).perform();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text()='Electronics']/ancestor::li//ul[@class='_links_1l8oc_95']")));
    List<WebElement> products = driver.findElements(By.xpath("//span[text()='Electronics']/ancestor::li//ul[@class='_links_1l8oc_95']//a"));

    System.out.println("Electronics Categories");
    System.out.println("----------------------");

    for(WebElement product : products) {
        System.out.println(product.getText());
    }
    }

    @Test
    public void getAlltheMenu() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.noon.com/uae-en/");

        Thread.sleep(5000);

        Actions actions = new Actions(driver);

        List<WebElement> categories = driver.findElements(
                By.xpath("//ul[contains(@class,'wrapper')]//li[@data-qa]"));

        System.out.println("Total Categories : " + categories.size());

        for (WebElement category : categories) {
            String categoryName = category.findElement(By.tagName("span")).getText();

            System.out.println("\n===========================");
            System.out.println(categoryName);
            System.out.println("===========================");

            // Hover on current category
            actions.moveToElement(category)
                    .pause(Duration.ofSeconds(2))
                    .perform();

            // Find submenu links inside the current <li>
            List<WebElement> items = category.findElements(By.xpath(".//div//ul//a"));

            for (WebElement item : items) {
                String text = item.getText().trim();

                if (!text.isEmpty())
                    System.out.println(text);
            }
        }
    }
}



