package activities_Board;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
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
        // Check the Image on the page
       WebElement imageScreen = driver.findElement(By.xpath("//div/img"));

        //Print the URL of the image
        System.out.println("Image URL is: " +imageScreen.getAttribute("src"));
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        System.out.println("tearing down");
        driver.quit();
    }
}
