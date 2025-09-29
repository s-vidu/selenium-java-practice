import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class screenshot {
@Test
    public void finalT() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://testautomationpractice.blogspot.com/");

            // Take screenshot
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(src, new File("C:\\screenshots\\final_test.png"));

            System.out.println("Screenshot taken successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            driver.quit(); // Always close the browser
        }
    }

    public static void main(String[] args) {
        new screenshot().finalT();
    }
}
