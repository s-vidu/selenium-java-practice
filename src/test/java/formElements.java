import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        driver.findElement(By.id("textarea")).sendKeys("Yakkalamulla, Galle");
        driver.findElement(By.id("datepicker")).click();
        driver.findElement(By.xpath("//a[text()='9']")).click();

        driver.findElement(By.id("txtDate")).click();
        driver.findElement(By.xpath("//a[text()='9']")).click();

        driver.findElement(By.id("start-date")).sendKeys("09/03/2025");
        driver.findElement(By.id("end-date")).sendKeys("09/05/2025");

// Radio button
        driver.findElement(By.id("female")).click();

// Checkbox
        driver.findElement(By.id("sunday")).click();

// Dropdown
        Select country = new Select(driver.findElement(By.id("country")));
        country.selectByVisibleText("India");

        driver.findElement(By.cssSelector(".submit-btn")).click();

// Example: check if result appears after clicking
        WebElement result = driver.findElement(By.id("result"));
        System.out.println("Result: " + result.getText());


    }

}
