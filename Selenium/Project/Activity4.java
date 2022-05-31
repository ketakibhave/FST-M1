package activities_Board;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/jobs");
    }

    @Test
    public void exampleTestCase() {
        // Check the text on the page
        WebElement heading2 = driver.findElement(By.xpath("//div/p[3]"));

        //Confirm if text is present
        System.out.println("Text is: " +heading2.getText());
        boolean containsText = heading2.getText().contains("Quia quis non");
        System.out.println("yes or no??"+containsText);
        Assert.assertEquals(true, containsText);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        System.out.println("tearing down");
        driver.quit();
    }
}
