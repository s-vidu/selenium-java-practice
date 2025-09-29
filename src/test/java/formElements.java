import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
public class formElements {

    @Test
    public void elements(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        driver.findElement(By.id("name")).sendKeys("Vidumali");
        driver.findElement(By.id("email")).sendKeys("vidumalid@gmail.com");
        driver.findElement(By.id("phone")).sendKeys("0768801260");

// Radio button
        driver.findElement(By.id("male")).click();

// Checkbox
        driver.findElement(By.id("sunday")).click();

// Dropdown
        Select country = new Select(driver.findElement(By.id("country")));
        country.selectByVisibleText("Canada");


    }

}
