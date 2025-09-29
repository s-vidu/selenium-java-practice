import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Scrolling {

    @Test
    public void sliders() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Check if iframes exist on the page
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("Number of iframes found: " + iframes.size());

        // If slider is inside an iframe, switch to it
        if (iframes.size() > 0) {
            try {
                // Wait for iframe to be available and switch to it
                WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
                driver.switchTo().frame(iframe);
                System.out.println("Switched to iframe");
            } catch (Exception e) {
                System.out.println("Could not switch to iframe: " + e.getMessage());
            }
        }

        // Initialize Actions
        Actions actions = new Actions(driver);

        try {
            // Wait for slider to be present and interact with it
            WebElement slider = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//input[@type='range']")
            ));

            // Move slider by 50 pixels to the right
            actions.dragAndDropBy(slider, 50, 0).perform();
            System.out.println("Slider moved successfully");

            // Switch back to main content if we were in an iframe
            if (iframes.size() > 0) {
                driver.switchTo().defaultContent();
                System.out.println("Switched back to main content");
            }

        } catch (Exception e) {
            System.out.println("Slider not found or could not be moved: " + e.getMessage());

            // If slider wasn't in iframe, switch back and try in main content
            if (iframes.size() > 0) {
                driver.switchTo().defaultContent();

                WebElement slider = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//input[@type='range']")
                ));
                actions.dragAndDropBy(slider, 50, 0).perform();
                System.out.println("Slider moved successfully from main content");
            }
        }

        // Scroll to footer using JavascriptExecutor
        try {
            WebElement footer = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("footer")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
            System.out.println("Scrolled to footer");

            // Wait a bit to see the scroll action
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Footer not found: " + e.getMessage());
        }

        driver.quit();
    }
}