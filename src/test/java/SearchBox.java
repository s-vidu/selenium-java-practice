import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SearchBox {
    @Test
    public void googleTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement searchBox = driver.findElement(By.id("Wikipedia1_wikipedia-search-input"));

        // 2️⃣ Type search query
        searchBox.sendKeys("Selenium (software)");

        // 3️⃣ Submit search (press Enter)
        searchBox.sendKeys(Keys.ENTER);
    }
}
